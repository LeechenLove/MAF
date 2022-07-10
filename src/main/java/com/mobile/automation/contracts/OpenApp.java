package com.mobile.automation.contracts;

import com.mobile.automation.page.Base;

/**
 * @Author: Lulu
 * @Description: TODO
 * @DateTime: 2022/6/10 19:23
 **/
public interface OpenApp extends Base {
    void startApp();

    void logonApp(String username, String password);
}
