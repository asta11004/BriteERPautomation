package com.BriteERP.pages;


import com.BriteERP.utilities.Brite_Utils;
import com.BriteERP.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

    public class CRM_Page {

        private WebDriver driver = Driver.getDriver();
        private Actions action = new Actions(driver);

        public CRM_Page() {
            PageFactory.initElements(driver, this);
        }


        @FindBy(xpath = "//button[contains(text(),'Action')]")
        WebElement actionMenu;

        @FindBy(xpath = "//a[contains(text(),'Delete')]")
        WebElement deleteButton;

        @FindBy(xpath = "//span[contains(text(),'Ok')]//parent::button")
        WebElement okConfirmationButton;

        // grid elements
        @FindBy(xpath = "//div[contains(@class,'btn-group btn-group-sm')]/button[1]")
        WebElement kanbanView;

        @FindBy(xpath = "//div[contains(@class,'btn-group btn-group-sm')]/button[5]//preceding-sibling::button[3]")
        WebElement listView;

        @FindBy(xpath = "//div[contains(@class,'btn-group btn-group-sm')]/button[3]")
        WebElement graphView;

        @FindBy(xpath = "//div[contains(@class,'btn-group btn-group-sm')]/button[4]")
        WebElement pivotView;

        @FindBy(xpath = "//div[contains(@class,'btn-group btn-group-sm')]/button[5]")
        WebElement calendarView;

        @FindBy(xpath = "(//tr)[3]/td[1]")
        WebElement totalBox;

        // first row showing the total value
        @FindBy(xpath = "(//tbody//td[2])[1]")
        WebElement totalValueInPivotView;

        // expected revenue list - first item in the list represent the total value
        @FindBy(xpath = "(//tbody//td[2])")
        List<WebElement> expectedRevenueList;

        // list of all options after clicking
        @FindBy(xpath = "//div[@class='o_field_selection']/ul/li")
        List<WebElement> totalBoxMenuOptions;

        @FindBy(xpath = "//div[@class='table-responsive']//tbody//tr")
        List<WebElement> table_Rows_ListView;


        // print total value - it will print the value in the first row
        // use the sumOfExpectedValues() method
        public String getSeenExpectedTotalRevenue() {
            return totalValueInPivotView.getText();
        }

        // select one of the options from total box menu
        public void clickOneOfTotalBoxMenuOptions(String nameOfOption) {
            for (WebElement e : totalBoxMenuOptions) {
                if (e.getText().equals(nameOfOption)) {
                    e.click();
                    break;
                }
            }
        }

        // finding sum of the opportunities
        public long sum_Of_Expected_Values() {
            long sum = 0;
            for (int i = 1; i < expectedRevenueList.size(); i++) {
                sum += Long.parseLong(expectedRevenueList.get(i).getText().replace(",", "").replace(".",""));
            }
            return sum;
        }

        // get any row's expected value in pivot view (only works on pivot view)
        public long get_A_Rows_Expected_Value_From_PivotView(int rowNumber){
            WebElement element = driver.findElement(By.xpath("(//tbody//td[2])[" + (rowNumber + 1) + "]"));
            return Long.parseLong(element.getText().replace(",", "").replace(".",""));
        }




        // find an opportunity name from lis view and print the value for it
        public long get_A_Rows_Expected_Value_From_ListView(String opportunityName){
            long value = 0;

            System.out.println("Size: " + table_Rows_ListView.size());

            for (int i = 1; i <= table_Rows_ListView.size(); i++) {
                WebElement element = driver.findElement(By.xpath("//tbody//tr[" + i + "]//parent::tr//td[3]"));
                System.out.println("Text: " + element.getText());

                if(element.getText().equalsIgnoreCase(opportunityName)){
                    System.out.println("Opportunity name: " + element.getText());
                    value = Long.parseLong(driver.findElement(By.xpath("//tbody//tr[" + i + "]//parent::tr//td[9]")).getText().
                            replace(",", "").replace(".",""));
                    break;
                }
            }
            return value;
        }


        public void clickTotalBox () {
            Brite_Utils.waitUntilElementClickable(totalBox);
            totalBox.click();
        }

        public void clickListView () {
            Brite_Utils.waitUntilElementClickable(totalBox);
            listView.click();
        }

        public void clickCalendarView () {
            Brite_Utils.waitUntilElementClickable(calendarView);
            calendarView.click();
        }

        public void clickPivotView () {
            Brite_Utils.waitUntilElementClickable(pivotView);
            pivotView.click();
        }

        public void clickGraphView () {
            Brite_Utils.waitUntilElementClickable(graphView);
            graphView.click();
        }

        public void clickKanbanView () {
            Brite_Utils.waitUntilElementClickable(kanbanView);
            kanbanView.click();
        }


        public void clickActionMenu () {
            Brite_Utils.waitUntilElementClickable(actionMenu);
            actionMenu.click();
        }

        public void clickDeleteButton () {
            Brite_Utils.waitUntilElementClickable(deleteButton);
            deleteButton.click();
        }
        public void clickOkConfirmationButton () {
            Brite_Utils.waitUntilElementClickable(okConfirmationButton);
            okConfirmationButton.click();
        }


    }

