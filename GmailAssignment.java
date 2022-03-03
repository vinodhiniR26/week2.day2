package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement email_enter = driver.findElement(By.xpath("//input[@id='email']"));	
		email_enter.sendKeys("kumar.testleaf@gmail.com");
		
		WebElement pwd_enter = driver.findElement(By.xpath("//input[@id='password']"));	
		pwd_enter.sendKeys("leaf@12");
		
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();  
		
		
		String title =driver.getTitle();
		System.out.println("The title is" + title);
		
		WebElement btnlogout =  driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));

		btnlogout.click();
		
		driver.close();

		
		
		
	}

}
