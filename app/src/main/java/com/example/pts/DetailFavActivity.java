package com.example.pts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import io.realm.Realm;

public class DetailFavActivity extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar mTopToolbar;
    ImageView poster, fav;
    TextView detaiDesc, detailTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_fav_activity);

        mTopToolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mTopToolbar);

        Intent intent = getIntent();
        String strSport = intent.getStringExtra("poster");
        String title = intent.getStringExtra("title");
        String desc = intent.getStringExtra("description");
        String format = intent.getStringExtra("format");

        fav = (ImageView) findViewById(R.id.unfavBtn);
        poster = (ImageView) findViewById(R.id.detail_poster);
        detailTitle = (TextView) findViewById(R.id.detail_title);
        detaiDesc = (TextView) findViewById(R.id.detail_description);

        detailTitle.setText(title);
        detaiDesc.setText(desc);
        Picasso.get().load(strSport).into(poster);

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        
                    }
                });
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
