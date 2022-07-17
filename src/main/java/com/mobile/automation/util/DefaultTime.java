package com.mobile.automation.util;

/**
 * @Author: Lulu
 * @Description: 提供默认等待时间
 * @DateTime: 2022/7/11 21:19
 **/
public enum DefaultTime {
    WAIT_TIME();

    private final int time;

    DefaultTime() {this.time = 30;}

    public int getTime(){return time;}
}
