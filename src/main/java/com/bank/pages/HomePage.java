package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {
    @FindBy(xpath ="//button[normalize-space()='Bank Manager Login']" )
    WebElement bankManagerLogInTab;

    @FindBy (xpath ="//button[normalize-space()='Customer Login']")
    WebElement customerLoginTab;

    public HomePage() {
        PageFactory.initElements(driver,this);
    }

    public void clickOnBankManagerLogInTab(){
        Reporter.log("Clicking on BankManager logintab " + bankManagerLogInTab.toString());
        clickOnElement(bankManagerLogInTab);
    }


    public void clickOnCustomerLoginTab(){
        Reporter.log("Clicking on Login Button " + customerLoginTab.toString());
        clickOnElement(customerLoginTab);
    }
}
