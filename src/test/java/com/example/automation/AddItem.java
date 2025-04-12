package com.example.automation;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;

import java.time.Duration;
public class AddItem {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Setup ChromeDriver and open the website
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoblaze.com/index.html");
    }

    // Step 1: Login with valid credentials
    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        driver.findElement(By.id("login2")).click();
        Thread.sleep(1000); // Wait for login modal to appear

        driver.findElement(By.id("loginusername")).sendKeys("sarahelhassan1");
        driver.findElement(By.id("loginpassword")).sendKeys("Sarah@1234");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        Thread.sleep(3000); // Wait for login to complete
        Assert.assertTrue(driver.getPageSource().contains("Welcome"), "Login failed!");
    }

    // Step 2: Choose a product and add it to the cart
    @Test(priority = 2)
    public void chooseProductAndAddToCart() throws InterruptedException {
        driver.findElement(By.linkText("Samsung galaxy s6")).click();
        Thread.sleep(2000); // Wait for product page to load

        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(3000); // Wait for alert

        driver.switchTo().alert().accept(); // Accept add to cart alert
    }

    // Step 3: Checkout and place the order
    @Test(priority = 3)
    public void checkoutAndPlaceOrder() throws InterruptedException {
        driver.findElement(By.id("cartur")).click();
        Thread.sleep(3000); // Wait for cart page

        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        Thread.sleep(1000); // Wait for order modal

        driver.findElement(By.id("name")).sendKeys("John Doe");
        driver.findElement(By.id("country")).sendKeys("USA");
        driver.findElement(By.id("city")).sendKeys("New York");
        driver.findElement(By.id("card")).sendKeys("1234567890123456");
        driver.findElement(By.id("month")).sendKeys("12");
        driver.findElement(By.id("year")).sendKeys("2025");

        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
        Thread.sleep(2000); // Wait for confirmation

        WebElement confirmation = driver.findElement(By.className("sweet-alert"));
        Assert.assertTrue(confirmation.isDisplayed(), "Order confirmation not displayed");

        System.out.println("Confirmation: " + confirmation.getText());

        driver.findElement(By.xpath("//button[text()='OK']")).click(); // Close confirmation dialog
    }

    @AfterClass
    public void tearDown() {
        driver.quit(); // Close browser after test execution
    }
}
