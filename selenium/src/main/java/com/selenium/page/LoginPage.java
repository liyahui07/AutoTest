package com.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUserName(){
        return getElement("username");
    }

    public WebElement getPassWord(){
        return getElement("password");
    }

    public WebElement getLoginButton(){
        return getElement("loginButton");
    }

    public WebElement getUserAvatar(){
        return getElement("Avatar");
    }

    public WebElement getUserText(){
        WebElement userText = getElement("UserText");
        WebElement span = userText.findElement(By.tagName("span"));
        return span;
    }
}
