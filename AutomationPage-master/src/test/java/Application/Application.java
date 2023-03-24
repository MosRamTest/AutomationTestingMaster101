package Application;

import Pages.PracticePage;
import org.openqa.selenium.WebDriver;

public class Application {
    public PracticePage practicePage;
    public Application(WebDriver driver)
    {
        practicePage = new PracticePage(driver);
    }
}
