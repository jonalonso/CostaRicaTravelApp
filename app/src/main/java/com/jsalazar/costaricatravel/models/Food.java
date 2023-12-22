package com.jsalazar.costaricatravel.models;

public class Food {
    private final Integer foodNameId;
    private final Integer imgId;
    private final Integer descriptionId;

    private final String spanish;

    private final String priceRange;

    public Food(Integer foodNameId, Integer imgId, Integer descriptionId, String spanish, String price) {
        this.foodNameId = foodNameId;
        this.imgId = imgId;
        this.descriptionId = descriptionId;
        this.spanish = spanish;
        this.priceRange = price;
    }

    public Integer getFoodNameId() {
        return foodNameId;
    }

    public Integer getImgId() {
        return imgId;
    }

    public Integer getDescriptionId() {
        return descriptionId;
    }

    public String getSpanish() {
        return spanish;
    }

    public String getPriceRange(){ return priceRange;}

}
