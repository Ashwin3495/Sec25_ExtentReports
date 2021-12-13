package qaclick.Sec25_ExtendReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Lec167_ExtendReports {
	ExtentReports extent=new ExtentReports();
	
	@BeforeTest
	public void config()
	{
		
		//Two main object for Reports - ExtentReport , ExtentSparkReporter
		String path= System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation");
		reporter.config().setDocumentTitle("Results");
		
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ashwin");
		
	}
	
	@Test
	public void initialDemo()
	{
		ExtentTest test=extent.createTest("TestDemo");
		System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#!");
		System.out.println(driver.getTitle());
		//test.addScreenCaptureFromBase64String(test);   - ScreenCapture
		test.fail("Result fail");
		extent.flush();
	}
}
