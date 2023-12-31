package com.jsalazar.costaricatravel.models;

import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class Place {
    private int id;
    private int titleId;
    private int descriptionId;
    private int mainPictureId;
    private int price;
    private int foreignPrice;
    private ArrayList<SlideModel> pictures;
    private String province;
    private double latitude;
    private double longitude;
    private boolean isFavorite;
    private String[] schedule = new String[7]; //sunday will be position 0
    private String phoneNumber;
    private String webSite;
    private String bookingSite;

    public Place(int id, int titleId, int descriptionId, int mainPictureId, int price, int foreignPrice, ArrayList<SlideModel> pictures, String province, double latitude, double longitude, boolean isFavorite, String[] schedule, String phoneNumber, String webSite, String bookingSite) {
        this.id = id;
        this.titleId = titleId;
        this.descriptionId = descriptionId;
        this.mainPictureId = mainPictureId;
        this.price = price;
        this.foreignPrice = foreignPrice;
        this.pictures = pictures;
        this.province = province;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isFavorite = isFavorite;
        this.schedule = schedule;
        this.phoneNumber = phoneNumber;
        this.webSite = webSite;
        this.bookingSite = bookingSite;
    }

    public int getId() {
        return id;
    }

    public int getTitleId() {
        return titleId;
    }

    public int getDescriptionId() {
        return descriptionId;
    }

    public int getMainPictureId() {
        return mainPictureId;
    }

    public int getPrice() {
        return price;
    }

    public int getForeignPrice() {
        return foreignPrice;
    }

    public ArrayList<SlideModel> getPictures() {
        return pictures;
    }

    public String getProvince() {
        return province;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public String[] getSchedule() {
        return schedule;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWebSite() {
        return webSite;
    }

    public String getBookingSite() {
        return bookingSite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
