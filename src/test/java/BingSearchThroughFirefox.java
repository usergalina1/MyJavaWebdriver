import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


//    TODO: automate search scenario on Bing.com
public class BingSearchThroughFirefox {

    WebDriver driver;

    @Test
    public void test002() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();

        openBingPage();
        typeQuerySearchField();
        clickSearchBoxSubmit();
        verifyResultsOnPage();
    }

    private void verifyResultsOnPage() {
        WebElement resultOnPage = driver.findElement(By.id("b_content"));
        Boolean resultText = resultOnPage.getText().contains("TestNG");
        Boolean expectedTest = true;
        Assert.assertEquals(resultText, expectedTest);

        driver.close();

    }

    private void clickSearchBoxSubmit() {
        driver.findElement(By.id("sb_form_go")).click();
    }

    private void typeQuerySearchField() {
        driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys("testNG");
    }

    private void openBingPage() {
        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();
    }
}
