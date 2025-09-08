package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public WebDriver driver;
	Properties p;

	@BeforeClass
	public void setUp() throws Exception {
		// Loading cofig.properties file
		FileReader file = new FileReader(
				"F:\\CapstoneProject\\nopCommerceProject\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);

	//	driver = new ChromeDriver();
		driver= new EdgeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); // adjust
		// as needed

		// driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));// reading url from properties file

		driver.manage().window().maximize();

	}

			@AfterClass
			public void tearDown() {
				driver.quit();
			}

	public String captureScreen(String testName) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
			String timeStamp = df.format(new Date(0));

			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

			String targetDir = System.getProperty("user.dir") + File.separator + "Screenshots";
			File dir = new File(targetDir);
			if (!dir.exists())
				dir.mkdirs();

			String targetFilePath = targetDir + File.separator + testName + "_" + timeStamp + ".png";
			File targetFile = new File(targetFilePath);

			FileUtils.copyFile(sourceFile, targetFile); // safer than renameTo
			return targetFilePath;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	public String randomGender() {
	    return (Math.random() < 0.5) ? "Male" : "Female";
	}

	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomeNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public String alphaNumeric() {
		String str = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);
		return (str + "@" + num);
	}
	public Map<String, String> generateRegistrationData() {
	    Map<String, String> data = new HashMap<>();

	    data.put("gender", randomGender());
	    data.put("firstName", randomString());
	    data.put("lastName", randomString());
	    data.put("email", randomString() + "@gmail.com");
	    data.put("companyName", randomString() + " Pvt Ltd");
	    data.put("password", alphaNumeric());

	    return data;
	}
}
