package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_XPath_Part_II {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Register_01_Empty_Data() {
		// mở app ra
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		// click vào Đăng ký button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// Kiểm tra 1 điều kiện trả về là bằng vs điều kiện mong muốn
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");
		
		
	}

	@Test
	public void Register_02_Invalid_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("ThanhNguyen");
		driver.findElement(By.id("txtEmail")).sendKeys("123@345@456");
		driver.findElement(By.id("txtCEmail")).sendKeys("123@345@456");
		driver.findElement(By.id("txtPassword")).sendKeys("123456789@Aa");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456789@Aa");
		driver.findElement(By.id("txtPhone")).sendKeys("0987654321");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
		
	}

	@Test
	public void Register_03_Incorrect_Confirm_Email() {
		
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("ThanhNguyen");
		driver.findElement(By.id("txtEmail")).sendKeys("ngtanthanh.qc@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("123@345@456");
		driver.findElement(By.id("txtPassword")).sendKeys("123456789@Aa");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456789@Aa");
		driver.findElement(By.id("txtPhone")).sendKeys("0987654321");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
	}
	@Test
	public void Register_04_Password_Less_Than_6_Chars() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("ThanhNguyen");
		driver.findElement(By.id("txtEmail")).sendKeys("ngtanthanh.qc@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("123@345@456");
		driver.findElement(By.id("txtPassword")).sendKeys("123");
		driver.findElement(By.id("txtCPassword")).sendKeys("123");
		driver.findElement(By.id("txtPhone")).sendKeys("0987654321");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");

	}
	
	@Test
	public void Register_05_Incorrect_Confirm_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("ThanhNguyen");
		driver.findElement(By.id("txtEmail")).sendKeys("ngtanthanh.qc@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("123@345@456");
		driver.findElement(By.id("txtPassword")).sendKeys("123456789@Aa");
		driver.findElement(By.id("txtCPassword")).sendKeys("123");
		driver.findElement(By.id("txtPhone")).sendKeys("0987654321");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");

	}

	@Test
	public void Register_06_Invalid_Phone_Number() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("ThanhNguyen");
		driver.findElement(By.id("txtEmail")).sendKeys("ngtanthanh.qc@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("123@345@456");
		driver.findElement(By.id("txtPassword")).sendKeys("123456789@Aa");
		driver.findElement(By.id("txtCPassword")).sendKeys("123");
		driver.findElement(By.id("txtPhone")).sendKeys("098765432101");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");
		
		// re-input
		
		driver.findElement(By.id("txtFirstname")).clear();
		driver.findElement(By.id("txtEmail")).clear();
		driver.findElement(By.id("txtCEmail")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtCPassword")).clear();
		driver.findElement(By.id("txtPhone")).clear();
		
		
		driver.findElement(By.id("txtFirstname")).sendKeys("ThanhNguyen");
		driver.findElement(By.id("txtEmail")).sendKeys("ngtanthanh.qc@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("123@345@456");
		driver.findElement(By.id("txtPassword")).sendKeys("123456789@Aa");
		driver.findElement(By.id("txtCPassword")).sendKeys("123");
		driver.findElement(By.id("txtPhone")).sendKeys("12345678");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019");
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
}
