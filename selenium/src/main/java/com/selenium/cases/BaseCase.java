package com.selenium.cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseCase {

    public WebDriver driver;

    public WebDriver getDriver(String browser){
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","/Applications/test/TestTools/selenium/chromedriver");
            driver = new ChromeDriver();
        }

        return driver;


    }
}
