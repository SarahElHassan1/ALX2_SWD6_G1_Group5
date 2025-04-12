package com.example.automation;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import java.time.Duration;

public class CartTest {
    WebDriver driver;
    WebDriverWait wait;

    // Setup method to initialize WebDriver and other setups
    @BeforeMethod
    public void setUp() {
        // Initialize the ChromeDriver
        driver = new ChromeDriver();

        // Maximize the window and navigate to the URL
        driver.manage().window().maximize();
        driver.navigate().to("https://demoblaze.com/index.html");

        // Initialize the WebDriverWait object for explicit waits
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // the test case
    @Test
    public void testAddProductToCartDelete() {
        // Wait until the "Samsung galaxy s6" link is clickable and click it
        WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Samsung galaxy s6")));
        productLink.click();

        // Wait until the "Add to cart" button is clickable and click it
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add to cart")));
        addToCartButton.click();

        // Wait for the alert to be present (this is a pop-up confirming the product is added)
        wait.until(ExpectedConditions.alertIsPresent());

        // Switch to the alert and get its text
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        // Print the alert's text
        System.out.println(alertText);

        // Wait for 2 seconds before accepting the alert
        sleep(2000);

        // Accept the alert to close the pop-up
        alert.accept();

        // Assert that the alert's text is "Product added"
        assert alertText.equals("Product added");

        // Wait for 2 seconds
        sleep(2000);

        // Go to the cart page
        WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Cart")));
        cartLink.click();

        // Wait for 2 seconds
        sleep(2000);

        // Delete the product from the cart
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Delete")));
        deleteButton.click();

        // Wait for 2 seconds before finishing the test
        sleep(2000);
    }

    // end method to clean up after the test
    @AfterMethod
    public void End() {
        // Close the browser after the test is done
        driver.quit();
    }

    // the sleep method to wait for the specified amount of time
    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }
}