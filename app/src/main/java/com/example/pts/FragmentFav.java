package com.example.pts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class FragmentFav extends Fragment{

    private RecyclerView output;
    private List<SportModel> sportModels;
    private FavAdapter favAdapter;
    Realm realm;
    RealmHelper realmHelper;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fav, container, false);
        sportModels = new ArrayList<>();
        output = view.findViewById(R.id.rv_show);

        Realm.init(view.getContext());
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        realmHelper = new RealmHelper(realm);
        sportModels = realmHelper.getAllModel();

        favAdapter = new FavAdapter(sportModels);
        RecyclerView.LayoutManager rvmanager = new LinearLayoutManager(getActivity());

        output.setAdapter(favAdapter);
        output.setLayoutManager(rvmanager);

        return view;
    }

}



