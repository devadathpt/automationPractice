package com.automationPractice.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartSummaryPage extends AbstractWebPage {

    protected WebDriver webDriver;
    private static final Logger LOG = LogManager.getLogger(ShoppingCartSummaryPage.class);

    public ShoppingCartSummaryPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css =".logout")
    private WebElement signOut;

    @FindBy(css="span.ajax_cart_quantity:nth-child(2)")
    private WebElement quantityAddedToCart;

    @FindBy(css=".ajax_cart_no_product")
    private WebElement noProduct;

    public void signOut(){
        signOut.click();
         }

         public int numOfProductsInCart()
         {
             return Integer.parseInt(quantityAddedToCart.getAttribute("innerHTML"));
         }


}


