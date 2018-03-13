package com.tiancheng.wewhisper.main;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.netease.nim.uikit.api.NimUIKit;
import com.netease.nim.uikit.api.UIKitOptions;
import com.netease.nim.uikit.common.util.log.LogUtil;
import com.netease.nim.uikit.impl.cache.DataCacheManager;
import com.netease.nimlib.sdk.AbortableFuture;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.LoginInfo;
import com.netease.nimlib.sdk.util.NIMUtil;
import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.consult.nim.DemoCache;

import java.io.IOException;
import java.util.prefs.Preferences;

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

        // SDK初始化（启动后台服务，若已经存在用户登录信息， SDK 将完成自动登录）
        // 4.6.0 开始，第三方推送配置入口改为 SDKOption#mixPushConfig，旧版配置方式依旧支持。
        NIMClient.init(this, loginInfo(), null);
        // ... your codes

        if (NIMUtil.isMainProcess(this)) {
            // 注意：以下操作必须在主进程中进行
            // 1、UI相关初始化操作
            // 2、相关Service调用
            initUiKit();
        }
    }

    private void initUiKit() {
        // 初始化
        NimUIKit.init(this, buildUIKitOptions());
    }

    private UIKitOptions buildUIKitOptions() {
        UIKitOptions options = new UIKitOptions();
        // 设置app图片/音频/日志等缓存目录
        options.appCacheDir = getAppCacheDir(this) + "/app";
        return options;
    }

    /**
     * 配置 APP 保存图片/语音/文件/log等数据的目录
     * 这里示例用SD卡的应用扩展存储目录
     */
    static String getAppCacheDir(Context context) {
        String storageRootPath = null;
        try {
            // SD卡应用扩展存储区(APP卸载后，该目录下被清除，用户也可以在设置界面中手动清除)，请根据APP对数据缓存的重要性及生命周期来决定是否采用此缓存目录.
            // 该存储区在API 19以上不需要写权限，即可配置 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" android:maxSdkVersion="18"/>
            if (context.getExternalCacheDir() != null) {
                storageRootPath = context.getExternalCacheDir().getCanonicalPath();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(storageRootPath)) {
            // SD卡应用公共存储区(APP卸载后，该目录不会被清除，下载安装APP后，缓存数据依然可以被加载。SDK默认使用此目录)，该存储区域需要写权限!
            storageRootPath = Environment.getExternalStorageDirectory() + "/" + DemoCache.getContext().getPackageName();
        }

        return storageRootPath;
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
    /**
     * 登录事件响应函数
     */
    private LoginInfo loginInfo() {
        // 从本地读取上次登录成功时保存的用户登录信息
        String account = "hello1";
        String token = "123456";
        if (!TextUtils.isEmpty(account) && !TextUtils.isEmpty(token)) {
            DemoCache.setAccount(account.toLowerCase());
            return new LoginInfo(account, token);
        } else {
            return null;
        }
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
        //  Glide.with(this).load(DataManager.mTabIconSelected[0]).into(iv);
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
