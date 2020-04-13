package test_olx;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class TestDemo {
	
   WebDriver driver;
   String baseURL;
   Search search;
   ExtentReports report;
   ExtentTest test;


  @BeforeClass
  public void beforeClass() {
	  	report = ExtentFactory.getInstance();
	    baseURL = "https://olx.pl";	
	    driver = new ChromeDriver();	 
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
  }
  
  @Test
  @Parameters({"testName", "city","carBrand","carModel" })
  public void test1(String testName, String city, String carBrand, String carModel) throws Exception { 
	  LocalDateTime now = LocalDateTime.now();  
	  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy -  HH:mm:ss"); 
	  test = report.startTest("Verify cars search " + testName + " " + dtf.format(now));
	  search = new Search(driver, test);
	  search.acceptCookies();
	  search.goToCarsSearch();
	  search.cityFill(city);
	  search.carBrand(carBrand);
	  search.carModel(carModel);
	  search.info();
	  report.endTest(test);
	  report.flush();
	 
  }

  @AfterClass
  public void afterClass() {
	 driver.quit();

	  
  }

}
