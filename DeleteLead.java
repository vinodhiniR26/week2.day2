package week2.day2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("DemoSalesManager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9876543210");

		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();

		Thread.sleep(5000);
		WebElement gridVal = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//a[1]"));
		String firstId = gridVal.getText();
		System.out.println(firstId);
		gridVal.click();
		driver.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(firstId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		WebElement noElement = driver.findElement(By.xpath("//div[contains(text(),'No records to display')]"));
		String expVal=noElement.getText();
		if (expVal.contains("No records to display")) 
		{
			System.out.println("No ID is found");
		}
		
		driver.close();

	
	}

}
