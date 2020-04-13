package test_olx;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	
	  public static String takeScreenshot(WebDriver driver) throws IOException {
		    String fileName = getRandomString(10) + ".png";
			String directory = System.getProperty("user.dir") + "//screenshots//";
			File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourceFile, new File(directory + fileName));
			String destination = directory + fileName;
			return destination;
		}
	  
		public static String getRandomString(int len) {
			StringBuilder sb = new StringBuilder();
			String characters = "qwertyyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
			
			for(int i=0; i<len; i++) {
				int index = (int)(Math.random() * characters.length());
				sb.append(characters.charAt(index));
			}
			
			return sb.toString();	
		}
}
