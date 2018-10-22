package com.automationPractice.stepDefinitions;

import com.automationPractice.driver.WebDriverFactory;
import com.automationPractice.pages.*;
import com.automationPractice.utility.LoadConfigClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Assert;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.util.Properties;
import java.util.UUID;

public class AddCartSteps extends AbstractSteps {

    private static final String title = "Mr";
    private static final String password = "Password@123";
    private static final String phoneNo = "123456789";
    private static final String postCode = "00000";
    private static final String dob = "23-March-1995";
    private static final Logger logger = LogManager.getLogger(AddCartSteps.class);
    private static final DataFactory df = new DataFactory();
    public HomePage homePage;
    private CreateAccountSignInPage createAccountSignInPage;
    private CreateAccountPage createAccountPage;
    private MyAccountPage myAccountPage;
    private DressesPage dressesPage;
    private ShoppingCartSummaryPage shoppingCartSummaryPage;
    private String email;
    private Properties config = null;


    private static String getRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    @Given("^I am on the signIn or create account page$")
    public void iAmOnTheSignInOrCreateAccountPage() throws Throwable {
        config = new Properties();
        FileInputStream fs1 = LoadConfigClass.configfile((FileInputStream fs) -> fs);

        config.load(fs1);

        webDriver = WebDriverFactory.createInstance();
        logger.info("Opening Browser");
        logger.info("               ");

        webDriver.get(config.getProperty("Test_URL"));
        homePage = createPage(HomePage.class);
        createAccountSignInPage = homePage.clickOnSignIn();
        logger.info("Opening SignIn/Create Account Page");
    }

    @And("^I create a new customer account$")
    public void iCreateANewCustomerAccount() {
        this.email = getRandomEmail(10).replace(" ", "");
        logger.info("email : " + email);
        logger.info("password : "+ password);
        createAccountPage = createAccountSignInPage.clickCreateAnAccount(email);
        createAccountPage.inputTitle(title);
        createAccountPage.inputfirstName(df.getFirstName() + getRandomString(5));
        createAccountPage.inputlastName(df.getLastName() + getRandomString(5));
        createAccountPage.inputPassword(password);
        createAccountPage.inputDateOfBirth(dob);
        createAccountPage.inputAddress(df.getAddressLine2() + getRandomString(5));
        createAccountPage.inputPostCode(postCode);
        createAccountPage.inputCity(getRandomString(6));
        createAccountPage.inputState();
        createAccountPage.inputPhone(phoneNo);
        logger.info("Logging using email : " + email);
        logger.info("password : "+ password);
        myAccountPage = createAccountPage.clickOnRegister();

    }

    @And("^I add a dress of highest price to my cart$")
    public void iAddADressOfHighestPriceToMyCart() {

        dressesPage = myAccountPage.clickOnDressesMenu();
        try {
            logger.info("Adding a dress with maximum price ");
            shoppingCartSummaryPage = dressesPage.AddMaxValueDressToCart();
            Assert.assertEquals("<i class=\"icon-ok\"></i>Product successfully added to your shopping cart",dressesPage.addToCartSuccessfully().trim());
            logger.info("Dress added to Cart");
        }
        catch(InterruptedException ie) {
            ie.printStackTrace();
        }

    }

    @And("^I sort the dresses by highest price$")
    public void iSortTheDressesBy()
    {
        dressesPage = myAccountPage.clickOnDressesMenu();
        dressesPage.sortByPriceHighToLow();
    }

    @And("^the prices are sorted in (.*) order$")
    public void thePricesAreSorted(String order)
    {


try {
    Assert.assertEquals(true, dressesPage.AreProductsSortedByPrice(order));
}
catch (AssertionError e) {
    logger.info("The products are not sorted in the order " + order);
    webDriver.quit();
}
    }

    @And("^I add the first dress after sorting$")
    public void iAddTheFirstDressAfterSorting()
    {
        shoppingCartSummaryPage=dressesPage.AddMaxValueDressToCartAfterSorting();
    }


    @And("^I sign out of my account$")
    public void iSignOutOfMyAccount() {
        logger.info("Logging out of my account");
        shoppingCartSummaryPage.signOut();
        logger.info("Closing the browser : " );
        webDriver.quit();

    }



    @And("^I log back into my account$")
    public void iLogBackIntoMyAccount()
    {
        logger.info("Logging using email : " + this.email);
        logger.info("password : "+ password);
        myAccountPage = createAccountSignInPage.signInAccount(this.email, password);
        Assert.assertEquals("MY ACCOUNT",myAccountPage.loginSuccess());
    }

    @Then("^The dress (is|is not) available in my cart$")
    public void theDressIsAvailableInMyCart(String isOrisNot)
    {
        if (isOrisNot.equalsIgnoreCase("is"))
        {
            shoppingCartSummaryPage = myAccountPage.clickOnCart();
            Assert.assertEquals(1, shoppingCartSummaryPage.numOfProductsInCart());

        }
        else if(isOrisNot.equalsIgnoreCase("is not"))
        {
            shoppingCartSummaryPage = myAccountPage.clickOnCart();
            Assert.assertEquals(0, shoppingCartSummaryPage.numOfProductsInCart());
        }
        logger.info("Closing the browser : " );
        webDriver.quit();

    }


    @And("^I login using email (.*) and password (.*)$")
    public void iLoginUsingEmail(String email, String password) {
        logger.info("Logging using email : " + email);
        logger.info("password : "+ password);
        myAccountPage = createAccountSignInPage.signInAccount(email, password);
        Assert.assertEquals("MY ACCOUNT",myAccountPage.loginSuccess());
    }

    private String getRandomEmail(int length) {
        StringBuilder buffer = new StringBuilder();
        while (buffer.length() < length) {
            buffer.append(shortUUID());
        }
        return "success" + buffer.substring(0, length) + "@abctest.com";
    }

    private String shortUUID() {
        UUID uuid = UUID.randomUUID();
        long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
        return Long.toString(l, Character.MAX_RADIX);
    }
    }
