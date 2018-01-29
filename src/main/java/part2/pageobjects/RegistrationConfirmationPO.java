package part2.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import part2.WebPage;

/**
 * Pageobject to hold vehicle registration confirmation page elements
 * @author Suprabha
 *
 */
public class RegistrationConfirmationPO  extends WebPage{
	
	public RegistrationConfirmationPO(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="Vrm")
	private WebElement vehileRegistration;

	@FindBy(id="Make")
	private WebElement make;
	
	@FindBy(id="Colour")
	private WebElement colour;
	
	@FindBy(id="Correct_True")
	private WebElement radioButtonTrue;
	
	
	public String getVehicleRegistrationValue() {
		return vehileRegistration.getAttribute("value");
		}
	
	public String getColourValue() {
		return colour.getAttribute("value");
		}
	
	public String getMakeValue() {
		return make.getAttribute("value");
		}
	
	/**
	 * Submit True to go to vehicle details entry page.
	 */
	
	public VehicleDetailsPO submitTrue() {
		radioButtonTrue.click();
		radioButtonTrue.submit();
		return new VehicleDetailsPO(driver);
	}

}
