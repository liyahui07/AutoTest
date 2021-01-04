package com.selenium.cases;

import com.selenium.handle.LoginHandle;
import com.selenium.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class LoginCase {

    LoginHandle loginHandle;
    public WebDriver driver;
    @Parameters("url")
    @BeforeTest
    public void beforeTest(String url) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Applications/test/TestTools/selenium/chromedriver");
        driver = new ChromeDriver();
        loginHandle = new LoginHandle(driver);
        driver.get(url);
        Thread.sleep(3000);
    }

    @Parameters({"username","password"})
    @Test
    public void loginSuccess(String username,String password) throws InterruptedException {
        loginHandle.setUserName(username);
        Thread.sleep(1000);
        loginHandle.setPassWord(password);
        Thread.sleep(1000);
        loginHandle.clickLoginButton();

        Thread.sleep(3000);
        loginHandle.moveToAvatar();
        Thread.sleep(3000);
        Assert.assertEquals("慕哥9355720",loginHandle.getUserText());


    }

    @Parameters({"username1","password1"})
    @Test
    public void loginFail(String username1,String password1) throws InterruptedException {
        loginHandle.setUserName(username1);
        Thread.sleep(1000);
        loginHandle.setPassWord(password1);
        Thread.sleep(1000);
        loginHandle.clickLoginButton();

        Thread.sleep(3000);
        loginHandle.moveToAvatar();
        Thread.sleep(3000);
        Assert.assertEquals("慕哥9355720",loginHandle.getUserText());


    }

    @AfterTest
    public void afterTest(){
        driver.quit();

    }
}
