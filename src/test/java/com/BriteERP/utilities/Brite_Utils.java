package com.BriteERP.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Brite_Utils {

    private static WebDriver driver = Driver.getDriver();
    static Actions action = new Actions(driver);

    public Brite_Utils(){
        PageFactory.initElements(driver, this);

    }


    // Web elements for modules on homepage
    @FindBy(xpath = "//span[@class='oe_menu_text' and contains(text(),'CRM')]")
    public static WebElement crm_Module;

    @FindBy(xpath = "//a[@class='oe_menu_toggler']//span[@class='oe_menu_text'][contains(text(),'Contacts')]")
    public static WebElement contacts_Module;

    @FindBy(xpath = "//a[@class='oe_menu_toggler']//span[@class='oe_menu_text'][contains(text(),'Sales')]")
    public static WebElement sales_Module;




    // methods
    public static void sleep(int seconds) throws InterruptedException {
        Thread.sleep(1000 * seconds);
    }

    // navigate to module
    public static void navigateToModules(WebElement element) throws InterruptedException {
        waitUntilElementClickable(element);
        element.click();

    }

    // this is to wait for certain condition
    public static void waitUntilElementClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception e){
            System.out.println(e + " : Element is not clickable.");
        }
    }



}
