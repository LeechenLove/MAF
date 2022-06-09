package com.mobile.automation.runner;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;


/**
 * @Author: Lulu
 * @Description: 执行cucumber测试的入口
 * @DateTime: 2022/6/9 19:22
 **/
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("feature") // feature目录
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com/mobile/automation/steps") // step目录
public class CucumberRunTest {}
