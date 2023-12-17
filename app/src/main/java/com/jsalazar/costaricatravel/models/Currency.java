package com.jsalazar.costaricatravel.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Currency {
    private final Integer imgId;
    private final Integer nameId;
    private double customValue;
    private final double originalValue;

    public Currency(Integer imgId, Integer nameId, double customValue) {
        this.imgId = imgId;
        this.nameId = nameId;
        this.customValue = new BigDecimal(customValue).setScale(2, RoundingMode.HALF_UP).doubleValue();
        this.originalValue = this.customValue;
    }

    public Integer getImgId() {
        return imgId;
    }

    public Integer getNameId() {
        return nameId;
    }

    public double getCustomValue() {
        return customValue;
    }

    public void setCustomValue(double customValue) {
        this.customValue = customValue;
    }

    public double getOriginalValue() {
        return originalValue;
    }

}
