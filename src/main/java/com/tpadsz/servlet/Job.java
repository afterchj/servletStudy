package com.tpadsz.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hongjian.chen on 2017/10/10.
 */
public class Job {
    public void execute(){
        System.out.println("自动执行任务时间,"+new SimpleDateFormat("yyyy-MM-dd HH-mm:ss").format(new Date()));
    }
}
