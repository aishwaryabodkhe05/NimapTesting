package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PunchInPage {
    WebDriver driver;

    By punchInButton = By.id("punchInButton");
    By toastMessage = By.id("toastMessage");

    public PunchInPage(WebDriver driver) {
        this.driver = driver;
    }

    public String punchIn() {
        // Click the PunchIn button
        driver.findElement(punchInButton).click();

        // Use WebDriverWait to wait for the toast message to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessage));

        // Return the text of the toast message
        return toast.getText();
    }
}

