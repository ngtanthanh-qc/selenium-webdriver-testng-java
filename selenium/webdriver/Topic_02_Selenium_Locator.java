package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
	}

	@Test
	public void TC_01_() {
		//Id
		driver.findElement(By.id("email")).sendKeys("ngtanthanh.qc@gmail.com");;
		//Class
		driver.findElement(By.className("fb_logo"));
		//Name
		driver.findElement(By.name("email")).isDisplayed();
		//TagName: tìm xem có bao nhiêu element cùng loại trên HTML
		driver.findElement(By.tagName("a")); //trả về element đầu tiên nếu có nhiều element
		driver.findElements(By.tagName("a")); // trả về 1 list element
		//Link Text: Truyền cả text
		driver.findElement(By.linkText("Tiếng Việt"));
		//Partial Link Text: 1 phần
		//độ chính xác không cao
		driver.findElement(By.partialLinkText("Tiếng"));
		//CSS
		driver.findElement(By.cssSelector("input[id='email']"));
		driver.findElement(By.cssSelector("input#email")); // # dùng thay cho id
		driver.findElement(By.cssSelector("#email")); // # cover cho Id
		
		driver.findElement(By.cssSelector("img[class='fb_logo _8ilh img']"));
		driver.findElement(By.cssSelector("img.fb_logo"));  //cover class
		driver.findElement(By.cssSelector(".fb_logo"));
		
		driver.findElement(By.cssSelector("input[name='email']")); //cover Name

		driver.findElement(By.cssSelector("a")); //cover Tagname
		
		//CSS ko làm việc với text (dùng thuộc tính của thẻ a để thao tác)
		driver.findElement(By.cssSelector("a[title='Vietnamese']"));  //cover LinkText
		
		driver.findElement(By.cssSelector("a[onclick*='vi_VN']"));
		driver.findElement(By.cssSelector("a[title*='Vietnamese']"));
					
		
		//XPath
		driver.findElement(By.xpath("//input[@id='email']"));  //cover Id
		driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']"));
		driver.findElement(By.xpath("//img[contains(@class,'fb_logo')]")); // Cover class
		driver.findElement(By.xpath("//input[@name='email']"));  //cover Name
		driver.findElement(By.xpath("//a"));  // cover link text
		driver.findElement(By.xpath("//a[text()='Tiếng Việt']")); //cover Partial link text
		driver.findElement(By.xpath("//a[contains(text(),'Việt')]")); //cover Partial link text
		driver.findElement(By.xpath("//a[contains(text(),'Tiếng')]")); //cover Partial link text
			
		
	}

	@Test
	public void TC_02_() {

	}



	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
