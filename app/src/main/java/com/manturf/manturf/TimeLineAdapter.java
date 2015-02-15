package com.manturf.manturf;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by RyoSakaguchi on 15/02/14.
 */
public class TimeLineAdapter extends CursorAdapter {


    private static class ViewHolder {
        TextView mTitle;

    }

    public TimeLineAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        /*mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);*/
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        ViewHolder holder = (ViewHolder) view.getTag();

        String title = cursor.getString(cursor.getColumnIndexOrThrow("Title"));

        holder.mTitle.setText(title);
        Log.i("bindView内のタイトル = ", title);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View view = LayoutInflater.from(context).inflate(R.layout.timeline_row, null);
        ViewHolder holder = new ViewHolder();
        holder.mTitle = (TextView) view.findViewById(R.id.title);

        view.setTag(holder);
        return view;
    }


}
