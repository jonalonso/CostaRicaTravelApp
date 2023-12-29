package com.jsalazar.costaricatravel.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class HttpRequestParams {
    static SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

    public static Map<String,String> getMoneyExchangeRateParam(String indicator){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        int hourOfDay = c.get(Calendar.HOUR_OF_DAY);
        if(dayOfWeek == 7){ //saturday
            c.add(Calendar.DAY_OF_YEAR, -1);
        }else if(dayOfWeek == 1){ //sunday
            c.add(Calendar.DAY_OF_YEAR, -2);
        }else if(dayOfWeek == 2 && hourOfDay<9){ //monday before 9am
            c.add(Calendar.DAY_OF_YEAR, -3);
        }else if(dayOfWeek > 2 && dayOfWeek <= 6 && hourOfDay<9){ //every other weekday before 9am
            c.add(Calendar.DAY_OF_YEAR, -1);
        }
        date = c.getTime();
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
