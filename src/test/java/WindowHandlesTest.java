import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandlesTest {
    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }

    @Test
    public void test001() throws InterruptedException {

        openThePage();
        clickLinkText();
        assertNumberWindows();
        switchToTheSecondWindow();
        assertTheSecondPage();
        switchToMainPage();
        assertMainPage();
    }

    private void assertMainPage() {
        boolean windowTitle = driver.getTitle().contains("Internet");

        boolean isTitleContainsText = windowTitle;
        Assert.assertTrue(isTitleContainsText);
    }

    private void switchToMainPage() {
        Set<String> allWindowHandles = driver.getWindowHandles();
        String windowHandle1 = (String) allWindowHandles.toArray()[0];
        String windowHandle2 = (String) allWindowHandles.toArray()[1];
        driver.switchTo().window(windowHandle1);
    }

    private void assertTheSecondPage() {
        WebElement textToCheck = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]"));
        boolean isTextThere = textToCheck.getText().contains("New Window");
        boolean expectedResult = true;
        Assert.assertEquals(isTextThere, expectedResult);
    }

    private void switchToTheSecondWindow() {
        Set<String> allWindowHandles = driver.getWindowHandles();
        String windowHandle1 = (String) allWindowHandles.toArray()[0];
        String windowHandle2 = (String) allWindowHandles.toArray()[1];
        driver.switchTo().window(windowHandle2);
    }

    private void assertNumberWindows() {
        Set<String> allWindowHandles = driver.getWindowHandles();
        boolean isTwoWindowsOpened = allWindowHandles.size() == 2;
        Assert.assertTrue(isTwoWindowsOpened);
    }

    private void clickLinkText() throws InterruptedException {
        By linkByText = By.linkText("Click Here");
        WebElement linkElement = driver.findElement(linkByText);
        linkElement.click();
        Thread.sleep(1000);
    }

    private void openThePage() {
        driver.get("https://the-internet.herokuapp.com/windows");
    }
}
