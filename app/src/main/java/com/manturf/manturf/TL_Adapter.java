package com.manturf.manturf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by RyoSakaguchi on 15/02/15.
 */
public class TL_Adapter extends BaseAdapter {
    private static final String TAG = TL_Adapter.class.getSimpleName();
    private Context context;
    private List<Events> eventsList;

    public TL_Adapter(Context context, List<Events> eventsList) {
        this.context = context;
        this.eventsList = eventsList;
    }

    @Override
    public int getCount() {
        return eventsList.size();
    }

    @Override
    public Object getItem(int position) {
        return eventsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        TextView title = (TextView) view.findViewById(android.R.id.text1);

        Events events = (Events) getItem(position);
        title.setText(events.getTitle());
        return view;
    }

    public boolean add(List<Events> events) {
        boolean ress = eventsList.addAll(events);
        if (ress) {
            notifyDataSetChanged();
        }
        return ress;
    }
}
