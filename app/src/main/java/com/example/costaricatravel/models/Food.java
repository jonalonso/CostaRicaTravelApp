package com.example.costaricatravel.models;

public class Food {
    private Integer foodNameId;
    private Integer imgId;
    private Integer descriptionId;

    private String spanish;

    public Food(Integer foodNameId, Integer imgId, Integer descriptionId, String spanish) {
        this.foodNameId = foodNameId;
        this.imgId = imgId;
        this.descriptionId = descriptionId;
        this.spanish = spanish;
    }

    public Integer getFoodNameId() {
        return foodNameId;
    }

    public void setFoodNameId(Integer foodNameId) {
        this.foodNameId = foodNameId;
    }

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public Integer getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(Integer descriptionId) {
        this.descriptionId = descriptionId;
    }

    public String getSpanish() {
        return spanish;
    }

    public void setSpanish(String spanish) {
        this.spanish = spanish;
    }
}
