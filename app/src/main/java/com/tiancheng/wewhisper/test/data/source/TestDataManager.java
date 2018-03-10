package com.tiancheng.wewhisper.test.data.source;

import com.tiancheng.wewhisper.test.data.entity.TestData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10919 on 2018/3/10/010.
 */

public class TestDataManager {

    public static List<TestData> getTestDatas() {
        List<TestData> dataList = new ArrayList<TestData>();
        String[] imgs = new String[]{
                "http://120.25.204.86:8080/holesay/images/test/test1.png",
                "http://120.25.204.86:8080/holesay/images/test/test2.png",
                "http://120.25.204.86:8080/holesay/images/test/test3.png",
                "http://120.25.204.86:8080/holesay/images/test/test4.png",
                "http://120.25.204.86:8080/holesay/images/test/test5.png",
                "http://120.25.204.86:8080/holesay/images/test/test6.png"
        };

        String[] title = new String[]{
                "你最不想遇到的爱情状况是什么？",
                "测一测你把生活过成什么样了？",
                "测测你与长辈的代沟有多深",
                "情绪评定：测测你的情绪是哪一类？",
                "测你性格最真实的一面",
                "抑郁思维模式评估"
        };

        String[] content = new String[]{
                "爱情中，你最担心出什么状况？哪些事情会让你尴尬呢？这个测试测出你的尴尬点，看看你是哪种爱情尴尬王。",
                "你的生活是充满喜剧话的？是无厘头，沉浸在自编自演当中？还是忙碌地一塌糊涂？赶紧测测你的生活都变成啥样了。",
                "都说三年一代沟，人际交往中，常常因为代沟造成障碍，甚至产生不必要的误会吗？赶紧做个测试，看看代沟是否会影响你的人际交往。",
                "你在多大程度上受理智的控制，又在多大程度上受“本能”情绪的控制？人的情绪受众多因素的影响，我们必须认清自己情绪的力量并发挥理性的控制，才能达到情绪均衡，确保你的情绪与环境变化相匹配。本测试将帮助你在这方面确定自己的位置。",
                "面具下的个人才最真实。社会心理学家笑侃每个人的家里都置有一个面具衣柜，以扮演不同的角色，应对不同的需要和责任。所以，当你摘下所有的面具，你的性格呈现哪种特质呢？本题告诉你答案。",
                "我难过，我悲伤，我忧郁，却什么也做不了，只剩下这怎么都不愿离开的思绪——我活着一点意义都没有。”——抑郁，似乎成了我们的时代病之一。\n"
        };

        String[] num = new String[]{
                "311人测试过",
                "281人测试过",
                "321人测试过",
                "168人测试过",
                "432人测试过",
                "32人测试过"
        };

        for (int i = 0; i < imgs.length; i++) {
            dataList.add(new TestData(imgs[i], title[i], content[i], num[i]));
        }

        return dataList;
    }

}
