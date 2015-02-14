package com.manturf.manturf;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.RequestQueue;
import com.astuetz.PagerSlidingTabStrip;


public class MainActivity extends ActionBarActivity implements TimeLine.OnFragmentInteractionListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    private ViewPager viewPager;
    private PagerSlidingTabStrip tabStrip;
    private PagerAdapter pagerAdapter;

    private RequestQueue requestQueue;
    private ApiRequest apiRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ViewPagerの初期化
        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        //PagerSlidingTabStripの初期化
        tabStrip = (PagerSlidingTabStrip)findViewById(R.id.tabs);
        tabStrip.setViewPager(viewPager);

        TimeLine.newInstance();




/*
        apiRequest = new ApiRequest();

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        apiRequest.EventRequest();*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(String id) {

    }
}
