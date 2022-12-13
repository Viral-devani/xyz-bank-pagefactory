package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class BankTest extends BaseTest {
    HomePage homePage;
    AddCustomerPage addCustomerPage;
    BankManagerLoginPage bankManagerLoginPage;
    OpenAccountPage openAccountPage;
    CustomerLoginPage customerLoginPage;
    CustomerPage customerPage;
    AccountPage accountPage;


    @BeforeMethod(alwaysRun = true)
    public void init() {
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage=new OpenAccountPage();
        customerLoginPage=new CustomerLoginPage();
        customerPage=new CustomerPage();
        accountPage=new AccountPage();

    }

    String firstName = "Harry";
    String lastName = "Porter";
    String postCode = "SW12HB";

    @Test(groups = {"sanity", "smoke", "regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        homePage.clickOnBankManagerLogInTab();
        bankManagerLoginPage.clickOnAddCustomerTab();
        addCustomerPage.addCustomerDetails(firstName, lastName, postCode);
        addCustomerPage.clickOnAddCustomerButton();
        addCustomerPage.verifyPopUpMessage();
        addCustomerPage.clickOnOkButtonOnPopUp();

    }

    @Test(groups = {"smoke", "regression"})
    public void bankManagerShouldOpenAccountSuccessfully() {
        homePage.clickOnBankManagerLogInTab();
        bankManagerLoginPage.clickOnOpenAccountTab();
        openAccountPage.searchAndSelectCreatedCustomer();
        openAccountPage.selectPoundInCurrency();
        openAccountPage.clickOnProcessButton();
        Assert.assertEquals(bankManagerLoginPage.getPopupMsg(), "Account created successfully with account Number :1016", "Message not found");
        bankManagerLoginPage.clickOKOnPopup();

    }
    @Test(groups ="regression")
    public void customerShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnCustomerLoginTab();
        customerPage.searchCustomerYouCreated();
        customerPage.selectName();
        customerLoginPage.clickOnLoginButton();
        customerLoginPage.clickOnLogoutButton();
        Assert.assertEquals(customerLoginPage.getNameTextAfterLogout(), "Your Name :", "Text not found");
    }
    @Test(groups ="regression")
    public void customerShouldDepositMoneySuccessfully() {
        homePage.clickOnCustomerLoginTab();
        customerPage.searchCustomerYouCreated();
        customerPage.selectName();
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnDepositTab();
        accountPage.enterAmountToDeposit("100");
        accountPage.clickOnDepositButton();
        Assert.assertEquals(accountPage.getDepositMsg(),"Deposit Successful","Message not found");
    }
    @Test(groups ="regression")
    public void customerShouldWithdrawMoneySuccessfully(){

        homePage.clickOnCustomerLoginTab();
        customerPage.searchCustomerYouCreated();
        customerPage.selectName();
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnDepositTab();
        accountPage.enterAmountToDeposit("100");
        accountPage.clickOnDepositButton();
        accountPage.clickOnWithdrawTab();
        accountPage.enterAmountToWithdraw("50");
        accountPage.clickOnWithdrawButton();

    }

}
