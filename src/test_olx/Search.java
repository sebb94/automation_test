package test_olx;

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
	
	public Search(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		this.wait = new WebDriverWait(driver, 5);
	}
	
	public void goToCarsSearch() throws Exception {
		  driver.findElement(By.xpath("//div[@class='maincategories']//span[text()=\"Motoryzacja\"]")).click();
		  Thread.sleep(500);
		  driver.findElement(By.xpath("//span[@class='link category-name']//span[text()=\"Samochody osobowe\"]")).click();
		  Thread.sleep(500);
	}
	
	
	public void carBrand(String carBrand) {
		  carBrand = carBrand.toLowerCase();
		  WebElement carBrandElement = driver.findElement(By.xpath("//span[text()='Marka']"));
		  carBrandElement.click();
		  try {
			  WebElement carBrandValue =  wait.until
				  	(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-code='"+ carBrand +"']")));
			  carBrandValue.click();
			  test.log(LogStatus.INFO, "Car Brand find correct");
		  }catch(Exception e) {
			  test.log(LogStatus.FAIL, e.getMessage());
		  }	
	}
	
	public void carModel(String carModel) {
		  WebElement carModelElement = driver.findElement(By.xpath("//span[text()='Model']"));
		  carModelElement.click();
		  try {
			  WebElement carModelValue =  wait.until
				  	(ExpectedConditions.elementToBeClickable
				  	(By.xpath("//li[@data-key='model']//span[text()='"+ carModel + "']")));
			  carModelValue.click();
			  test.log(LogStatus.INFO, "Car Model find correct");
		  }catch(Exception e) {
			  test.log(LogStatus.FAIL, e.getMessage());
		  }	
		
	}

}
