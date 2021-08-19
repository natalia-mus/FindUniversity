package com.example.finduniversity.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class University implements Parcelable {
    private String country;
    @SerializedName("web_pages")
    private List<String> webPages;
    private String name;
    private List<String> domains;

    protected University(Parcel in) {
        country = in.readString();
        webPages = in.createStringArrayList();
        name = in.readString();
        domains = in.createStringArrayList();
    }

    public static final Creator<University> CREATOR = new Creator<University>() {
        @Override
        public University createFromParcel(Parcel in) {
            return new University(in);
        }

        @Override
        public University[] newArray(int size) {
            return new University[size];
        }
    };

    public String getCountry() {
        return country;
    }

    public List<String> getWebPages() {
        return webPages;
    }

    public String getName() {
        return name;
    }

    public List<String> getDomains() {
        return domains;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(country);
        parcel.writeStringList(webPages);
        parcel.writeString(name);
        parcel.writeStringList(domains);
    }
}
