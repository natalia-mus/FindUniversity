package com.example.finduniversity.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class University {
    private String country;
    @SerializedName("web_pages")
    private List<String> webPages;
    private String name;
    private List<String> domains;

    public University(String country, List<String> webPages, String name, List<String> domains) {
        this.country = country;
        this.webPages = webPages;
        this.name = name;
        this.domains = domains;
    }

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
}
