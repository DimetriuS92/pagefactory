package pages;

import base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class MainPage extends BasePage {

    public WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    String urlString = "https://www.amazon.com/";
    /*@FindBy (css = "#nav-logo")
    private WebElement element;*/
    By SearchField = By.cssSelector("#twotabsearchtextbox");
    /*private WebElement ;*/
    By SearchButton = By.cssSelector("#nav-search-submit-text");
    /* By Prices = By.xpath("//span[@class=\"a-offscreen\"]");*/
    /*List<WebElement> Prices = driver.findElements(By.xpath("//span[@class=\"a-offscreen\"]"));*/
    By sumprices = By.xpath("//span[@class=\"a-offscreen\"]");



    /*@FindBy (css = "#nav-search-submit-text")
    private WebElement SearchButton;

    @FindBy (xpath = "//span[@class=\"a-offscreen\"]")
    private List<WebElement> Prices;*/
    public MainPage getPage() {
        getURL(urlString);
        return this;
    }

    /*private void clickSearchField() {
        clickOnVisibleElement(SearchField);
    }*/

    private void typeSearchField(String query) {
        System.out.println("Enter name of query search: " + query);
        sendKeys(SearchField, query);

    }

    private void clickSearchButton() {
        clickOnVisibleElement(SearchButton);

    }

    public void startSearch(String query) {
        /*clickSearchField();*/
        typeSearchField(query);
        clickSearchButton();

    }



   /* public void showPrices(ArrayList<Double> prices, double limit) {
        showPrices(getPrices(), limit);
    }*/

    public void PricesSum(double limit) {
        List<WebElement> Prices = driver.findElements(sumprices);
        double sum = 0;
        for (WebElement Price : Prices) {
            String priceCase = Price.getAttribute("innerHTML").replaceAll("[$A-Za-z]", "");
            double priceLower20 = parseDouble(priceCase);
            if (priceLower20 > limit) {
                sum = sum + priceLower20;
            }
        }
        if (sum == 0) {
            System.out.println("No Such items");
        } else
            System.out.println("Price sum " + sum + " $");
    }
    public ArrayList<Double> getPrices() {
        return getPricesList(sumprices);
    }

    public void showPrices() {
        showPrices(getPrices());
    }
    /*private ArrayList<Integer> getSaturnPrices() {
        return getPrices(saturnPrices);
    }

    public void showSaturnPrices() {
        showPrices(getSaturnPrices());
    }

    public void showSaturnPricesSum(int limit) {
        showPricesSum(getSaturnPrices(), limit);
    }*/
}

   /*private void searchLowPrices(double limit, String search) {
        this.typeSearchField(SearchData.SEARCH_DATA.getSearchdata());
        this.clickSearchButton();
        this.sumOfPricesLower(20.00);

    }*/


