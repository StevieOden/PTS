package com.example.pts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentHome extends Fragment{

    private RecyclerView list_item;
    private ArrayList<SportModel> arlist;
    private SportAdapter sportAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        list_item = view.findViewById(R.id.list_item);
        arlist = new ArrayList<>();
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
    }

    void getData(){
        AndroidNetworking.get("https://www.thesportsdb.com/api/v1/json/2/all_sports.php")
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray result = response.getJSONArray("sports");
                            for (int i = 0; i < result.length(); i++) {
                                JSONObject object = result.getJSONObject(i);
                                String strSport = object.getString("strSport");//title
                                String strSportDescription = object.getString("strSportDescription");//description
                                String strFormat = object.getString("strFormat");
                                String strSportThumb = object.getString("strSportThumb");//poster
                                arlist.add(new SportModel(strSport, strSportDescription, strFormat, strSportThumb));
                            }
                            sportAdapter = new SportAdapter(arlist);
                            RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
                            list_item.setLayoutManager(manager);
                            list_item.setAdapter(sportAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Toast.makeText(getContext(), "Failed to load data", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
