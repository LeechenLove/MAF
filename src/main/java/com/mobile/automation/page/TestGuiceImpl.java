package com.mobile.automation.page;

import com.mobile.automation.contracts.TestGuice;

/**
 * @Author: Lulu
 * @Description: TODO
 * @DateTime: 2022/6/9 22:54
 **/
public class TestGuiceImpl implements TestGuice {
    @Override
    public void printTest() {
        System.out.println("Inject guice...");
    }
}
