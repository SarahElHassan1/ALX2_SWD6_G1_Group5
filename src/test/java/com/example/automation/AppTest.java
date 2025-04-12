package com.example.automation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppTest {

    WebDriver driver= new ChromeDriver();


    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo By Al-Yousr\\Documents\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        driver.get("https://demoblaze.com/index.html");
        driver.manage().window().maximize();

    }

    @Test
    public void TestLogin() {
        try { Thread.sleep(2000);

            WebElement Login = driver.findElement(By.id("login2"));
            Login.click();
            Thread.sleep(2000);

            WebElement UserNameLogin = driver.findElement(By.id("loginusername"));
            UserNameLogin.sendKeys("WalaaMohammed");
            Thread.sleep(3000);

            WebElement PasswordLogin = driver.findElement(By.id("loginpassword"));
            PasswordLogin.sendKeys("Walaa12345");
            Thread.sleep(3000);

            WebElement LoginButton = driver.findElement(By.xpath("//button[contains(.,'Log in')]"));
            LoginButton.click();
            Thread.sleep(3000);

            WebElement Laptop=driver.findElement(By.xpath("//a[contains(.,'Laptops')]"));
            Laptop.click();
            Thread.sleep(3000);

WebElement Product=driver.findElement(By.xpath("//a[contains(.,'Sony vaio i5')]"));
Product.click();
            Thread.sleep(2000);

WebElement AddItem=driver.findElement(By.xpath("//a[(@onclick=\"addToCart(8)\")]"));
AddItem.click();
            Thread.sleep(2000);

            Alert alert = driver.switchTo().alert();
            alert.accept();
            Thread.sleep(3000);

            WebElement Cart = driver.findElement(By.id("cartur"));
            Cart.click();
            Thread.sleep(3000);

            WebElement PlaceOrder=driver.findElement(By.xpath("//button[contains(.,'Place Order')]"));
            PlaceOrder.click();
            Thread.sleep(3000);

            WebElement Name=driver.findElement(By.xpath("//input[@type=\"text\" and @id=\"name\"]"));
            Name.sendKeys("Walaa");
            Thread.sleep(2000);

            WebElement Country=driver.findElement(By.id("country"));
            Country.sendKeys("Egypt");
            Thread.sleep(2000);

            WebElement City=driver.findElement(By.id("city"));
            City.sendKeys("Alexandria");
            Thread.sleep(2000);

            WebElement CreditCart=driver.findElement(By.id("card"));
            CreditCart.sendKeys("12");
            Thread.sleep(2000);

            WebElement Month=driver.findElement(By.id("month"));
            Month.sendKeys("4");
            Thread.sleep(2000);

            WebElement Year=driver.findElement(By.id("year"));
            Year.sendKeys("2025");
            Thread.sleep(2000);

            WebElement Purchase=driver.findElement(By.xpath("//button[@onclick=\"purchaseOrder()\"]"));
            Purchase.click();
            Thread.sleep(2000);

            WebElement Ok=driver.findElement(By.xpath("//button[contains(.,'OK')]"));
            Ok.click();
            Thread.sleep(3000);



            WebElement LogOut=driver.findElement(By.id("logout2"));
            LogOut.click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // إغلاق المتصفح بعد كل method
        }
    }
}