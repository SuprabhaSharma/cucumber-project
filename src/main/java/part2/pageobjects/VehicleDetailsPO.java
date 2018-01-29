package part2.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import part2.WebPage;

/**
 * PageObject to hold vehicle details received from dvla site for particular registration number
 * @author Suprabha
 *
 */

public class VehicleDetailsPO extends WebPage {
	
	public VehicleDetailsPO(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/div[4]/ul/li[1]/span[2]")
	WebElement make;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[4]/ul/li[9]/span[2]")
	WebElement colour;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[4]/p[2]/a")
	WebElement searchAnother;
	
	
    /**
     * Returns a list which hold make and colour for particular vehicle. At the endControl goes back to input page.
     * @return
     */
	public  List<String> extractTableValues() {
		System.out.println(make.getText()+colour.getText());
		List<String> vehicleDetailsList = new ArrayList<String>();
		vehicleDetailsList.add(make.getText());
		vehicleDetailsList.add(colour.getText());
		searchAnother.click();
		return vehicleDetailsList;
	}

}
