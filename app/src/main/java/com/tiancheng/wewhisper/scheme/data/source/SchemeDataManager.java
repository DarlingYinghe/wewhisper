package com.tiancheng.wewhisper.scheme.data.source;

import com.tiancheng.wewhisper.scheme.data.entity.SchemeData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10919 on 2018/3/12/012.
 */

public class SchemeDataManager {

    public static List<SchemeData> getSchemeDatas() {
        List<SchemeData> dataList = new ArrayList<SchemeData>();

        String[] nos = {
                "方案1",
                "方案2",
                "方案3",
                "方案4",
                "方案5"
        };
        String[] doctors = {
                "青青","子衿","悠悠","我心","但为"
        };
        String[] diseases = {
                "焦虑症",
                "抑郁症",
                "自闭症",
                "焦虑症",
                "焦虑症"
        };
        String[] dates = {
                "2018.3.3",
                "2018.2.11",
                "2018.1.3",
                "2017.3.3",
                "2017.3.2"
        };
        for (int i = 0; i < nos.length; i++) {
            dataList.add(new SchemeData(nos[i], doctors[i], diseases[i], dates[i]));
        }

        return dataList;
    }

}
