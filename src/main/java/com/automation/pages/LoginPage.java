package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Locators for login page elements
    By usernameField = By.id("username");  // Adjust the selector as per actual app
    By passwordField = By.id("password");  // Adjust the selector as per actual app
    By loginButton = By.id("loginButton");  // Adjust the selector as per actual app

    // Constructor to initialize the WebDriver instance
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to perform login with username and password
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);  // Fill username field
        driver.findElement(passwordField).sendKeys(password);  // Fill password field
        driver.findElement(loginButton).click();               // Click login button
    }
}
