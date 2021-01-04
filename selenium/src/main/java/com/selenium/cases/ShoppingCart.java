package com.selenium.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class ShoppingCart  {

   WebDriver driver;

   @BeforeTest
   public void beforeTest(){
       System.setProperty("webdriver.chrome.driver","/Applications/test/TestTools/selenium/chromedriver");
       driver = new ChromeDriver();

       driver.get("https://coding.imooc.com/class/469.html");
   }

   @Test
   public void test1() throws InterruptedException {
       Thread.sleep(1000);
       String title = driver.getTitle();
       //String text = driver.findElement(By.className("js-cart-num")).getText();
       String value = "FiN2YwYTgyMDYzMTc4MGFmMDg3ZjA3OGIwYzQyZTEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOTU2NjkxMgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADk4ZmVhYjZiOTExMGMwNzM1MTY1OWE4OWRlMTFjZjdmqpTxX6qU8V8%3DMj";

       if (title.contains("Go+Python双语言混合开发")){
           System.out.println("打开网页成功");
           boolean flag = false;
           Set<Cookie> cookies = driver.manage().getCookies();
           for (Cookie c :
                   cookies) {
               if (c.getName().contains("apsid")) {
                   flag = true;
               }
               }
           if (flag){
               List<WebElement> addcart = driver.findElements(By.className("addcart"));
               Thread.sleep(1000);
               addcart.get(0).click();
           }else {
               Cookie cookie = new Cookie("apsid",value,".imooc.com","/",null);
               driver.manage().addCookie(cookie);
               Thread.sleep(1000);
               driver.navigate().refresh();
               List<WebElement> addcart = driver.findElements(By.className("addcart"));
               Thread.sleep(1000);
               addcart.get(0).click();
               //点击假如购物车后需要等待几秒用来等待商品加入
               Thread.sleep(2000);
               WebElement element = driver.findElement(By.id("shop-cart"));
               String text1 = element.findElement(By.className("js-cart-num")).getText();
               System.out.println(text1);
               Thread.sleep(2000);
           }


       }
   }

   @AfterTest
   public void afterTest(){
       driver.quit();
   }
}
