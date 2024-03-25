package com.jsalazar.costaricatravel.models;

public class Place {
    private final int titleId;
    private final int descriptionId;
    private final int downloadLinkId;
    private final String locationURL;
    private final int onlineBookingURL;
    private final int priceDisclaimerId;
    private final int scheduleDisclaimerId;

    private final int[] imgs;

    public Place(int titleId, int descriptionId, int downloadLinkId, String locationURL, int onlineBookingURL, int priceDisclaimerId, int scheduleDisclaimerId, int[] imgs) {
        this.titleId = titleId;
        this.descriptionId = descriptionId;
        this.downloadLinkId = downloadLinkId;
        this.locationURL = locationURL;
        this.onlineBookingURL = onlineBookingURL;
        this.priceDisclaimerId = priceDisclaimerId;
        this.scheduleDisclaimerId = scheduleDisclaimerId;
        this.imgs = imgs;
    }

    public int getTitleId() {
        return titleId;
    }


    public int getDescriptionId() {
        return descriptionId;
    }

    public int getDownloadLinkId() {
        return downloadLinkId;
    }

    public String getLocationURL() {
        return locationURL;
    }

    public int getOnlineBookingURL() {
        return onlineBookingURL;
    }


    public int getPriceDisclaimerId() {
        return priceDisclaimerId;
    }


    public int getScheduleDisclaimerId() {
        return scheduleDisclaimerId;
    }


    public int[] getImgs() {
        return imgs;
    }
}
