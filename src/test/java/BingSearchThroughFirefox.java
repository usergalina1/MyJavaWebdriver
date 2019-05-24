import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class BingSearchThroughFirefox {
    WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod(){
        driver.manage().deleteAllCookies();
    }
    @AfterSuite
    public void afterSuite(){
        driver.close();
    }
    @Test
    public void test001() {
        String textValue = "portnov computer school";

        openBingPage();
        typeQuerySearchField(textValue);
        clickSearchBoxSubmit();
        verifyResultsOnPage(textValue);
    }

    @Test
    public void test002() {
        String textValue = "testNG";

        openBingPage();
        typeQuerySearchField(textValue);
        clickSearchBoxSubmit();
        verifyResultsOnPage(textValue);
    }

    private void verifyResultsOnPage(String textValue) {
        WebElement resultOnPage = driver.findElement(By.id("b_content"));
        Boolean resultText = resultOnPage.getText().contains(textValue);
        Boolean expectedTest = true;
        Assert.assertEquals(resultText, expectedTest);
    }

    private void clickSearchBoxSubmit() {
        driver.findElement(By.id("sb_form_go")).click();
    }

    private void typeQuerySearchField(String textQuery) {
        driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys(textQuery);
    }

    private void openBingPage() {
        driver.get("https://www.bing.com/");
    }
}
