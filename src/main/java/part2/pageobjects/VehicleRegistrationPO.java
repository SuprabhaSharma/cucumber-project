package part2.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import part2.WebPage;


/**
 * PageObject to input vehicle registration from user
 * @author Suprabha
 *
 */
public class VehicleRegistrationPO extends WebPage{
	
	public VehicleRegistrationPO(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[contains(@class,'form-control form-control-1-4 input-upper')]")
	private WebElement registrationNumber;
	
	@FindBy(name="Continue")
	private WebElement continueButton;
	
		
	/**
	 * 
	 * @param inputregistrationNumber
	 * @return RegistrationConfirmationPO
	 */
	public RegistrationConfirmationPO submitVehileRegistration(String inputregistrationNumber) {
		registrationNumber.sendKeys(inputregistrationNumber);
		continueButton.submit();
		return new RegistrationConfirmationPO(driver);
	}
	

	}


