package com.automationPractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateAccountSignInPage extends AbstractWebPage {

    private static final Logger logger = LoggerFactory.getLogger(CreateAccountSignInPage.class);

    @FindBy(id = "SubmitCreate")
    WebElement CreateAnAccount;

    @FindBy(id = "email_create")
    WebElement createEmail;

    @FindBy(id = "SubmitLogin")
    WebElement SignIn;

    @FindBy(id = "email")
    WebElement emailId;

    @FindBy(id = "passwd")
    WebElement passwd;

    @FindBy(id = "SubmitLogin")
    WebElement login;


    public CreateAccountSignInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CreateAccountPage clickCreateAnAccount(String email) {
        createEmail.sendKeys(email);
        CreateAnAccount.click();
        return createPage(CreateAccountPage.class);
    }

    public MyAccountPage signInAccount(String email, String password) {
        emailId.sendKeys(email);
        passwd.sendKeys(password);
        login.click();
        return createPage(MyAccountPage.class);
    }

}
