package com.exercise.springboot_app.model;

public class Address {
    private int id;
    private String street;
    private String countryCode;

    public Address() {
    }

    public Address(int id, String street, String countryCode) {
        this.id = id;
        this.street = street;
        this.countryCode = countryCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
