import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataProviderBrowserSearch {
    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }


    @DataProvider(name = "credentials")
    public Object[][] credentials() {
        return new Object[][]{
                {"testng"},
                {"dataProviders"},
                {"selenium"},
        };
    }

    @Test(dataProvider = "credentials")
    public void test001(String textValue) {

        openMainPage();
        typeQuery(textValue);
        submitSearch();
        waitForResults();
        assertResultPage();
    }

    private void waitForResults() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='rhscol' and @class='col']")));
    }

    private void assertResultPage() {
        WebElement resultsStatsElement = driver.findElement(By.xpath("//div[@id='rhscol']"));
        boolean resultIsDisplayed = resultsStatsElement.isDisplayed();

        boolean expectedResult = true;
        Assert.assertEquals(resultIsDisplayed, expectedResult);
    }

    private void submitSearch() {
        WebElement searchInput = driver.findElement(By.xpath("//input[@name='q']"));
        searchInput.submit();
    }

    private void typeQuery(String textValue) {
        WebElement searchInput = driver.findElement(By.xpath("//input[@name='q']"));
        searchInput.sendKeys(textValue);
    }

    private void openMainPage() {
        String url = "https://www.google.com/";
        driver.get(url);
    }
}
