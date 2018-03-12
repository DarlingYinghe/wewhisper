package com.tiancheng.wewhisper.home.data.entity;

/**
 * Created by 10919 on 2018/3/11/011.
 */

public class ExpertData {

    private String avatar;
    private String name;
    private String info;
    private String direct;
    private String goodNum;

    public ExpertData(String avatar, String name, String info, String goodNum, String direct) {
        this.avatar = avatar;
        this.name = name;
        this.info = info;
        this.goodNum = goodNum;
        this.direct = direct;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(String goodNum) {
        this.goodNum = goodNum;
    }
}
