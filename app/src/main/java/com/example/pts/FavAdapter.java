package com.example.pts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import io.realm.Realm;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.MyViewHolder> {

    List<SportModel> list;
    Context context;

    public  FavAdapter(Context context, List<SportModel>list){
        this.list = list;
        this.context = context;
    }

    public FavAdapter(List<SportModel> sportModels) {
        this.list = sportModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.fav_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SportModel sportModel = list.get(position);
        holder.strSport.setText(sportModel.getStrSport());
        Picasso.get()
                .load(sportModel.getStrSportThumb())
                .into(holder.strSportThumb);
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailFavActivity.class);
                intent.putExtra("poster", sportModel.getStrSportThumb());
                intent.putExtra("title", sportModel.getStrSport());
                intent.putExtra("description", sportModel.getStrSportDescription());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView strSport;
        private ImageView strSportThumb, unFav;
        private CardView cv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cv = itemView.findViewById(R.id.cvFav);
            unFav = itemView.findViewById(R.id.unfavBtn);
            strSport = itemView.findViewById(R.id.favTextView);
            strSportThumb = itemView.findViewById(R.id.favImageView);
        }
    }
}
