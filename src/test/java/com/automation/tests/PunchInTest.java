package com.automation.tests;

import com.automation.pages.PunchInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class PunchInTest {
    WebDriver driver;
    PunchInPage punchInPage;

    @BeforeClass
    public void setup() {
        // Set up the WebDriver (using Chrome in this example)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update path
        driver = new ChromeDriver();
        punchInPage = new PunchInPage(driver);

        // Navigate to the web page
        driver.get("https://example.com/dashboard"); // Update with actual URL
    }

    @Test
    public void validatePunchIn() {
        // Perform the punch-in action and capture the toast message
        String message = punchInPage.punchIn();

        // Validate that the toast message is as expected
        Assert.assertEquals(message, "Punch In Successful!");
    }

    @AfterClass
    public void teardown() {
        // Close the browser after the test is complete
        driver.quit();
    }
}
