package com.BriteERP.pages;

import com.BriteERP.utilities.Brite_Utils;
import com.BriteERP.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

    private WebDriver driver = Driver.getDriver();

    // elements on the Login Page
    @FindBy(xpath = "//input[@id='login']")
    private static
    WebElement emailBox;

    @FindBy(id = "password")
    private static
    WebElement passwordBox;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private static
    WebElement loginBUtton;

    public Login_Page(){
        PageFactory.initElements(driver, this);
    }

    // enter user name
    private static void enterEmail(String userName){
        emailBox.sendKeys(userName);
    }

    // enter Password
    private static void enterPassword(String password){
        passwordBox.sendKeys(password);
    }

    // click login button
    private static void clickLoginButton(){
        loginBUtton.click();
    }

    // login method
    public static void loginBrite(String userName, String password) throws InterruptedException {
        enterEmail(userName);
        Brite_Utils.sleep(1);
        enterPassword(password);
        Brite_Utils.sleep(1);
        clickLoginButton();
        Brite_Utils.sleep(3);
        System.out.println("Logged in to Brite Application.");
    }
}
