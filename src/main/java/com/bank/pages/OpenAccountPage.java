package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {
    public OpenAccountPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement searchText;

    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencyText;

    @FindBy(xpath = "//button[normalize-space()='Process']")
    WebElement processButton;

    By customerDropdown = By.id("userSelect");
    By currencyDropdown = By.id("currency");


    public void searchAndSelectCreatedCustomer() {
        Reporter.log("selext text from dropdown" +customerDropdown.toString());
        selectByVisibleTextFromDropDown(customerDropdown, "Harry Potter");
    }

    public void selectPoundInCurrency() {
        Reporter.log("select text from dropdown " +currencyDropdown.toString());
        selectByVisibleTextFromDropDown(currencyDropdown, "Pound");
    }

    public void clickOnProcessButton() {
        Reporter.log("Clicking on add Process button"+processButton.toString());
        clickOnElement(processButton);
    }
}


