package com.auto.request;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Demo2 {

    String URL;
    ResourceBundle bundle;
    CookieStore cookieStore;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        URL = bundle.getString("test.url");
    }

    @Test
    public void test1() throws IOException {
        String testURL,uri;
        uri = bundle.getString("getcookies.uri");
        testURL = URL + uri;

        HttpGet get = new HttpGet(testURL);
        HttpClient client = new DefaultHttpClient();

        HttpResponse response = client.execute(get);

        String res = EntityUtils.toString(response.getEntity(),"utf-8");

        this.cookieStore = ((DefaultHttpClient) client).getCookieStore();

    }


    @Test(dependsOnMethods = "test1")
    public void test2() throws IOException {
        String testURL,uri;
        uri = bundle.getString("postJson.uri");
        testURL = URL + uri;

        HttpPost post = new HttpPost(testURL);
        HttpClient client = new DefaultHttpClient();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","zhangsan");
        jsonObject.put("age","18");

        StringEntity stringEntity = new StringEntity(jsonObject.toString(),"utf-8");

        post.setHeader("content-type","application/json");

        post.setEntity(stringEntity);

        ((DefaultHttpClient) client).setCookieStore(this.cookieStore);

        HttpResponse response = client.execute(post);

        String res = EntityUtils.toString(response.getEntity(),"utf-8");

        JSONObject jsonObject1 = new JSONObject(res);

        String name = jsonObject1.getString("name");

        Assert.assertEquals(name,"张三1");



    }

}
