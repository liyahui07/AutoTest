package com.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getElement(String key){
        WebElement element = driver.findElement(getBy(key));
        return element;
    }

    public By getBy(String key){
        Properties properties = new Properties();
        String path = this.getClass().getClassLoader().getResource("./par.properties").getPath();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);

            if (properties.containsKey(key)){

                String property = properties.getProperty(key);
                //key1一般是元素的key值  例如className
                String key1 = property.split(",")[0];
                System.out.println("key1="+key1);
                //key2元素的value值  例如：具体的className
                String key2 = property.split(",")[1];
                System.out.println("key2=" + key2);

                if (key1.equals("id")){
                    return By.id(key2);
                }else if (key1.equals("className")){
                    return By.className(key2);
                }else if (key1.equals("tagName")){
                    return By.tagName(key2);
                }else if (key1.equals("linkText")){
                    return By.linkText(key2);
                }else if (key1.equals("name")){
                    return By.name(key2);
                }
            }
            fileInputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }


        return null;
    }


    public void moveToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
