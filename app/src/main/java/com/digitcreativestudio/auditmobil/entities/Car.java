package com.digitcreativestudio.auditmobil.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by faqih on 19/05/17.
 */

public class Car {
    @SerializedName("id")
    int id;
    @SerializedName("police_number")
    String policeNumber;
    @SerializedName("manager")
    String manager;
    @SerializedName("last_check_date")
    String lastCheck;
    @SerializedName("check_date")
    String checkDate;
    @SerializedName("brand_year")
    String brandYear;
    @SerializedName("product")
    String product;
    @SerializedName("capacity")
    String capacity;
    @SerializedName("location")
    String location;

    public void setId(int id) {
        this.id = id;
    }

    public void setPoliceNumber(String policeNumber) {
        this.policeNumber = policeNumber;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setLastCheck(String lastCheck) {
        this.lastCheck = lastCheck;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public void setBrandYear(String brandYear) {
        this.brandYear = brandYear;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getPoliceNumber() {
        return policeNumber;
    }

    public String getManager() {
        return manager;
    }

    public String getLastCheck() {
        return lastCheck;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public String getBrandYear() {
        return brandYear;
    }

    public String getProduct() {
        return product;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getLocation() {
        return location;
    }
}
