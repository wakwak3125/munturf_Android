package com.manturf.manturf;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.activeandroid.content.ContentProvider;
import com.android.volley.toolbox.JsonObjectRequest;

import java.util.List;


public class TimeLine extends Fragment {

    private static final String TAG = TimeLine.class.getSimpleName();

    private OnFragmentInteractionListener mListener;
    private List<Events> mList;
    private TimeLineAdapter mAdapter;
    private TL_Adapter tlAdapter;
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

        /*Cursor eventCursor = Events.fetchResultCurdor("");
        TimeLineAdapter adapter = new TimeLineAdapter(getActivity(), eventCursor, 0);
        listView.setAdapter(adapter);*/

        String[] from = {"Title"};

        listView.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                android.R.layout.simple_list_item_1,
                null,
                from,
                new int[]{android.R.id.text1},
                0));

        getActivity().getLoaderManager().initLoader(0, null, new LoaderManager.LoaderCallbacks<Cursor>() {
            @Override
            public Loader<Cursor> onCreateLoader(int arg0, Bundle cursor) {
                String [] projection = {
                        "_id",
                        "Title"
                };
                return new CursorLoader(
                        getActivity(),
                        ContentProvider.createUri(Events.class, null),
                        projection,
                        null,
                        null,
                        null
                );
            }

            @Override
            public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
                ((SimpleCursorAdapter)listView.getAdapter()).swapCursor(cursor);
            }

            @Override
            public void onLoaderReset(Loader<Cursor> loader) {
                ((SimpleCursorAdapter)listView.getAdapter()).swapCursor(null);
            }

        });

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
