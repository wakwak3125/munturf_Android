package com.manturf.manturf;

import android.database.Cursor;
import android.provider.BaseColumns;
import android.support.annotation.Nullable;

import com.activeandroid.Cache;
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

/**
 * Created by RyoSakaguchi on 15/02/14.
 */
@Table(name = "EventsList",id = BaseColumns._ID)
public class Events extends Model {
    public static final String TAG = Events.class.getSimpleName();

    @Column(name = "Events_id", unique = true)
    public int events_id;
    @Column(name = "Title", unique = true)
    public String title;
    @Column(name = "Place", unique = false, index = true)
    public String place;
    @Column(name = "Occupation", index = true)
    public String occupation;
    @Column(name = "Content")
    public String content;
    @Column(name = "Date", index = true)
    public String date;
    @Column(name = "Time")
    public String time;
    @Column(name = "Created_at")
    public String created_at;
    @Column(name = "Updated_at")
    public String updated_at;


    public Events(int event_id,
                  String title,
                  String content,
                  String created_at,
                  String update_at,
                  String date,
                  String place,
                  String time,
                  String occupation
    ) {
        this.events_id = event_id;
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        this.updated_at = update_at;
        this.date = date;
        this.place = place;
        this.time = time;
        this.occupation = occupation;
    }

    public Events() {
        super();
    }

    public int getEventsId() {
        return events_id;
    }
    public void setEventsId(int id) {
        this.events_id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }


    public static Cursor fetchResultCurdor(@Nullable String occupation) {
        String resultRecords = new Select().from(Events.class).where("Occupation in " + "(" + "'" + occupation + "'" + ")").toSql();
        Cursor resultCursor = Cache.openDatabase().rawQuery(resultRecords, null);
        return resultCursor;
    }

/*
    public static Events getEvents(int events_id) {
        Log.i(TAG, "ここでなにするん？");
        return new Select()
                .from(Events.class)
                .where("Events_id = ?", events_id)
                .executeSingle();
    }

    public static List<Events> getOccupationList(String occupation){
        Log.i("Occupation = :",occupation);
        return new Select()
                .from(Events.class)
                .where("Occupation = ?", occupation)
                .orderBy("Events_id DESC")
                .execute();
    }
*/

}
