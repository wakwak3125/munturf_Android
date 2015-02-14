package com.manturf.manturf;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * Created by RyoSakaguchi on 15/02/14.
 */
public class ApiRequest {
    public static String TAG = ApiRequest.class.getSimpleName();

    static String url = "http://manturf2.herokuapp.com/api/v1/events";

    public static JsonObjectRequest MyJsonObjectRequest() {
        return new JsonObjectRequest(Request.Method.GET, url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        EventsParser.parseEventsList(response);
                        Log.i(TAG,response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                    }
                }
        );
    }
}
