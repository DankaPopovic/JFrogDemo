package rahulshettyacademy;


import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.PageObjects.TravelHomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends BaseTest{
WebDriver driver;
    TravelHomePage travelHomePage;

    @BeforeTest
    public void setup()
    {
        driver =initializeDriver();
        travelHomePage = new TravelHomePage(driver);
    }



    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String,String> reservationDetails)
    {

        travelHomePage.goTo();
        System.out.println(travelHomePage.getFooterNav().getFlightAttribute());
        System.out.println(travelHomePage.getNavigationBar().getFlightAttribute());
        System.out.println(travelHomePage.getFooterNav().getLinkCount());
        System.out.println(travelHomePage.getNavigationBar().getLinkCount());
        System.out.println("I love, toooooo");
        travelHomePage.setBookingStrategy("multitrip");

        travelHomePage.checkAvail(reservationDetails);
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

    @DataProvider
    //hashmaps,dataprovider, json, jackson,list
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> l=getJsonData(System.getProperty("user.dir")+"//src//test//java//org//rahulshettyacademy//DataLoads//reservationDetails.json");

        return new Object[][]
                {
                        { l.get(0)},  { l.get(1)}
                };
    }






}
