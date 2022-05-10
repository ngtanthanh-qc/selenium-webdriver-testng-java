package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Xpath_Part_I {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_() {
		// Find (element/elements)
		driver.findElement(By.id("")).click();  // dùng 1 lần
		WebElement loginButton = driver.findElement(By.id("")); // dùng nhiều lần
		
		loginButton.click();
		loginButton.isDisplayed();
		// Action
		// Verify/Assert
		
		List<WebElement> loginCheckboxes =  driver.findElements(By.id(""));
		for (int i = 0; i < loginCheckboxes.size(); i++) {
			loginCheckboxes.get(i).click();
		}
		
	}

	@Test
	public void TC_02_() {

	}

	@Test
	public void TC_03_() {

	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
}
