package com.manturf.manturf;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by RyoSakaguchi on 15/02/14.
 */
public class PagerAdapter extends FragmentPagerAdapter{

    public static final String[] pageTitles
            = {"HOME","LIKE","MESSAGE","PROFILE"};

/*
    public static final int[] pageIcons
            = {R.drawable.ic_format_align_justify_grey600_48dp,R.drawable.ic_grade_grey600_48dp,
            R.drawable.ic_forum_grey600_48dp,R.drawable.ic_person_outline_grey600_48dp};
*/

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index){
            case 0:
                //トップのタイムライン
                return new TimeLine();
            case 1:
                //お気に入り
                return new Favorites();
            case 2:
                //メッセージ
                return new Message();
            case 3:
                //プロフィール
                return new Profile();
        }
        return null;
    }

    /*@Override
    public int getPageIconResId(int i) {
        return pageIcons[i];
    }*/

    @Override
    public int getCount() {
        return pageTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles[position];
    }
}
