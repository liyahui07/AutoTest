package com.selenium.cases;

import com.selenium.handle.LoginHandle;
import com.selenium.handle.ShoppingHandle;
import com.selenium.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class ShopCartCase extends BaseCase{

    WebDriver driver;
    ShoppingHandle shoppingHandle;
    @Parameters({"url","browser"})
    @BeforeTest
    public void beforeTest(String url,String browser){

        driver = getDriver(browser);
        shoppingHandle = new ShoppingHandle(driver);
        driver.get(url);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() throws InterruptedException {


        if (shoppingHandle.getTitle().contains("Go+Python双语言混合开发")){
            System.out.println("打开网页成功");
            Thread.sleep(2000);

            shoppingHandle.setCookies();
            Thread.sleep(2000);

            driver.navigate().refresh();
            Thread.sleep(2000);
            //获取没点击加购物车时的数量
            Integer cartNum = shoppingHandle.getCartNum();
            Thread.sleep(2000);

            shoppingHandle.clickCourseShopCart();
            Thread.sleep(2000);
            //获取点击添加购物车后的购物车数量
            Integer cartNum1 = shoppingHandle.getCartNum();
            Thread.sleep(2000);

            int cart = cartNum1 - cartNum;

            Assert.assertEquals(cart,3);
            System.out.println("购物车比对成功");
        }



    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
