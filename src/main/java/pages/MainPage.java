package pages;

import base.BasePage;
import com.sun.tools.javac.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class MainPage extends BasePage {
    public WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy (css = "#nav-logo")
    private WebElement element;
    @FindBy (css = "#twotabsearchtextbox")
    private WebElement SearchField;
    @FindBy (css = "#nav-search-submit-text")
    private WebElement SearchButton;
    @FindBy (xpath = "//span[@class=\"a-offscreen\"]")
    private List<WebElement> Prices;

    private void clickSearchField() {
        clickOnElement(SearchField);
    }

    private void typeSearchField(String query) {
        System.out.println("Enter name of query search: " + query);
        sendKeys(SearchField, query);

    }

    private void clickSearchButton() {
        clickOnElement(SearchButton);

    }

    public void startSearch(String query) {
        clickSearchField();
        typeSearchField(query);
        clickSearchButton();

    }
    private ArrayList<Double> getPrices() {
        return getPrices(Prices);
    }

    public void showPrices() {
        showPrices(getPrices());
    }

    /*public void showPrices(ArrayList<Double> prices, double limit) {
        showPrices(getPrices(), limit);
    }*/

    public void PricesSum(double limit){
        double sum = 0;
        for (WebElement Price: Prices) {
            String s = Price.getText().replaceAll("[^0-9]", "");
            double priceLower20 = Double.parseDouble(s);
            if (priceLower20>limit){
                sum = sum + priceLower20;
            }
        }
        if (sum == 0) {
            System.out.println("No Such items");
        } else
            System.out.println("Price sum " + sum + " $");
    }
    }

   /* private void searchLowPrices(double limit, String search) {
        this.typeSearchField(SearchData.SEARCH_DATA.getSearchdata());
        this.clickSearchButton();
        this.sumOfPricesLower(20.00);

    }*/


