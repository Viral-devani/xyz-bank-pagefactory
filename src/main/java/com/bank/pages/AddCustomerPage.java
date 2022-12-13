package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy (xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy (xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement buttonAddCustomer;

    public AddCustomerPage() {

        PageFactory.initElements(driver, this);
    }

    public void addCustomerDetails(String fName, String lName, String pCode){
        Reporter.log("Entering customer details " + firstName.toString()+" "+lastName.toString()+" "+postCode.toString());
        sendTextToElement(firstName,fName);
        sendTextToElement(lastName,lName);
        sendTextToElement(postCode,pCode);
    }

    public void clickOnAddCustomerButton() {
        Reporter.log("Clicking on add customer button"+buttonAddCustomer.toString());
        clickOnElement(buttonAddCustomer);
    }

    public void verifyPopUpMessage(){

        String actual = getTextFromAlert();
        String expected = "Customer added successfully with customer id :6";
        Assert.assertEquals(actual,expected,"wrong popup message");
    }

    public void clickOnOkButtonOnPopUp(){
        Reporter.log("Accepting popup message");
        acceptAlert();
    }


}

