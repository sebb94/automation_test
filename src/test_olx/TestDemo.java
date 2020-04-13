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

public class TestDemo {
	
   WebDriver driver;
   String baseURL;
   Search search;
   ExtentReports report;
   ExtentTest test;


  @BeforeClass
  public void beforeClass() {
	  	report = ExtentFactory.getInstance();
	  	LocalDateTime now = LocalDateTime.now();  
	  	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy -  HH:mm:ss"); 
	    baseURL = "https://olx.pl";	
	    driver = new ChromeDriver();	 
	    test = report.startTest("Verify cars search " + dtf.format(now));
	    search = new Search(driver, test);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
  }
  
  @Test
  public void test1() throws Exception { 
	  search.acceptCookies();
	  search.goToCarsSearch();
	  search.cityFill("Kraków");
	  search.carBrand("BMW");
	  search.carModel("Seria 33");
	  search.info();
	 
  }

  @AfterClass
  public void afterClass() {
	 driver.quit();
	 report.endTest(test);
	 report.flush();
	  
  }

}
