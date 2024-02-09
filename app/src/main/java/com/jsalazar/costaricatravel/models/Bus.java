package com.jsalazar.costaricatravel.models;

public class Bus {
    private final String origin;
    private final String destination;
    private final String originURL;
    private final String destinationURL;

    private final String distance;

    public Bus(String origin, String destination, String originURL, String destinationURL, String distance) {
        this.origin = origin;
        this.destination = destination;
        this.originURL = originURL;
        this.destinationURL = destinationURL;
        this.distance = distance;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getOriginURL() {
        return originURL;
    }

    public String getDestinationURL() {
        return destinationURL;
    }

    public String getDistance() {
        return distance;
    }
}
