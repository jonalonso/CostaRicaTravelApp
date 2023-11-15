package com.example.costaricatravel.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HttpRequestParams {
    static SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");

    public static Map<String,String> getMoneyExchangeRateParam(String indicator){
        Date date = new Date();
        Map<String,String> response = new HashMap<>();
        response.put("Indicador",indicator);
        response.put("FechaInicio",DateFor.format(date));
        response.put("FechaFinal",DateFor.format(date));
        response.put("Nombre","Jonathan Salazar");
        response.put("SubNiveles","N");
        response.put("CorreoElectronico","salazargarciajonathan@gmail.com");
        response.put("Token","A30R3AMT0A");
        return response;
    }
}
