package com.jsalazar.costaricatravel.constants;

public enum HttpMethod {
    Get("GET");

    private final String value;
    HttpMethod(String i) {
        this.value = i;
    }

    public String getValue() {
        return this.value;
    }
}
