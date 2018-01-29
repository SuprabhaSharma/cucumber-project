package part2.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import part2.WebPage;


/**
 * Homepage for dvla website
 * @author Suprabha
 *
 */
public class GetVehicleInfoPO extends WebPage{

	public GetVehicleInfoPO(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="get-started")
	private WebElement getStartedButton;
	
	/**
	 * Link to go to vehile registration input page.
	 * @return
	 */

	public VehicleRegistrationPO clickGetStarted() {
		getStartedButton.findElement(By.tagName("a")).click();
		return new VehicleRegistrationPO(driver);
	}
}
