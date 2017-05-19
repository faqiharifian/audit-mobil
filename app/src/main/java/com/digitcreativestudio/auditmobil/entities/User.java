package com.digitcreativestudio.auditmobil.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by faqih on 19/05/17.
 */

public class User {
    @SerializedName("id")
    int id;
    @SerializedName("email")
    String email;
    @SerializedName("name")
    String name;

    public User(){}

    public User(int id, String email){
        this.id = id;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
