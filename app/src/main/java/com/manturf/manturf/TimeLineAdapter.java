package com.manturf.manturf;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by RyoSakaguchi on 15/02/14.
 */
public class TimeLineAdapter extends CursorAdapter {


    private static class ViewHolder {
        TextView mTitle;
        TextView mContent;
        TextView mDate;
        TextView mOccupation;
        ImageView mImage;

    }

    public TimeLineAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        /*mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);*/
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        ViewHolder holder = (ViewHolder) view.getTag();

        String title = cursor.getString(cursor.getColumnIndexOrThrow("Title"));
        String content = cursor.getString(cursor.getColumnIndexOrThrow("Content"));
        String date = cursor.getString(cursor.getColumnIndexOrThrow("Date"));
        String occupation = cursor.getString(cursor.getColumnIndexOrThrow("Occupation"));

        holder.mTitle.setText(title);
        holder.mContent.setText(content);
        holder.mDate.setText(date);
        holder.mOccupation.setText(occupation);

        Log.i("bindView内のタイトル = ", title);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View view = LayoutInflater.from(context).inflate(R.layout.timeline_row, null);
        ViewHolder holder = new ViewHolder();

        holder.mTitle = (TextView) view.findViewById(R.id.title);
        holder.mContent = (TextView) view.findViewById(R.id.content);
        holder.mDate = (TextView) view.findViewById(R.id.date);
        holder.mOccupation = (TextView) view.findViewById(R.id.occupation);

        view.setTag(holder);
        return view;
    }


}
