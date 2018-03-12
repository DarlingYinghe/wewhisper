package com.tiancheng.wewhisper.scheme.data.entity;

/**
 * Created by 10919 on 2018/3/12/012.
 */

public class SchemeData {

    private String no;
    private String doctor;
    private String disease;
    private String date;

    public SchemeData(String no, String doctor, String disease, String date) {
        this.no = no;
        this.doctor = doctor;
        this.disease = disease;
        this.date = date;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
