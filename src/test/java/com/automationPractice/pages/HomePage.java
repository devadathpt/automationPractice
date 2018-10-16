package com.automationPractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import stepDefinitions.*;


public class HomePage extends AbstractWebPage {

    private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);

    @FindBy(linkText = "Sign in")
    private WebElement SignInLink;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public CreateAccountSignInPage clickOnSignIn(){
        SignInLink.click();
        return createPage(CreateAccountSignInPage.class); }
}
