package com.selenium.util;

import com.google.common.io.Files;
import com.selenium.cases.BaseCase;
import com.selenium.cases.LoginCase;
import com.selenium.page.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult var1) {

        BaseCase baseCase= (BaseCase) var1.getInstance();
        WebDriver driver = baseCase.driver;

        this.currentScreen(driver);

        super.onTestFailure(var1);
    }

    public void currentScreen(WebDriver driver){
        File screenshotAs = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM__dd HH_mm_ss");
        String date = simpleDateFormat.format(new Date());
        String path = "/Users/liyahui/IdeaProjects/gitTest/AutoTest/selenium/src/main/java/com/selenium";
        String phoneName = date + "_" +driver.getTitle();
        try {
            Files.copy(screenshotAs, new File(path +"/"+ phoneName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
