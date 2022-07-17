package com.mobile.automation.page;

/**
 * @Author: Lulu
 * @Description: 每个page都会用到的方法
 * @DateTime: 2022/7/10 18:00
 */
public interface Base {
    //规定时间内，判断页面是否显示，
    boolean isDisplay(Integer... seconds);

    //等待页面元素显示
    void waitDisplay();
}
