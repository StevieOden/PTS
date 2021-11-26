package com.example.pts;

import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {
    Realm realm;

    public RealmHelper(Realm realm) {
        this.realm = realm;
    }

    public static void save(final SportModel SportModel){
        Realm.getDefaultInstance().executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null) {
                    Log.e("Created", "Database was created");
                    realm.copyToRealm(SportModel);
                } else {
                    Log.e("ppppp", "execute: Database not Exist");
                }
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("Suksess", "Data telah berhasil");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.e("Gagal", "Data tidak berhasil");
            }
        });
    }

    public static SportModel getOneModel(final String strSport) {
        return Realm.getDefaultInstance().where(SportModel.class).equalTo("strSport", strSport).findFirst();
    }

    public List<SportModel> getAllModel() {
        RealmResults<SportModel> models = Realm.getDefaultInstance().where(SportModel.class).findAll();
        return models;
    }

}
