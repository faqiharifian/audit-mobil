package com.digitcreativestudio.auditmobil.connection.parser;

import com.google.gson.annotations.SerializedName;

/**
 * Created by faqih on 19/05/17.
 */

public class Parser {
    @SerializedName("success")
    boolean success;

    @SerializedName("message")
    String message;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
