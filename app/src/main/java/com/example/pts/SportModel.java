package com.example.pts;

import io.realm.RealmObject;

public class SportModel extends RealmObject {
    private String strSport;
    private String strSportDescription;
    private String strFormat;
    private String strSportThumb;

    public SportModel() {
    }

    public SportModel(String strSport, String strSportDescription, String strFormat, String strSportThumb) {
        this.strSport = strSport;
        this.strSportDescription = strSportDescription;
        this.strFormat = strFormat;
        this.strSportThumb = strSportThumb;
    }

    public SportModel(String strSport, String title, String format) {
        this.strSportThumb = strSport;
        this.strSport = title;
        this.strFormat = format;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getStrSportDescription() {
        return strSportDescription;
    }

    public void setStrSportDescription(String strSportDescription) {
        this.strSportDescription = strSportDescription;
    }

    public String getStrFormat() {
        return strFormat;
    }

    public void setStrFormat(String strFormat) {
        this.strFormat = strFormat;
    }

    public String getStrSportThumb() {
        return strSportThumb;
    }

    public void setStrSportThumb(String strSportThumb) {
        this.strSportThumb = strSportThumb;
    }

}
