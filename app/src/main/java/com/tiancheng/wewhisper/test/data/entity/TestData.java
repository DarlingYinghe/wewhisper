package com.tiancheng.wewhisper.test.data.entity;

/**
 * Created by 10919 on 2018/3/10/010.
 */

public class TestData {

    private String img;
    private String title;
    private String content;
    private String num;

    public TestData(String img, String title, String content, String num) {
        this.img = img;
        this.title = title;
        this.content = content;
        this.num = num;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

}
