package com.manturf.manturf;

/**
 * Created by RyoSakaguchi on 15/02/14.
 */
public class EventsParser {

    /*public static final String TAG = EventsParser.class.getSimpleName();

    public static final String KEY_EVENTS = "all_events";
    public static final String KEY_EVENT_ID = "id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_PLACE = "place";
    public static final String KEY_OCCUPATION = "occupation";
    public static final String KEY_CONTENT = "content";
    public static final String KEY_DATE = "date";
    public static final String KEY_TIME = "time";
    public static final String KEY_CREATED_AT = "created_at";
    public static final String KEY_UPDATED_AT = "updated_at";

    public static List<Events> parseEventsList(JSONObject jsonObject) {
        Log.i(TAG,"parseEventsList" + parseEventsList(jsonObject.optJSONArray(KEY_EVENTS)).toString());
        return parseEventsList(jsonObject.optJSONArray(KEY_EVENTS));
    }

    private static List<Events> parseEventsList(JSONArray jsonArray) {
        List<Events> eventsList = new ArrayList<>();

        Log.i(TAG,"parseEventsList" + eventsList.toString());

        for (int i = 0; i < jsonArray.length(); i++) {
            Events events = EventsParser.parseEvents(jsonArray.optJSONObject(i));
            eventsList.add(events);
        }

        return eventsList;
    }

    private static Events parseEvents(JSONObject jsonObject) {
        Events events = Events.getEvents(jsonObject.optInt(KEY_EVENT_ID));
        *//*if (events == null) {
            events = new Events();
        }*//*

        events.setEventsId(jsonObject.optInt(KEY_EVENT_ID));
        events.setTitle(jsonObject.optString(KEY_TITLE));
        events.setPlace(jsonObject.optString(KEY_PLACE));
        events.setOccupation(jsonObject.optString(KEY_OCCUPATION));
        events.setContent(jsonObject.optString(KEY_CONTENT));
        events.setDate(jsonObject.optString(KEY_DATE));
        events.setTime(jsonObject.optString(KEY_TIME));
        events.setCreated_at(jsonObject.optString(KEY_CREATED_AT));
        events.setUpdated_at(jsonObject.optString(KEY_UPDATED_AT));

        Log.i(TAG,"parseEvents = " + KEY_TITLE);

        events.save();

        return events;
    }*/

}
