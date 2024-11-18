package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerPage {
    WebDriver driver;

    // Locators for the customer form elements (name field, save button, success message)
    By customerNameField = By.id("customerName");  // Update with actual ID of customer name field
    By saveButton = By.id("saveButton");           // Update with actual ID of save button
    By successMessage = By.id("successMessage");   // Update with actual ID of success message element

    // Constructor to initialize the driver
    public CustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to add a customer
    public void addCustomer(String customerName) {
        // Enter customer name in the form
        driver.findElement(customerNameField).sendKeys(customerName);
        
        // Click the Save button
        driver.findElement(saveButton).click();
    }

    // Method to get the success message after adding a customer
    public String getSuccessMessage() {
        // Get and return the success message text
        return driver.findElement(successMessage).getText();
    }
}
