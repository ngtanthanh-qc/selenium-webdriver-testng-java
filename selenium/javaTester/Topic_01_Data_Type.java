package javaTester;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Topic_01_Data_Type {
	public static void main(String[] args) {
		// Khai báo biến
		int studentNumber;
		
		// Khởi tạo dữ liệu
		
		studentNumber = 100;
		
		// I - Nguyên thủy (Primitive)
		
		// boolean
		boolean studentStatus = true;
		// byte
		byte bEmployee = 10;
		// short
		short sEmployee = 10;
		// int
		int iEmployee = 10; 
		// long
		long lEmployee = 10000;
		// float
		float fEmployee = 7.5f;
		// double
		double dEmployee = 8.4d;
		
		// char
		char b = 'B';
		// II - Tham chiếu (Reference)
		
		// Array
		int[] studentNumbers = {15, 20, -7, 10};
		String[] studentNames = {"Nguyen Van A", "ABC"};
		
		// Interface/Class
		WebDriver driver = new ChromeDriver();
		
		Actions action = new Actions(driver);
		
		
		// Collection: List(ArrayList/LinkedList) / Set/ Queue
		ArrayList<String> studentCountry = new ArrayList<String>();
		
		// Object
		Object phone;
		
		// Chuỗi kí tự: Số/Chữ/Kí tự đặc biệt
		String studentName = "BA";
		String companyName = "TMA Solutions @ 2022";
		
		
	}

}
