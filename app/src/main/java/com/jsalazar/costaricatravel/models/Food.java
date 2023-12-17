package com.jsalazar.costaricatravel.models;

public class Food {
    private final Integer foodNameId;
    private final Integer imgId;
    private final Integer descriptionId;

    private final String spanish;

    public Food(Integer foodNameId, Integer imgId, Integer descriptionId, String spanish) {
        this.foodNameId = foodNameId;
        this.imgId = imgId;
        this.descriptionId = descriptionId;
        this.spanish = spanish;
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

}
