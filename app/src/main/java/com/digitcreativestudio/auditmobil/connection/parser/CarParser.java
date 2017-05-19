package com.digitcreativestudio.auditmobil.connection.parser;

import com.digitcreativestudio.auditmobil.entities.Car;
import com.google.gson.annotations.SerializedName;

/**
 * Created by faqih on 19/05/17.
 */

public class CarParser extends Parser {
    @SerializedName("data")
    Car car;

    public Car getCar() {
        return car;
    }
}
