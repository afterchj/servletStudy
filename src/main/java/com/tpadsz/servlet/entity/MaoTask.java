package com.tpadsz.servlet.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hongjian.chen on 2017/9/29.
 */
public class MaoTask implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String task_id;
    private String task_title;
    private String channel_task_price;
    private String task_price;
    private String task_create_time;
    private String task_check_time;
    private String task_repeat_hours;
    private String task_repeat_num;
    private String task_platform;
    private String task_surplus;
    private String task_type;
    private String task_open_area;
    private String task_desc;
    private String task_update_time;
    private String detail;
    private String status;
    private String img;
    private String type;
    private Date update_date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public String getTask_title() {
        return task_title;
    }

    public void setTask_title(String task_title) {
        this.task_title = task_title;
    }

    public String getChannel_task_price() {
        return channel_task_price;
    }

    public void setChannel_task_price(String channel_task_price) {
        this.channel_task_price = channel_task_price;
    }

    public String getTask_price() {
        return task_price;
    }

    public void setTask_price(String task_price) {
        this.task_price = task_price;
    }

    public String getTask_create_time() {
        return task_create_time;
    }

    public void setTask_create_time(String task_create_time) {
        this.task_create_time = task_create_time;
    }

    public String getTask_check_time() {
        return task_check_time;
    }

    public void setTask_check_time(String task_check_time) {
        this.task_check_time = task_check_time;
    }

    public String getTask_repeat_hours() {
        return task_repeat_hours;
    }

    public void setTask_repeat_hours(String task_repeat_hours) {
        this.task_repeat_hours = task_repeat_hours;
    }

    public String getTask_repeat_num() {
        return task_repeat_num;
    }

    public void setTask_repeat_num(String task_repeat_num) {
        this.task_repeat_num = task_repeat_num;
    }

    public String getTask_platform() {
        return task_platform;
    }

    public void setTask_platform(String task_platform) {
        this.task_platform = task_platform;
    }

    public String getTask_surplus() {
        return task_surplus;
    }

    public void setTask_surplus(String task_surplus) {
        this.task_surplus = task_surplus;
    }

    public String getTask_type() {
        return task_type;
    }

    public void setTask_type(String task_type) {
        this.task_type = task_type;
    }

    public String getTask_open_area() {
        return task_open_area;
    }

    public void setTask_open_area(String task_open_area) {
        this.task_open_area = task_open_area;
    }

    public String getTask_desc() {
        return task_desc;
    }

    public void setTask_desc(String task_desc) {
        this.task_desc = task_desc;
    }

    public String getTask_update_time() {
        return task_update_time;
    }

    public void setTask_update_time(String task_update_time) {
        this.task_update_time = task_update_time;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = "mapHp";
        this.type = type;
    }

    public Date getUpdateDate() {
        return update_date;
    }

    public void setUpdateDate(Date update_date) {
        this.update_date = update_date;
    }
}
