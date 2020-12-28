package com.selenium.handle;

import com.selenium.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginHandle {
    LoginPage loginPage;


    public LoginHandle(WebDriver webDriver) {
        loginPage = new LoginPage(webDriver);
    }

    public void setUserName(String userName){
        loginPage.getUserName().sendKeys(userName);
    }

    public void setPassWord(String passWord){
        loginPage.getPassWord().sendKeys(passWord);
    }

    public void clickLoginButton(){
        loginPage.getLoginButton().click();
    }


    public void moveToAvatar(){
        WebElement userAvatar = loginPage.getUserAvatar();
        loginPage.moveToElement(userAvatar);
    }

    public String getUserText(){
        return loginPage.getUserText().getText();
    }

}
