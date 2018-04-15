package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by puneeth on 11/04/2018.
 */
public class VehicleRegPage extends BasePageObject {

    @FindBy(css = ".pub-c-button--start")
    private WebElement startNowButton;

    @FindBy(css = ".input-upper")
    private WebElement vehRegTextBox;

    @FindBy(css = ".button")
    private WebElement continueButton;

    @FindBy(css=".list-summary-item >span:nth-child(2)")
    private List<WebElement> vehicleDetailsList;

    @FindBy(id = "Correct_False")
    private WebElement noSearchAgain;

    @FindBy(css = ".pub-c-title__text")
    private WebElement pageTitleLocator;

    /* Below method returns Page tile
    * */

    public String getPageTitle(){
        pageTitleLocator.isDisplayed();
        return pageTitleLocator.getText();
    }


    /* Below method clicks on Start Button
    * */
    public void clickOnStart(){
        startNowButton.click();
    }

    public void enterVehicleReg(String vehicleReg){
        vehRegTextBox.isDisplayed();
        vehRegTextBox.sendKeys(vehicleReg);
    }

    /* Below method clicks on Continue Button
    * */
    public void clickOnContinueButton(){
        continueButton.click();
    }

    /* Below method returns Vehicle Details Lis
    * */
    public List<String> getVehicleDetails(){
        List<String> vDetails = new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOfAllElements(vehicleDetailsList));
        for(WebElement element:vehicleDetailsList){
            vDetails.add(element.getText());
        }
        return vDetails;
    }

    /* Below method clicks on NO radio Button
    * */
    public void selectNoSelectAgainOption(){
        noSearchAgain.click();
    }
}
