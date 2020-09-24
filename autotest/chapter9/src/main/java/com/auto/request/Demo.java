package com.auto.request;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Demo {

    ResourceBundle bundle;
    String URL;
    CookieStore cookieStore;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        URL = bundle.getString("test.url");
    }

    @Test
    public void test1() throws IOException {
        String uri = bundle.getString("getcookies.uri");
        String testURL = URL + uri;
        HttpGet get = new HttpGet(testURL);
        HttpClient client = new DefaultHttpClient();

        HttpResponse response = client.execute(get);

        String res = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(res);
    }
}
