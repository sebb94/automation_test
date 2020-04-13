package test_olx;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
  public void test1() {
	  System.out.println("TEST");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  
  }

}
