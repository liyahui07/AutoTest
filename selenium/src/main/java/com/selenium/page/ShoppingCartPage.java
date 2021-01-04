package com.selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends BasePage{

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    //将课程加入购物车
    public WebElement getAddCart(){
        return getElement("add_Cart");
    }
    //获取购物车数量
    public WebElement getCartNum(){
        return getElement("cart_Num");
    }
}
