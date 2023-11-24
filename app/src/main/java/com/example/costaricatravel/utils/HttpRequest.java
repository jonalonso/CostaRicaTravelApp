package com.example.costaricatravel.utils;

import com.example.costaricatravel.constants.HttpMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class HttpRequest {

    public String getRequest(String urlAddress, Map<String, String> params){
        try {

            URL obj = new URL(params.size()>0?urlAddress+"?"+ParameterStringBuilder.getParamsString(params):urlAddress);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod(HttpMethod.Get.getValue());

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return response.toString();
            }
            return "";
        } catch (MalformedURLException e) {
            return "";
        }catch (IOException e) {
            return "";
        }
    }
}
