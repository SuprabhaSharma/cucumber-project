package part2.step_definitions;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import part1.FileUtil;
import part1.GetFileDetails;
import part1.GetFileDetailsImpl;
import part2.DefineDriver;
import part2.pageobjects.GetVehicleInfoPO;
import part2.pageobjects.RegistrationConfirmationPO;
import part2.pageobjects.VehicleDetailsPO;
import part2.pageobjects.VehicleRegistrationPO;

/**
 * Step definition cucumber class as defined by get_file feature
 * @author Suprabha
 *
 */
public class GetFileStepDefinition {

	FileInputStream inputStream = null;
	Sheet sheet = null;
	HashMap<String, List<String>> testData;
	List<String> vehicleProperties ;
	RegistrationConfirmationPO registrationConfirmationPO;
	VehicleRegistrationPO vehicleRegistrationPO;
	VehicleDetailsPO vehicleDetailsPO;
	WebDriver driver = DefineDriver.getDriverInstance();

	@Given(value = "^Open the browser with the provided link$")
	public void call_website() throws Throwable {
		driver.get(FileUtil.loadProperty("url"));
		GetVehicleInfoPO vehicleInfo = new GetVehicleInfoPO(driver);
		vehicleRegistrationPO = vehicleInfo.clickGetStarted();
	}

	@When(value = "^Vehicle registration data is read from spreadsheet and stored in a List$")
	public void submit_data() {
		readDataFromcsv();
	}

	@Then(value = "^Vehicle information from DVLA is asserted against each item in the List$")
	public void assert_values() {
		testData.forEach((key, value) -> {
			registrationConfirmationPO = vehicleRegistrationPO.submitVehileRegistration(key);
			vehicleDetailsPO = registrationConfirmationPO.submitTrue();
			assertTrue(vehicleDetailsPO.extractTableValues().containsAll(value));
		});

	}

	/**
	 * Calls the service layer to get the testdata from the directory as mentioned 
	 * in properties file and read the test data from csv.
	 */

	private void readDataFromcsv() {
		GetFileDetails service = new GetFileDetailsImpl();
		String testFile = service.getFileForMimeType().get(0).getName();
		String name = FileUtil.loadProperty("location");
		Workbook workBook = null;
		File file = new File(name.concat(testFile));
		try {
			inputStream = new FileInputStream(file);
			workBook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = workBook.getSheet("Sheet1");
		storeValuesInMap();
	}

	/**
	 * Store the spreadsheet value in a map with key as registration number and value as a list containing 
	 * all the attributes make, colour for that registration number 
	 */
	private void storeValuesInMap() {
		testData = new HashMap<String, List<String>>();
		for (int rowCounter = 1; rowCounter <= (sheet.getLastRowNum() - sheet.getFirstRowNum()); rowCounter++) {
			int coloumnCounter = 2;
			vehicleProperties = new ArrayList<String>();
			Row row = sheet.getRow(rowCounter);
			vehicleProperties.add(getCellValue(row, coloumnCounter));
			vehicleProperties.add(getCellValue(row, --coloumnCounter));
			testData.put(getCellValue(row, --coloumnCounter),vehicleProperties);
		}
	}

	/**
	 * Return entered value for a set of row and coulmn
	 * @param row
	 * @param coloumnCounter
	 * @return String
	 */
	private String getCellValue(Row row, int coloumnCounter) {
		return row.getCell(coloumnCounter).getStringCellValue();
	}

}
