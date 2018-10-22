package com.automationPractice.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class DressesPage extends AbstractWebPage {

    private static final Logger logger = LogManager.getLogger(DressesPage.class);
    protected WebDriver webDriver;
    WebDriverWait wait = new WebDriverWait(super.webDriver, 10);
    private String path1 = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li[";
    private String path2 = "]/div/div[1]/div/div[2]/span[1]";


    private List<Double> originalList = new ArrayList<>();
    private List<Double> sortedList = new ArrayList<>();


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

    @FindBy(css = "#selectProductSort")
    private WebElement sortBy;

    @FindBy(css = "#selectProductSort > option:nth-child(3)")
    private WebElement sortDressesHighToLow;

    @FindBy(css="#layered_ajax_loader > p:nth-child(1) > img:nth-child(1)")
    private WebElement loader;

    public DressesPage(WebDriver webDriver) {
        super(webDriver);

    }

    public ShoppingCartSummaryPage AddMaxValueDressToCartAfterSorting() {
        productLists.get(0).click();
        productLists.get(0).findElement(By.linkText("Add to cart")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".layer_cart_product > h2:nth-child(2)")));
        proceedToCheckout.click();
        return createPage(ShoppingCartSummaryPage.class);
    }

    public ShoppingCartSummaryPage AddMaxValueDressToCart() throws InterruptedException {

        for (int i = 0; i < productLists.size(); i++) {
            Double price = Double.parseDouble((productLists.get(i).findElement(By.cssSelector(".price.product-price")).getAttribute("innerHTML")).trim().substring(1));
            if (price.equals(getMaxPriceDress())) {
                logger.info("The dress with maximum value : " + productLists.get(i).getText());
                productLists.get(i).click();
                productLists.get(i).findElement(By.linkText("Add to cart")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".layer_cart_product > h2:nth-child(2)")));
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

    public void sortByPriceHighToLow() {

       try {
            sortBy.click();
            sortDressesHighToLow.click();
//        css selector of the loading image "#layered_ajax_loader > p:nth-child(1) > img:nth-child(1)"
           wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#layered_ajax_loader > p:nth-child(1) > img:nth-child(1)")));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#layered_ajax_loader")));
//           waitForLoad();
           TimeUnit.SECONDS.sleep(3);
//            Had to use an explicit timeout as the above standard waits are not being recognised by the application.
        } catch (InterruptedException ie) {
           ie.printStackTrace();
        }
    }

    public Boolean AreProductsSortedByPrice(String order) {


        for (int i = 0; i < productLists.size(); i++) {
            int j = i + 1;
            originalList.add(Double.parseDouble(productLists.get(i).findElement(By.xpath(path1 + j + path2)).getAttribute("innerHTML").trim().substring(1)));
            logger.info(productLists.get(i).findElement(By.xpath(path1 + j + path2)).getAttribute("innerHTML").trim().substring(1));
        }
        logger.info("==================Original List ======================");
        logger.info(originalList);
        sortedList = originalList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        if (order.equalsIgnoreCase("ascending")) {
            sortedList = sortedList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        }

        logger.info("==================Sorted List ======================");
        logger.info(sortedList);
        return (originalList.equals(sortedList));

    }

    public void waitForLoad() {
        new WebDriverWait(super.webDriver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

}



