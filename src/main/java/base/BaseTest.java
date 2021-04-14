package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    /*private static ThreadLocal<ExtentTest> test = new ThreadLocal();
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal();*/
    static WebDriver driver;
    private static ThreadLocal<WebDriver> WEBDRIVER_CONTAINER = new ThreadLocal<WebDriver>();
    /*private static WebDriver driver;
    FirefoxOptions options = new FirefoxOptions();
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal();*/

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");
        //options.setHeadless(true);


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WEBDRIVER_CONTAINER.set(driver);


    }

    public static WebDriver getDriver() {
        return WEBDRIVER_CONTAINER.get();
    }


    /*@BeforeMethod
    public void setUp() {
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--add-exports");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebDriverWait wait = (new WebDriverWait(driver, 100));
        DRIVER.set(driver);


    }*/
    @AfterMethod

    public void quit() {

        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
            WEBDRIVER_CONTAINER.remove();
        }
    }

   /* public static ThreadLocal<ExtentTest> getTest() {
        return test;
    }*/

   /* @AfterMethod
    public void tearDown() {
        driver.quit();*/

}
    /*public static WebDriver getDriver() {
        return DRIVER.get();
    }*/

