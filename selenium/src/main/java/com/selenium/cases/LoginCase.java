package com.selenium.cases;

import com.selenium.handle.LoginHandle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginCase {

    LoginHandle loginHandle;
    WebDriver driver;
    @BeforeTest
    public void beforeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\learning\\selenium\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        loginHandle = new LoginHandle(driver);
        driver.get("https://www.imooc.com/user/newlogin");
        Thread.sleep(3000);
    }

    @Test
    public void loginSuccess() throws InterruptedException {
        loginHandle.setUserName("17610463927");
        Thread.sleep(1000);
        loginHandle.setPassWord("176Lyh1046");
        Thread.sleep(1000);
        loginHandle.clickLoginButton();

        Thread.sleep(3000);
        loginHandle.moveToAvatar();
        Thread.sleep(1000);
        Assert.assertEquals("",loginHandle.getUserText());
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
