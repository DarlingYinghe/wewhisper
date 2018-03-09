package com.tiancheng.wewhisper.main;

import android.support.v4.app.Fragment;

import com.tiancheng.wewhisper.community.CommunityFragment;
import com.tiancheng.wewhisper.consult.ConsultFragment;
import com.tiancheng.wewhisper.home.HomeFragment;
import com.tiancheng.wewhisper.manager.ManagerFragment;
import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.test.TestFragment;

/**
 * Created by 10919 on 2018/1/31/031.
 */

public class DataManager {

    public static final int[] mTabIconSelected = new int[] {
            R.drawable.home_selected,
            R.drawable.consult_selected,
            R.drawable.community_selected,
            R.drawable.test_selected,
            R.drawable.manager_selected
    };

    public static final int[] mTabIconUnselected = new int[] {
            R.drawable.home_unselected,
            R.drawable.consult_unselected,
            R.drawable.community_unselected,
            R.drawable.test_unselected,
            R.drawable.manager_unselected
    };

    public static final int[] mTabTitle = new int[] {
            R.string.home,
            R.string.consult,
            R.string.community,
            R.string.test,
            R.string.manager
    };

    private static Fragment[] mFragments;

    public static Fragment[] getFragments() {
        mFragments = new Fragment[5];
        mFragments[0] = new HomeFragment();
        mFragments[1] = new ConsultFragment();
        mFragments[2] = new CommunityFragment();
        mFragments[3] = new TestFragment();
        mFragments[4] = new ManagerFragment();
        return mFragments;
    }






}
