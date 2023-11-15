package com.example.costaricatravel.utils;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

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
