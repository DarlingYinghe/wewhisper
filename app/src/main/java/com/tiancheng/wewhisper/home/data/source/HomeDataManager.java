package com.tiancheng.wewhisper.home.data.source;

import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.home.data.entity.ExpertData;
import com.tiancheng.wewhisper.manager.data.entity.IconData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10919 on 2018/3/10/010.
 */

public class HomeDataManager {

    public static List<String> getBannerImages() {
        List<String> dataList = new ArrayList<>();
        String[] imgs = new String[]{
                "http://120.25.204.86:8080/holesay/images/test/test1.png",
                "http://120.25.204.86:8080/holesay/images/test/test2.png",
                "http://120.25.204.86:8080/holesay/images/test/test3.png",
                "http://120.25.204.86:8080/holesay/images/test/test4.png",
                "http://120.25.204.86:8080/holesay/images/test/test5.png",
                "http://120.25.204.86:8080/holesay/images/test/test6.png"
        };
        for (int i = 0; i < imgs.length; i++) {
            dataList.add(imgs[i]);
        }
        return dataList;
    }

    public static List<IconData> getHomeIconDatas() {
        List<IconData> dataList = new ArrayList<IconData>();
        Integer[] icons = new Integer[]{
                R.drawable.bookcity_home,
                R.drawable.market_home,
                R.drawable.activity_home,
                R.drawable.course_home
        };
        String[] titles = new String[]{
                "书城",
                "商城",
                "活动",
                "课程"
        };
        for (int i = 0; i < icons.length; i++) {
            dataList.add(new IconData(icons[i], titles[i]));
        }
        return dataList;
    }

    public static List<ExpertData> getExpertDatas() {
        List<ExpertData> dataList = new ArrayList<ExpertData>();
        String[] avatars = new String[]{
                "http://120.25.204.86:8080/holesay/images/expert/expert1.png",
                "http://120.25.204.86:8080/holesay/images/expert/expert2.png",
                "http://120.25.204.86:8080/holesay/images/expert/expert3.png",
                "http://120.25.204.86:8080/holesay/images/expert/expert4.png",
                "http://120.25.204.86:8080/holesay/images/expert/expert5.png",
                "http://120.25.204.86:8080/holesay/images/expert/expert6.png"
        };
        String[] names = new String[]{
                "青青",
                "子衿",
                "悠悠",
                "我心",
                "但为",
                "君故"
        };
        String[] infos = new String[]{
                "国家二级心理咨询师",
                "国家二级心理咨询师",
                "国家一级心理咨询师",
                "国家二级心理咨询师",
                "国家二级心理咨询师",
                "国家二级心理咨询师",
        };
        String[] directs = new String[]{
                "情感",
                "事业、家排",
                "学业",
                "青少年",
                "情感",
                "情感"
        };
        String[] goodNumes = new String[]{
                "好评数:2万",
                "好评数:3万",
                "好评数:4万",
                "好评数:5万",
                "好评数:6万",
                "好评数:10万"
        };
        for (int i = 0; i < avatars.length; i++) {
            ExpertData expertData = new ExpertData(avatars[i], names[i], infos[i], goodNumes[i], directs[i]);
            dataList.add(expertData);
        }
        return dataList;
    }

}
