package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {

    public CustomerLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;


    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logoutText;
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement yourNameTextAfterLogout;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Logout']")
    WebElement logoutButton;


    public void clickOnLoginButton() {
        Reporter.log("Clicking on Login Button " + loginButton.toString());
        clickOnElement(loginButton);
    }

    public String getLogoutText() {
        Reporter.log("verify " + logoutText.toString());
        return getTextFromElement(logoutText);
    }

    public void clickOnLogoutButton() {
        Reporter.log("Clicking on Logout Button " + logoutButton.toString());
        clickOnElement(logoutButton);
    }

    public String getNameTextAfterLogout() {
        Reporter.log("verify logout text " + yourNameTextAfterLogout.toString());
        return getTextFromElement(yourNameTextAfterLogout);
    }
}


