package test_olx;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {

	public static ExtentReports getInstance() {
		ExtentReports extent;
		extent = new ExtentReports("./reports/cars_test.html", false);
		return extent;
		
	}
}
