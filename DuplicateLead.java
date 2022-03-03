package week2.day2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class DuplicateLead {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("DemoSalesManager");


		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("TestLeaf@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(5000);

		WebElement gridVal = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/parent::td"));
		String firstId = gridVal.getText();
		System.out.println(firstId);
		gridVal.click();
		
		WebElement dupLead = driver.findElement(By.xpath("//a[contains(text(),'Duplicate Lead')]"));
		String val1 = dupLead.getText();
		
		String title = driver.getTitle();
		System.out.println(title);
		WebElement createLead = driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]"));
		String val2 = createLead.getText();
		
		if(val1!=val2)
		{
			System.out.println("Both ID are not same");
		}
		else
			System.out.println("Both ID are same");
		

	}

	

}
