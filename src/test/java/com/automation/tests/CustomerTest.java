package com.automation.tests;

import com.automation.pages.CustomerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CustomerTest {
    WebDriver driver;
    CustomerPage customerPage;

    @BeforeClass
    public void setup() {
        // Set up the WebDriver (using Chrome in this example)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");  // Update path
        driver = new ChromeDriver();
        customerPage = new CustomerPage(driver);

        // Navigate to the web page (Add Customer page)
        driver.get("https://example.com/add-customer");  // Update with actual URL
    }

    // Parameterized test to add customers
    @Test(dataProvider = "customerData")
    public void validateAddCustomer(String customerName) {
        // Perform the Add Customer action
        customerPage.addCustomer(customerName);
        
        // Validate that the success message is as expected
        String message = customerPage.getSuccessMessage();
        Assert.assertEquals(message, "Customer added successfully!");  // Expected success message
    }

    // DataProvider to provide different customer names for the test
    @DataProvider(name = "customerData")
    public Object[][] getData() {
        return new Object[][] {
            {"Customer A"},  // First customer name
            {"Customer B"},  // Second customer name
            {"Customer C"}   // Third customer name
        };
    }

    @AfterClass
    public void teardown() {
        // Close the browser after the test is complete
        driver.quit();
    }
}
