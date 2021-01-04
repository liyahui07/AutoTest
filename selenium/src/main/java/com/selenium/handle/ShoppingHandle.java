package com.selenium.handle;

import com.selenium.page.ShoppingCartPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class ShoppingHandle extends BaseHandle{

    ShoppingCartPage shoppingCartPage;

    public ShoppingHandle(WebDriver driver) {
        super(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    public void setCookies(){
        Boolean login = isLogin();
        if (login){
            System.out.println("用户已登陆");
        }else {
            String value = "FiN2YwYTgyMDYzMTc4MGFmMDg3ZjA3OGIwYzQyZTEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOTU2NjkxMgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADk4ZmVhYjZiOTExMGMwNzM1MTY1OWE4OWRlMTFjZjdmqpTxX6qU8V8%3DMj";
            Cookie cookie = new Cookie("apsid",value,".imooc.com","/",null);
            driver.manage().addCookie(cookie);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("增加cookies成功:" + driver.manage().getCookies());
        }
    }
    //点击添加购物车
    public void clickCourseShopCart(){
        shoppingCartPage.getAddCart().click();
    }
    //获取课程页购物车数量
    public Integer getCartNum(){
        String text = shoppingCartPage.getCartNum().getText();
        Integer a;
        try {
            a = Integer.parseInt(text);
        }catch (Exception e){
            a = 0;
        }
        return a;
    }
}
