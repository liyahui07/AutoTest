package com.selenium.handle;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class BaseHandle {
    public WebDriver driver;

    public BaseHandle(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean isLogin(){
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie c :
                cookies) {
            if (c.getName().contains("apsid")) {
                return true;
            }
            }
        return false;

    }

    public String getTitle(){
        return driver.getTitle();
    }
}
