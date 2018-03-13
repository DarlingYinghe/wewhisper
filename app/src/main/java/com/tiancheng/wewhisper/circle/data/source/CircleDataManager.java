package com.tiancheng.wewhisper.circle.data.source;

import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.circle.data.entity.CircleData;
import com.tiancheng.wewhisper.manager.data.entity.IconData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10919 on 2018/3/10/010.
 */

public class CircleDataManager {


    public static List<CircleData> getCircleDatas() {
        List<CircleData> dataList = new ArrayList<CircleData>();
        String[] avatars = new String[]{
                "http://120.25.204.86:8080/holesay/images/circle/circle1.png",
                "http://120.25.204.86:8080/holesay/images/circle/circle2.png",
                "http://120.25.204.86:8080/holesay/images/circle/circle3.png",
                "http://120.25.204.86:8080/holesay/images/circle/circle4.png",
                "http://120.25.204.86:8080/holesay/images/circle/circle5.png"
        };
        String[] names = new String[]{
                "心港心理咨询室",
                "心理协会",
                "海之澜心理社团",
                "科大心理协会",
                "中国科学院心理研究所"
        };
        String[] infos = new String[]{
                "心港一直致力于将心理健康当做一个长期的己任来抓，旨在治愈每一颗受伤的心灵，重塑回归社会的自信与勇气。",
                "每年家园心理协会都将通过一系列丰富多彩的活动，扩大心理学的影响，提高人们对心理健康的关注。",
                "传播心理健康观念，普及心理健康知识，提高心理素质，为大学生健康愉快的学习和生活尽一份力。",
                "在历届心理协会成员的共同努力下，协会逐步建立了团结严密的管理团队，并不断发展壮大。",
                "为促进国民心理健康和推动社会和谐发展提供重要知识基础和科技支撑，成为引领中国心理科学发展并有重要影响力的国际著名研究机构、服务国家科技创新与城镇化发展的心理学科技智库。 "
        };

        String[] followNumes = new String[]{
                "3万人关注",
                "10万人关注",
                "1000人关注",
                "200人关注",
                "13万人关注"
        };
        for (int i = 0; i < avatars.length; i++) {
            CircleData expertData = new CircleData(avatars[i], names[i], infos[i], followNumes[i]);
            dataList.add(expertData);
        }
        return dataList;
    }

}
