package com.tiancheng.wewhisper.manager.data.entity;

/**
 * Created by 10919 on 2018/3/10/010.
 */

public class IconData {
    private Integer icon;
    private String title;

    public IconData(Integer icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
