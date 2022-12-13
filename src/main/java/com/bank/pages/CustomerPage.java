package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CustomerPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerName ;


    public CustomerPage() {
        PageFactory.initElements(driver, this);
    }


    public void searchCustomerYouCreated() {
        Reporter.log("search customer ypu create" +customerName.toString());
        mouseHoverToElementAndClick(customerName);
    }

    public void selectName() {
        Reporter.log("select name" +customerName.toString());
        selectByVisibleTextFromDropDown(customerName, "Harry Potter");
    }
}


