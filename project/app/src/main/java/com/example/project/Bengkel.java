package com.example.project;

public class Bengkel {
    private int photoId;
    private String name;
    private String address;
    private String price;

    public Bengkel(int photoId, String name, String address, String price){
        this.photoId = photoId;
        this.name = name;
        this.address = address;
        this.price = price;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setJob(String price) {
        this.price = price;
    }

}
