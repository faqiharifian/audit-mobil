package com.digitcreativestudio.auditmobil.connection.parser;

import com.digitcreativestudio.auditmobil.entities.User;
import com.google.gson.annotations.SerializedName;

/**
 * Created by faqih on 19/05/17.
 */

public class LoginParser extends Parser {
    @SerializedName("data")
    User user;

    public User getUser() {
        return user;
    }
}
