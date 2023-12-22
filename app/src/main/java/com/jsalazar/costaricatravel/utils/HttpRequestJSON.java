package com.jsalazar.costaricatravel.utils;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.jsalazar.costaricatravel.interfaces.JsonArrayCallback;

public class HttpRequestJSON {

    public static void getRequest(Context context, String url, JsonArrayCallback cb){
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                cb::onGetFinished,
                Throwable::printStackTrace
        );

        queue.add(request);
    }
}
