package com.selenium.util;

import com.vimalselvam.testng.SystemInfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MySystemInfo implements SystemInfo {
    public Map<String, String> getSystemInfo() {
//        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("env.properties");
//        Properties properties = new Properties();
//        properties.load(inputStream);
        Map<String,String> map = new HashMap<String, String>();
        map.put("environment","test");
        map.put("测试人员","test");

        return map;
    }
}
