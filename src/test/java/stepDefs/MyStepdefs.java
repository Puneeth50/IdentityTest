package stepDefs;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import fileUtility.CSVUtil;
import org.junit.After;
import org.junit.Assert;
import pageObjects.VehicleRegPage;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by puneeth on 11/04/2018.
 */

public class MyStepdefs {

    VehicleRegPage vehicleRegPage = new VehicleRegPage();
    CSVUtil csvUtil;
    List<String[]> csvData;
    public String vehicleReg;
    public String vehicleMake;
    public String vehicleColour;

    @Then("^I see vehicle details are displayed as expected$")
    public void the_search_with_vehicle_reg() throws Throwable {
        vehicleRegPage.clickOnStart();
        for (String[] vehicle : csvData) {
            vehicleReg = vehicle[0];
            vehicleMake = vehicle[1];
            vehicleColour = vehicle[2];
            vehicleRegPage.enterVehicleReg(vehicleReg);
            vehicleRegPage.clickOnContinueButton();
            Assert.assertThat(Arrays.asList(vehicle),is(vehicleRegPage.getVehicleDetails()));
            vehicleRegPage.selectNoSelectAgainOption();
            vehicleRegPage.clickOnContinueButton();
        }
    }

    @Given("^I am on DVLA get vehicle information web page$")
    public void I_am_on_DVLA_get_vehicle_information_web_page() throws Throwable {

        Assert.assertEquals("Get vehicle information from DVLA" , vehicleRegPage.getPageTitle());
    }

    @Given("^I load vehicle registration details from the file$")
    public void I_load_vehicle_registration_details_from_the_file() throws Throwable {
        csvUtil = new CSVUtil("C:\\Users\\kedika\\Downloads\\IdentityE2ETest\\src\\main\\resources\\files\\data.csv");
        csvData = csvUtil.getCsvValues();
        System.out.println(csvData);
    }


    @After    //performed after all is done
    public void cleanUp() {
        vehicleRegPage.quitDriver();
    }

}
