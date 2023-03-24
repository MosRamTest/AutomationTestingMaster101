package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PracticePage {

    private WebDriver _driver;
    public PracticePage(WebDriver driver)
    {
        this._driver = driver;
        PageFactory.initElements(_driver,this);
    }

    @FindBy(xpath = "(//input[@name='radioButton'])[1]")
    WebElement radioButton1;
    @FindBy(xpath = "(//input[@name='radioButton'])[2]")
    WebElement radioButton2;
    @FindBy(xpath = "(//input[@name='radioButton'])[3]")
    WebElement radioButton3;

    @FindBy(id = "autocomplete")
    WebElement country;

    @FindBy(id = "checkBoxOption1")
    WebElement opttion1;
    @FindBy(id = "checkBoxOption2")
    WebElement opttion2;
    @FindBy(id = "checkBoxOption3")
    WebElement opttion3;

    @FindBy(id = "hide-textbox")
    WebElement hide;
    @FindBy(id = "show-textbox")
    WebElement show;
    @FindBy(id = "displayed-text")
    WebElement displayTextbox;

    @FindBy(xpath = "/html/body/div[3]/div[2]/fieldset[2]/div[1]/table/tbody/tr[6]/td[1]")
    WebElement name;

    @FindBy(xpath = "/html/body/div[3]/div[2]/fieldset[2]/div[1]/table/tbody/tr[6]/td[4]")
    WebElement amount;

    @FindBy(xpath = "//iframe[@id='courses-iframe']")
    WebElement frame1;

    @FindBy(partialLinkText = "REGISTER")
    WebElement register;

    @FindBy(xpath = "//div[@class='totalAmount']")
    WebElement totalAmount;

    public void validateradiobuttons(){
        radioButton3.click();

        if(radioButton3.isSelected() && (!radioButton2.isSelected() || !radioButton1.isSelected())){
            System.out.println("Passed Only one radioButton is clicked: ");

        }
        else {
            System.out.println("Failed More than one radio button cannot be selected:");
        }

        radioButton2.click();
        if(radioButton2.isSelected() && (!radioButton3.isSelected() || !radioButton1.isSelected())){
            System.out.println("Only radioButton 2 is Selected: ");

        }
        else {
            System.out.println("Not only radioButton 2 is selected:");
        }
    }
    public void suggestion(){
        country.click();
        country.sendKeys("South");
        country.sendKeys(Keys.ARROW_DOWN);
        country.sendKeys(Keys.ARROW_DOWN);
        country.sendKeys(Keys.ENTER);
        System.out.println("Successfully selected South Africa");

        country.clear();
        country.sendKeys("Republic");
        country.sendKeys(Keys.ARROW_DOWN);
        country.sendKeys(Keys.ENTER);
        System.out.println("Successfully selected the first on the list: ");
    }

    public void CheckBoxes(){

        List<WebElement> checkboxes = _driver.findElements(By.cssSelector("input[type='checkbox']"));
        for(WebElement checkbox : checkboxes){
            if (!checkbox.isSelected()) {
                checkbox.click();
            }else {
                System.out.println("No Checkbox Selected ");
            }
        }

        opttion1.click();
        if(!opttion1.isSelected() && (opttion2.isSelected() && opttion3.isSelected())){
            System.out.println("Other two check-boxes are still checked: ");
        }

        else{
            System.out.println("All check-boxes are un-checkd: ");
        }
    }

    public void showOrHide(){
        hide.click();

        if(!displayTextbox.isDisplayed()){
            System.out.println("Passed " + " Element is hidden");
        }else{
            System.out.println("Passed " + " Element is not hidden");
        }
        show.click();
        if(displayTextbox.isDisplayed()){
            System.out.println("Passed " + " Element is shown");
        }else{
            System.out.println("Passed " + " Element is hidden");
        }

        String actual = amount.getText();
        String expected = "46";

        if(actual.equals(expected)){
            System.out.println("Passed: Amount for Joes is 46");
        }
        else{
            System.out.println("Passed: Amount for Joes is not 46");
        }
    }

    public void tableTableFixedHeader(){

       String actualTotalAmount = totalAmount.getText();


        if(actualTotalAmount.contains("296")){
            System.out.println("Passed: Total amount is 296");
        }
        else{
            System.out.println("Passed: Total amount is not 296");
        }
    }

    //Checking Frame
    public void validateIframe(){

        if(frame1.isDisplayed()){
            System.out.println("Passed: frame is available: ");
        }else{
            System.out.println("Failed: frame is not available: ");
        }

        _driver.switchTo().frame(frame1);

        String findText = register.getText();
        System.out.println("WebElement found in the frame is: "+findText);
    }
}
