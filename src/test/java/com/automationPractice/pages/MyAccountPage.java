package com.automationPractice.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends AbstractWebPage {

    protected WebDriver webDriver;
    private static final Logger LOG = LogManager.getLogger(MyAccountPage.class);

    @FindBy(css=".page-heading")
    private WebElement pageHeading;

    @FindBy(css =".info-account")
    private WebElement radioButtonYes;

    @FindBy(css =".sf-menu > li:nth-child(2) > a:nth-child(1)")
    private WebElement dressesMenu;

    @FindBy(css=".shopping_cart")
    private WebElement shoppingCart;

    @FindBy(css=".ajax_cart_no_product")
    private WebElement noProduct;

    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DressesPage clickOnDressesMenu(){
        dressesMenu.click();
        return createPage(DressesPage.class); }

        public String loginSuccess()
        {
            return pageHeading.getText();
        }

    public ShoppingCartSummaryPage clickOnCart(){
        shoppingCart.click();
        return createPage(ShoppingCartSummaryPage.class); }

    public String noProductAdded()
    {
        return noProduct.getText();
    }

}
