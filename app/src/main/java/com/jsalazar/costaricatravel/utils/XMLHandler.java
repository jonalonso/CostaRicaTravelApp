package com.jsalazar.costaricatravel.utils;

public class XMLHandler {
    public static String readCurrencyValue(String xml){
        int firstIndex = xml.indexOf("<NUM_VALOR>");
        int lastIndex = xml.indexOf("</NUM_VALOR>");
        if(firstIndex==-1 || lastIndex==-1){
            return "0";
        }
        firstIndex += 11;
        return xml.substring(firstIndex,lastIndex);
    }
}
