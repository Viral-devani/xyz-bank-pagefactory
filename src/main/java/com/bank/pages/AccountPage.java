package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AccountPage extends Utility {
    public AccountPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@ng-click='deposit()']")
    WebElement depositTab;

   @FindBy(xpath = "//input[@ng-model='amount']")
   WebElement amountField;


    @FindBy(xpath = "//button[text()='Deposit']")
    WebElement depositButton;


    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    WebElement  withdrawTab;

   @FindBy(xpath = "//button[text()='Withdraw']")
   WebElement withdrawButton;


    @FindBy(xpath = "//span[text()='Transaction Successful']")
    WebElement  withdrawMsg;

    @FindBy(xpath = "//span[text()='Deposit Successful']")
    WebElement depositMsg;

    public void clickOnDepositTab() {

        clickOnElement(depositTab);
    }

    public void enterAmountToDeposit(String text) {
        Reporter.log("Enter Amount " + text + " to amountfield " + amountField.toString());
        sendTextToElement(amountField, text);
    }

    public void clickOnDepositButton() {
        Reporter.log("Clicking on deposit Button " + depositButton.toString());
        clickOnElement(depositButton);
    }

    public String getDepositMsg() {
        Reporter.log("Get deposit message " + depositMsg.toString());
        return getTextFromElement(depositMsg);
    }

    public void clickOnWithdrawTab() {
        Reporter.log("Clicking on withdraw tab " + withdrawTab.toString());
        clickOnElement(withdrawTab);
    }

    public void enterAmountToWithdraw(String text) {
        Reporter.log("Enter username " + text + " to username field " + amountField.toString());
        sendTextToElement(amountField, text);
    }

    public void clickOnWithdrawButton() {
        Reporter.log("clicking on withdrawbutton " + withdrawButton.toString());
        clickOnElement(withdrawButton);
    }

    public String getWithdrawMsg() {
        Reporter.log("Get withdraw message " + withdrawMsg.toString());
        return getTextFromElement(withdrawMsg);
    }
}



