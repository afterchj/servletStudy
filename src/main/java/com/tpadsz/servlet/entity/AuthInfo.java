package com.tpadsz.servlet.entity;

import java.util.Date;

/**
 * Created by hongjian.chen on 2017/11/21.
 */
public class AuthInfo {
    private String id;
    private String uid;
    private String dataId;
    private String getCoinsType;
    private Date update_date;
    private String other;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getGetCoinsType() {
        return getCoinsType;
    }

    public void setGetCoinsType(String getCoinsType) {
        this.getCoinsType = getCoinsType;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
