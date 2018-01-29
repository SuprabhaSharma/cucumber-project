package part2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import part1.FileUtil;


/**
 * Framework singleton class to define webdriver
 * @author Suprabha
 *
 */
public class DefineDriver {

	private static WebDriver driver;

	/**
	 * Single instance of webdriver to be used across the application
	 * @return
	 */
	public static WebDriver getDriverInstance(){
		if(driver == null) {
			System.setProperty(FileUtil.loadProperty("webdriver"),FileUtil.loadProperty("driverlocation"));
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;
	}
}
