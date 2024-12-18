package com.spring_boot.redis.RestAPI_Redis.models;


import java.io.Serializable;

public class Medicine implements Serializable {
    private String id;
    private String name;
    private String expiry;
    private String companyName;
    private int count;


    public Medicine() {
    }

    public Medicine(String id, String name, String expiry, String companyName, int count) {
        this.id = id;
        this.name = name;
        this.expiry = expiry;
        this.companyName = companyName;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", expiry='" + expiry + '\'' +
                ", companyName='" + companyName + '\'' +
                ", count=" + count +
                '}';
    }
}
