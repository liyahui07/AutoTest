package com.auto.request;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Demo3 {

    String Url;
    CookieStore cookieStore;
    ResourceBundle bundle;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        Url = bundle.getString("test.url");
    }

    @Test
    public void test1() throws IOException {
        String testURL,uri;
        uri = bundle.getString("getcookies.uri");

        testURL = Url + uri;

        HttpGet get = new HttpGet(testURL);

        HttpClient client = new DefaultHttpClient();

        client.execute(get);

        this.cookieStore = ((DefaultHttpClient) client).getCookieStore();
    }


    @Test(dependsOnMethods = "test1")
    public void test2() throws IOException {
        String testURL,uri;
        uri = bundle.getString("postForm.uri");

        testURL = Url + uri;

        HttpPost post = new HttpPost(testURL);

        HttpClient client = new DefaultHttpClient();

        List<NameValuePair> pars = new ArrayList<NameValuePair>();

        pars.add(new BasicNameValuePair("name","zhangsan"));
        pars.add(new BasicNameValuePair("age","18"));

        post.setEntity(new UrlEncodedFormEntity(pars,"utf-8"));

        ((DefaultHttpClient) client).setCookieStore(this.cookieStore);

        HttpResponse response = client.execute(post);

        String res = EntityUtils.toString(response.getEntity(),"utf-8");

        System.out.println(res);




    }
}
