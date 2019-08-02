package com.BriteERP.utilities;

    import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;
public class TestBase {

        //should be public/protected !!!!
        public WebDriver driver;
        public Actions action;


        @BeforeClass
        public void setup(){
            driver = Driver.getDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get(ConfigurationReader.getProperty("urlbrite"));
            driver.manage().window().maximize();
            action = new Actions(driver);

        }

        @AfterClass
        public void teardown() throws InterruptedException {
            Brite_Utils.sleep(2);
            Driver.closeDriver();
        }


    }


