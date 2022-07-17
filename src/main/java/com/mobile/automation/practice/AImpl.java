package com.mobile.automation.practice;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.mobile.automation.service.impl.TestModule;
import com.typesafe.config.Config;

/**
 * @Author: Lulu
 * @Description: TODO
 * @DateTime: 2022/7/17 10:08
 **/
public class AImpl implements A{

    private Config config;

    @Inject
    public AImpl(Config config){
        this.config = config;
    }

    @Override
    public void printString(){
        System.out.println(config.getString("android.port"));
        String url = String.format("http://localhost:%s/wd/hub", config.getString("android.port"));
        System.out.println(url);
    }
}

class test{
    public static void main(String[] args){
        Injector injector = Guice.createInjector(new TestModule());
        //从injector中获取TextEditor对象
        A a = injector.getInstance(A.class);
        a.printString();
    }
}
