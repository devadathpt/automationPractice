package com.automationPractice.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DressesPage extends AbstractWebPage {

    private static final Logger logger = LogManager.getLogger(DressesPage.class);
    protected WebDriver webDriver;
    private List<Double> allPrices;
    @FindBy(css = ".sf-menu > li:nth-child(2) > a:nth-child(1)")
    private WebElement dressMenu;

    @FindBy(xpath = "//span[@class='price product-price']")
    private List<WebElement> productPrices;

    @FindBy(xpath = "//div[(@class='product-container')]")
    private List<WebElement> productLists;

    @FindBy(css = "a.button-medium > span:nth-child(1)")
    private WebElement proceedToCheckout;

    @FindBy(css = ".layer_cart_product > h2:nth-child(2)")
    private WebElement productAddedSuccessfully;


    public DressesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ShoppingCartSummaryPage AddMaxValueDressToCart() throws InterruptedException {

        for (int i = 0; i < productLists.size(); i++) {
            Double price = Double.parseDouble((productLists.get(i).findElement(By.cssSelector(".price.product-price")).getAttribute("innerHTML")).trim().substring(1));

            if (price.equals(getMaxPriceDress())) {
                logger.info("The dress with maximum value : " + productLists.get(i).getText());
                productLists.get(i).click();
                productLists.get(i).findElement(By.linkText("Add to cart")).click();
                TimeUnit.SECONDS.sleep(3);
                proceedToCheckout.click();
            }

        }
        return createPage(ShoppingCartSummaryPage.class);
    }

    public String addToCartSuccessfully() {
        return productAddedSuccessfully.getAttribute("innerHTML");
    }

    public Double getMaxPriceDress() {
        Double max = Double.MIN_VALUE;

        for (int i = 0; i < productPrices.size(); i++) {
            String value = productPrices.get(i).getText();
            if (!value.isEmpty() && Double.parseDouble(value.substring(1)) > max) {
                max = Double.parseDouble(value.substring(1));

            }
        }
        return max;
    }

}



