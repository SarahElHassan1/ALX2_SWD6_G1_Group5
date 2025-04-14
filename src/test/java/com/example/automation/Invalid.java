package com.example.automation;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import java.time.Duration;
public class Invalid {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Setup ChromeDriver and open the website
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoblaze.com/index.html");
    }

    // Step 1: Login with invalid credentials
    @Test(priority = 1)
    public void loginTestinvalid() throws InterruptedException {
        driver.findElement(By.id("login2")).click();
        Thread.sleep(1000); // Wait for login modal to appear

        driver.findElement(By.id("loginusername")).sendKeys("sarahelhassan1");
        driver.findElement(By.id("loginpassword")).sendKeys("Sarah@123433");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        Thread.sleep(3000); // Wait for login to complete
        Assert.assertTrue(driver.getPageSource().contains("Welcome"), "Login failed!");
    }
    @AfterTest
    public void end() {
        driver.quit(); // Close browser after test execution
    }
}

