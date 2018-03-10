package com.tiancheng.wewhisper.manager.data.source;

import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.manager.data.entity.IconData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10919 on 2018/3/10/010.
 */

public class ManagerDataManager {



    public static List<IconData> getManagerIconBarDatas() {

        List<IconData> dataList = new ArrayList<IconData>();
        Integer[] icons = new Integer[]{
                R.drawable.history,
                R.drawable.scheme,
                R.drawable.course,
                R.drawable.activity
        };
        String[] titles = new String[]{
                "诊断历史",
                "治疗方案",
                "参与课程",
                "活动日程"
        };
        for (int i = 0; i < icons.length; i++) {
            dataList.add(new IconData(icons[i], titles[i]));
        }
        return dataList;
    }

    public static List<IconData> getManagerIconListDatas() {
        List<IconData> dataList = new ArrayList<IconData>();
        Integer[] icons = new Integer[]{
                R.drawable.info,
                R.drawable.true_name,
                R.drawable.packet,
                R.drawable.safe
        };
        String[] titles = new String[]{
                "账户信息",
                "实名认证",
                "钱包管理",
                "安全管理"
        };
        for (int i = 0; i < icons.length; i++) {
            dataList.add(new IconData(icons[i], titles[i]));
        }
        return dataList;
    }

    public static List<IconData> getManagerIconListDatas2() {
        List<IconData> dataList = new ArrayList<IconData>();
        Integer[] icons = new Integer[]{
                R.drawable.feedback,
        };
        String[] titles = new String[]{
                "信息反馈",
        };
        for (int i = 0; i < icons.length; i++) {
            dataList.add(new IconData(icons[i], titles[i]));
        }
        return dataList;
    }

}
