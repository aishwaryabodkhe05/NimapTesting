package com.automation.tests;

import com.automation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {

    WebDriver driver;  // WebDriver instance for interacting with browser
    LoginPage loginPage; // Reference to the LoginPage class

    @BeforeClass
    public void setup() {
        // Set the path to the ChromeDriver (change path as needed)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver and open the browser
        driver = new ChromeDriver();

        // Create an instance of LoginPage and pass the driver
        loginPage = new LoginPage(driver);

        // Open the application login page
        driver.get("https://example.com/login");
    }

    @Test(dataProvider = "loginData")
    public void validateLogin(String username, String password) {
        // Perform login using data provider parameters
        loginPage.login(username, password);

        // Validate that the login was successful (e.g., checking the title of the dashboard page)
        Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Login failed: Dashboard not found");
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
            {"test_user", "test_password"},  // Valid login data
            {"invalid_user", "invalid_password"}  // Invalid login data
        };
    }

    @AfterClass
    public void teardown() {
        // Close the browser after test execution
        driver.quit();
    }
}
