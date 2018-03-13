package com.tiancheng.wewhisper.circle.data.entity;

/**
 * Created by 10919 on 2018/3/11/011.
 */

public class CircleData {

    private String avatar;
    private String name;
    private String info;
    private String followNumes;

    public CircleData(String avatar, String name, String info, String followNumes) {
        this.avatar = avatar;
        this.name = name;
        this.info = info;
        this.followNumes = followNumes;
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

    public String getFollowNumes() {
        return followNumes;
    }

    public void setFollowNumes(String num) {
        this.followNumes = followNumes;
    }
}
