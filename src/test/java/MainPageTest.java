import base.BasePage;
import base.BaseTest;
import org.testng.annotations.Test;
import pages.MainPage;

public class MainPageTest extends BaseTest {
    private MainPage mainPage;
    private BasePage basePage;
    String query = ("case for iphone 11");
    double limit = 20;

    @Test
    public void showPricesTest() {
        mainPage = new MainPage(getDriver());
        basePage = new BasePage();
        basePage.getURL("https://www.amazon.com/");
        mainPage.startSearch(query);
        mainPage.showPrices();
    }
    @Test
    public void showSumPricesTest() {
        mainPage = new MainPage(getDriver());
        basePage = new BasePage();
        basePage.getURL("https://www.amazon.com/");
        mainPage.startSearch(query);
        mainPage.PricesSum(limit);
    }

}
