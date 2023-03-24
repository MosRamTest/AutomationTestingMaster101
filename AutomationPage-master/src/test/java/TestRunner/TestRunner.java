package TestRunner;

import Application.Application;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestRunner {
    public WebDriver driver;
    public Application app;
    @BeforeTest
    public void setChrome()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        app = new Application(driver);
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test(priority = 1)
    public void clickRadioButtons()
    {
        app.practicePage.validateradiobuttons();
        app.practicePage.suggestion();

    }

    @Test(priority = 2)
    public void Boxes()
    {
        app.practicePage.CheckBoxes();
    }

    @Test(priority = 3)
    public void showOrHideTextBox()
    {
        app.practicePage.showOrHide();
    }

    @Test(priority = 4)
    public void tabletablefixedHeader()
    {
        app.practicePage.tableTableFixedHeader();
    }

    @Test(priority = 5)
    public void checkIfframeIsavailabe()
    {
        app.practicePage.validateIframe();
    }

    @AfterTest
    public void closeChrome()
    {
        driver.close();
        driver.quit();
    }
}
