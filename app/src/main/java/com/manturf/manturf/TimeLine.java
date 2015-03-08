package com.manturf.manturf;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.activeandroid.content.ContentProvider;
import com.android.volley.toolbox.JsonObjectRequest;

import java.util.List;


public class TimeLine extends Fragment {

    private static final String TAG = TimeLine.class.getSimpleName();

    private OnFragmentInteractionListener mListener;
    private List<Events> mList;
    private TimeLineAdapter mAdapter;
    private ListView mListView;

    public TimeLine() {
    }

    public static TimeLine newInstance() {
        JsonObjectRequest jsonObjectRequest = ApiRequest.MyJsonObjectRequest();
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);

        TimeLine fragment = new TimeLine();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timeline, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ListView listView = (ListView) getView().findViewById(R.id.listView);

        // adapterのセット
        mAdapter = new TimeLineAdapter(getActivity(), null, 0);
        listView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        listView.setDivider(null);
        listView.setVerticalScrollBarEnabled(false);
        listView.setSelector(android.R.color.transparent);

        // リストのアイテムをクリックした時の動作
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView timeline = (ListView)parent;
                Cursor cursor = (Cursor) timeline.getItemAtPosition(position);
                System.out.println(cursor.getString(cursor.getColumnIndex("Title")));

                Intent eventDetail = new Intent(getActivity(), EventDetail.class);
                Bundle bundle = new Bundle();
                bundle.putString("EventTitle", cursor.getString(cursor.getColumnIndex("Title")));

                eventDetail.putExtras(bundle);
                startActivity(eventDetail);
            }
        });

        // とりあえずのITなだけ。ここに取得したい業界をセットする。
        // メインのタイムラインは1業界に絞るのでコレでいいと思う。
        // ユーザー情報の業界から引っ張ってくる。
        // 引っ張ってきた値をここの Occupation に突っ込めばおっけいや！
        String Occupation = "IT";

        getActivity().getLoaderManager().initLoader(0, null, new LoaderManager.LoaderCallbacks<Cursor>() {
            @Override
            public Loader<Cursor> onCreateLoader(int arg0, Bundle cursor) {
                String[] projection = {"_id", "Title", "Content", "Date", "Occupation", "Place"};
                String where = null;
                String[] args = null;
                String sortOrder = "Events_id ASC";

                return new CursorLoader(
                        getActivity(),
                        ContentProvider.createUri(Events.class, null),
                        projection,
                        where,
                        args,
                        sortOrder
                );
            }

            @Override
            public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
                // SimpleCursorAdapterの場合
                /*((SimpleCursorAdapter) listView.getAdapter()).swapCursor(cursor);*/
                // 独自Adapterの場合
                mAdapter.swapCursor(cursor);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLoaderReset(Loader<Cursor> loader) {
                // SimpleCursorAdapterの場合
                /*((SimpleCursorAdapter) listView.getAdapter()).swapCursor(null);*/
                // 独自Adapterの場合
                mAdapter.swapCursor(null);
            }

        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        // Loaderの廃棄
        getLoaderManager().destroyLoader(0);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String id);
    }

}
