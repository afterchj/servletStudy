package com.tpadsz.servlet.entity;

import java.io.Serializable;
import java.util.Date;

public class DMaiyouPrizeStep implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dataId;

    private String type;

    private String name;

    private String isExtra;

    private String stepName;

    private String point;

    private String stepNum;

    private String value;

    private Date updateDate;

    private AuthInfo info;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsExtra() {
        return isExtra;
    }

    public void setIsExtra(String isExtra) {
        this.isExtra = isExtra;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getStepNum() {
        return stepNum;
    }

    public void setStepNum(String stepNum) {
        this.stepNum = stepNum;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public AuthInfo getInfo() {
        return info;
    }

    public void setInfo(AuthInfo info) {
        this.info = info;
    }
}
