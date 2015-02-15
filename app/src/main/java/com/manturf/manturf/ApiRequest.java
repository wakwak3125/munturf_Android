package com.manturf.manturf;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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
                        /*EventsParser.parseEventsList(response);*/
                        try {
                            List<Events> eventses = parse(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.i(TAG, response.toString());
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

    private static List<Events> parse(JSONObject json) throws JSONException {
        ArrayList<Events> records = new ArrayList<>();
        JSONArray events = json.getJSONArray("all_events");

        for (int i = 0; i < events.length(); i++) {
            JSONObject event = events.optJSONObject(i);

            int id = event.getInt("id");
            String title = event.getString("title");
            String content = event.getString("content");
            String created_at = event.getString("created_at");
            String updated_at = event.getString("updated_at");
            String date = event.getString("date");
            String place = event.getString("place");
            String time = event.getString("time");
            String occupation = event.getString("occupation");

            Events record = new Events(id, title, content, created_at, updated_at, date, place, time, occupation);

            records.add(record);

            record.save();

            Log.i(TAG, event.getString("title"));
        }
        return records;
    }
}
