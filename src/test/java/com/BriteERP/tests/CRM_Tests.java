package com.BriteERP.tests;
import com.BriteERP.pages.CRM_Page;
import com.BriteERP.pages.Login_Page;
import com.BriteERP.utilities.Brite_Utils;
import com.BriteERP.utilities.ConfigurationReader;
import com.BriteERP.utilities.TestBase;
import org.testng.Assert;
import org.testng.TestException;
import org.testng.annotations.Test;

public class CRM_Tests extends TestBase {

        public CRM_Page crmPage = new CRM_Page();
        public Brite_Utils butil = new Brite_Utils();
        public Login_Page blogin = new Login_Page();

    @Test(priority = 1, description = "AC2 - the total expected revenue should be the sum of all opportunities’ expected revenue")
    public void testCase1() throws InterruptedException {

            // login to brite app
            Brite_Utils.sleep(3);
            Login_Page.loginBrite(ConfigurationReader.getProperty("usernameBrite"), ConfigurationReader.getProperty("passwordBrite"));

            // this method include wait until clickable method
            Brite_Utils.navigateToModules(Brite_Utils.crm_Module);

            // click pivot view - this method include wait until clickable method
            crmPage.clickPivotView();

            // click totalbox
            crmPage.clickTotalBox();
            Brite_Utils.sleep(2);
            crmPage.clickTotalBox();

            // click opportunity option
            crmPage.clickOneOfTotalBoxMenuOptions("Opportunity");
            Brite_Utils.sleep(2);

            // print the total value
            System.out.println("Total value seen in 1st row: " + crmPage.getSeenExpectedTotalRevenue());
            // we need to get rid of the comma abd dot
            long expectedTotalValue = Long.parseLong(crmPage.getSeenExpectedTotalRevenue().replace(",", "").replace(".",""));
            Brite_Utils.sleep(2);

            // now try to find all items values
            System.out.println("Total Values of all items: " + crmPage.sum_Of_Expected_Values());
            long actualTotalValue = crmPage.sum_Of_Expected_Values();

            Assert.assertEquals(actualTotalValue, expectedTotalValue);



        }



    @Test(priority = 2, description = "AC1 - Verify that second opportunity value on the Pivot board same as on the list board.")
    public void testCase2() throws InterruptedException {

        // login to brite app
        Brite_Utils.sleep(3);
        Login_Page.loginBrite(ConfigurationReader.getProperty("usernameBrite"), ConfigurationReader.getProperty("passwordBrite"));

        // this method include wait until clickable method
        Brite_Utils.navigateToModules(Brite_Utils.crm_Module);

        // click pivot view - this method include wait until clickable method
        crmPage.clickPivotView();

        // click totalbox
        crmPage.clickTotalBox();
        Brite_Utils.sleep(2);
        crmPage.clickTotalBox();

        // click opportunity option
        crmPage.clickOneOfTotalBoxMenuOptions("Opportunity");
        Brite_Utils.sleep(2);

        // now get the second item's expected revenue from pivot view
        long value_In_Pivot_View = crmPage.get_A_Rows_Expected_Value_From_PivotView(2);
        System.out.println("Value in pivot view: " + value_In_Pivot_View);

        // go to list view
        crmPage.clickListView();

        // get the same row's value from list view
        long value_In_List_View = crmPage.get_A_Rows_Expected_Value_From_ListView("Book");
        System.out.println("Value in list view: " + value_In_List_View);

        // check the values if they are same
        Assert.assertEquals(value_In_List_View, value_In_Pivot_View);

    }



}
