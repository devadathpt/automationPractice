package com.automationPractice.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class CreateAccountPage extends AbstractWebPage {

    private static final Logger logger = LogManager.getLogger(CreateAccountPage.class);
    protected WebDriver webDriver;
    @FindBy(id = "id_gender1")
    private WebElement titleMr;

    @FindBy(id = "id_gender2")
    private WebElement titleMrs;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastName;

    @FindBy(id = "email")
    private WebElement emailId;

    @FindBy(id = "passwd")
    private WebElement passwd;

    @FindBy(id = "days")
    private WebElement date;

    @FindBy(id = "months")
    private WebElement month;

    @FindBy(id = "years")
    private WebElement year;

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement addressLine1;

    @FindBy(id = "address2")
    private WebElement addressLine2;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement postCode;

    @FindBy(id = "id_country")
    private WebElement country;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhone;

    @FindBy(id = "alias")
    private WebElement alias;

    @FindBy(id = "submitAccount")
    private WebElement register;

    public CreateAccountPage(WebDriver webDriver) {
        super(webDriver);

    }

    public void inputTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            titleMr.click();
        } else {
            titleMrs.click();
        }
    }

    public void inputfirstName(String firstName) {
        customerFirstName.sendKeys(firstName);
    }

    public void inputlastName(String lastName) {
        customerLastName.sendKeys(lastName);
    }

    public void inputEmail(String email) {
        emailId.sendKeys(email);
    }

    public void inputPassword(String password) {
        passwd.sendKeys(password);
    }

    public void inputDateOfBirth(String dob) {
        String[] parts = dob.split("-");
        date.sendKeys(parts[0]);
        month.sendKeys(parts[1]);
        year.sendKeys(parts[2]);
    }

    public void inputCompany(String companyName) {
        company.sendKeys(companyName);
    }

    public void inputAddress(String address) {
        addressLine1.sendKeys(address);
    }

    public void inputCity(String cityName) {
        city.sendKeys(cityName);
    }

    public void inputState() {
        Select objSel = new Select(state);
        List<WebElement> weblist = objSel.getOptions();
        int iCnt = weblist.size();
        Random num = new Random();
        int iSelect = num.nextInt(iCnt);
        objSel.selectByIndex(iSelect);
        System.out.println(state.getAttribute("value"));
    }


    public void inputCountry(String countryName) {
        country.sendKeys(countryName);
    }

    public void inputPostCode(String postCodeNum) {
        postCode.sendKeys(postCodeNum);
    }

    public void inputPhone(String phone) {
        mobilePhone.sendKeys(phone);
    }

    public void inputAlias(String aliasName) {
        alias.sendKeys(aliasName);
    }


    public MyAccountPage clickOnRegister() {
        register.click();
        return createPage(MyAccountPage.class);
    }

}
