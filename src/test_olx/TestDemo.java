package test_olx;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class TestDemo {
	
   WebDriver driver;
   String baseURL;

  @BeforeClass
  public void beforeClass() {
	    baseURL = "https://olx.pl";	
	    driver = new ChromeDriver();
	    
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
  }
  
  @Test
  public void test1() throws Exception {
	  System.out.println("TEST");
	  WebDriverWait wait = new WebDriverWait(driver, 3);
	  driver.findElement(By.xpath("//div[@class='maincategories']//span[text()=\"Motoryzacja\"]")).click();
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//span[@class='link category-name']//span[text()=\"Samochody osobowe\"]")).click();
	  Thread.sleep(500);
	  
	  WebElement carBrand = driver.findElement(By.xpath("//span[text()=\"Marka\"]"));
	  carBrand.click();
	  WebElement carBrandValue =  wait.until
			  	(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-code='bmw']")));
	  carBrandValue.click();
	  
  }

  @AfterClass
  public void afterClass() {
	 //driver.quit();
	  
  }

}
