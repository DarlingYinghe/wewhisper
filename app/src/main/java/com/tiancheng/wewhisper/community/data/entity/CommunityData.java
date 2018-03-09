package com.tiancheng.wewhisper.community.data.entity;

/**
 * Created by 10919 on 2018/3/9/009.
 */

public class CommunityData {

    private String avatar;
    private String name;
    private String title;
    private String content;
    private String numComment;

    public CommunityData(String avatar, String name, String title, String content, String numComment) {
        this.avatar = avatar;
        this.name = name;
        this.title = title;
        this.content = content;
        this.numComment = numComment;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNumComment() {
        return numComment;
    }

    public void setNumComment(String numComment) {
        this.numComment = numComment;
    }
}
