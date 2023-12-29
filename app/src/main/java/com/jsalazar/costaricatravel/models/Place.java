package com.jsalazar.costaricatravel.models;

import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class Place {
    private int id;
    private int titleId;
    private int descriptionId;
    private int mainPictureId;
    private int Price;
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




    
}
