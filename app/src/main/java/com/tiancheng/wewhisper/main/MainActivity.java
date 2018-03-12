package com.tiancheng.wewhisper.main;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tiancheng.wewhisper.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ViewPager vp;

    private TabLayout navBar;
    private Fragment[] mFragments;
    private static final int FRAGMENT_NUM = 5;

    private ImageView icMenu;

    private PopupMenu testPopupMenu;
    private PopupMenu communityPopupMenu;

    private View search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: executed");
        initWeight();

        initViewPager();
        initNavBar();
        setMenu();
        vp.setCurrentItem(0);
    }

    private void setMenu() {
        testPopupMenu = new PopupMenu(this, icMenu);
        MenuInflater testInflater = testPopupMenu.getMenuInflater();
        Menu testMenu = testPopupMenu.getMenu();
        testInflater.inflate(R.menu.menu_test, testMenu);
        testPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        communityPopupMenu = new PopupMenu(this, icMenu);
        MenuInflater communityInflater = communityPopupMenu.getMenuInflater();
        Menu menu = communityPopupMenu.getMenu();
        communityInflater.inflate(R.menu.menu_community, menu);
        communityPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
    }


    private void initWeight() {
        Log.i(TAG, "initWeight: executed");
        vp = (ViewPager) findViewById(R.id.view_pager);
        navBar = (TabLayout) findViewById(R.id.nav_bar);
        icMenu = (ImageView) findViewById(R.id.iv_menu_search);
        search = (View) findViewById(R.id.search_main);
    }

    private void initViewPager() {
        //初始化ViewPager
        mFragments = DataManager.getFragments();

        vp.setAdapter(new MainFragmentPagerAdapter(getSupportFragmentManager(), mFragments));
        vp.setOffscreenPageLimit(4);
        //设置页面变更监听器
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG, "onPageSelected: selectPosition" + position);
                switch (position) {
                    case 0:
                        navBar.getTabAt(0).select();
                        break;
                    case 1:
                        navBar.getTabAt(1).select();
                        break;
                    case 2:
                        navBar.getTabAt(2).select();
                        break;
                    case 3:
                        navBar.getTabAt(3).select();
                        break;
                    case 4:
                        navBar.getTabAt(4).select();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void initNavBar() {
        Log.i(TAG, "setTabTextFirstTime: executed");
        //初始化标题文字
        mFragments = DataManager.getFragments();

        //初始化第一个tab
        View view = LayoutInflater.from(this).inflate(R.layout.tab_content, null);
        TextView tv = view.findViewById(R.id.tab_content_text);
        ImageView iv = view.findViewById(R.id.tab_content_img);
        tv.setText(DataManager.mTabTitle[0]);
        tv.setTextColor(getResources().getColor(R.color.turquoise3));
        Glide.with(this).load(DataManager.mTabIconSelected[0]).into(iv);
        navBar.getTabAt(0).setCustomView(view);

        //初始化其他tab
        for (int i = 1; i < FRAGMENT_NUM; i++) {
            view = LayoutInflater.from(this).inflate(R.layout.tab_content, null);
            tv = view.findViewById(R.id.tab_content_text);
            iv = view.findViewById(R.id.tab_content_img);
            tv.setText(DataManager.mTabTitle[i]);
            Glide.with(this).load(DataManager.mTabIconUnselected[i]).into(iv);
            navBar.getTabAt(i).setCustomView(view);
        }

        //设置选择监听器
        navBar.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.i(TAG, "onTabSelected: Tab" + tab.getPosition());
                View view = tab.getCustomView();
                ImageView iv = view.findViewById(R.id.tab_content_img);
                int position = tab.getPosition();

                TextView tv = view.findViewById(R.id.tab_content_text);
                Glide.with(MainActivity.this).load(DataManager.mTabIconSelected[position]).into(iv);
                tv.setTextColor(getResources().getColor(R.color.turquoise3));
                vp.setCurrentItem(position);

                switch (position) {
                    case 0:
                        search.setVisibility(View.VISIBLE);
                        ViewCompat.animate(search).scaleX(1);
                        icMenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                        break;
                    case 1:
                        search.setVisibility(View.VISIBLE);
                        ViewCompat.animate(search).scaleX(1);
                        icMenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                        break;
                    case 2:
                        search.setVisibility(View.VISIBLE);
                        ViewCompat.animate(search).scaleX(1);
                        icMenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                communityPopupMenu.show();
                            }
                        });
                        break;
                    case 3:
                        search.setVisibility(View.VISIBLE);
                        ViewCompat.animate(search).scaleX(1);
                        icMenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                testPopupMenu.show();
                            }
                        });
                        break;
                    case 4:
                        ViewCompat.animate(search).scaleX(0).withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                search.setVisibility(View.GONE);
                            }
                        });
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                ImageView iv = view.findViewById(R.id.tab_content_img);
                int position = tab.getPosition();

                TextView tv = view.findViewById(R.id.tab_content_text);
                Glide.with(MainActivity.this).load(DataManager.mTabIconUnselected[position]).into(iv);
                tv.setTextColor(getResources().getColor(R.color.glory));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.i(TAG, "onTabReselected: Tab" + tab.getPosition());

            }
        });
    }
}
