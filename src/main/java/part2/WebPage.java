package part2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Super classObject to hold page elements
 * @author Suprabha
 *
 */

public class WebPage {

	protected  WebDriver driver ;

	public WebPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public  WebDriver getDriver() { 
		return driver;
	}
}
