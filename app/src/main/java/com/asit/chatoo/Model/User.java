package com.asit.chatoo.Model;

public class User {
    private String username;
    private String id;
    private String imageURL;
    private String status;
    private String search;


    public User(String username, String id, String imageURL, String status, String search) {
        this.username = username;
        this.id = id;
        this.imageURL = imageURL;
        this.status = status;
        this.search = search;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}