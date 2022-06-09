package com.mobile.automation.service.impl;

import com.google.inject.AbstractModule;
import com.mobile.automation.contracts.TestGuice;
import com.mobile.automation.page.TestGuiceImpl;

/**
 * @Author: Lulu
 * @Description: TODO
 * @DateTime: 2022/6/9 9:53
 **/
public class TestModule extends AbstractModule {
    @Override
    protected void configure(){
        bind(TestGuice.class).to(TestGuiceImpl.class);
    }
}
