package test_olx;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Search {
	
	WebDriver driver = null;
	ExtentTest test;
	WebDriverWait wait;
	private String carModel;
	private String carBrand;
	private String city;
	
	public Search(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		this.wait = new WebDriverWait(driver,5);
	}
	
	public void acceptCookies() {
		driver.findElement(By.xpath("//div[@id=\"cookiesBar\"]//button")).click();
	}
	
	public void takeScreenShot() throws Exception {
		String path = Screenshots.takeScreenshot(driver);
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.FAIL, "", imagePath);
	
	}
	
	public void info() {
		test.log(LogStatus.INFO, "City: " + city);
		test.log(LogStatus.INFO, "Car Brand: " + carBrand);
		test.log(LogStatus.INFO, "Car Model: " + carModel);
	}
	public void goToCarsSearch() throws Exception {
		  driver.findElement(By.xpath("//div[@class='maincategories']//span[text()=\"Motoryzacja\"]")).click();
		  Thread.sleep(500);
		  driver.findElement(By.xpath("//span[@class='link category-name']//span[text()=\"Samochody osobowe\"]")).click();
		  Thread.sleep(500);
	}
	
	public void cityFill(String city) throws Exception {
		this.city = city;
		try {	
		WebElement cityField = wait.until(ExpectedConditions.elementToBeClickable(By.id("cityField")));
		cityField.sendKeys(city);
		WebElement cityFieldValue = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//a[contains(@class,'search-choose-selected')]//strong[text()='"+ city +"']")));
		 Thread.sleep(1000);
		cityFieldValue.click();
	  	 test.log(LogStatus.PASS, "City find correct");
		} catch(Exception e) {
			takeScreenShot();
			test.log(LogStatus.FAIL, "Miasto: " + e.getMessage());
		}
	}
	
	
	public void carBrand(String carBrand) throws Exception {
		  this.carBrand = carBrand;
		  try {
		  carBrand = carBrand.toLowerCase();
		  WebElement carBrandElement = wait.until
				  	(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Marka']")));
		  Thread.sleep(1000);
		  carBrandElement.click();	  
		  WebElement carBrandValue =  wait.until
				  	(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-code='"+ carBrand +"']")));
		   Thread.sleep(1000);
			  carBrandValue.click();
			  test.log(LogStatus.PASS, "Car Brand find correct");
		  }catch(Exception e) {
			  takeScreenShot();
			  test.log(LogStatus.FAIL, "Marka: " + e.getMessage());
		  }	
	}
	
	public void carModel(String carModel) throws Exception {
		  this.carModel = carModel;
		  try {
		  WebElement carModelElement = wait.until
				  	(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Model']")));
		  Thread.sleep(1000);
		  carModelElement.click();
			  WebElement carModelValue =  wait.until
				  	(ExpectedConditions.elementToBeClickable
				  	(By.xpath("//li//label[@data-text='"+ carModel +"']")));
			  Thread.sleep(1000);
			  carModelValue.click();
			  test.log(LogStatus.PASS, "Car Model find correct");
		  }catch(Exception e) {
			  takeScreenShot();
			  test.log(LogStatus.FAIL, "Model: " + e.getMessage());
		  }	
		
	}

}
