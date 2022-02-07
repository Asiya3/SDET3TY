package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC29 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		

		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		
		  Select sel=new Select(driver.findElement(By.name("salutationtype")));
		  
		  sel.selectByVisibleText("Ms.");
		  
		  String name="shannu";
		  driver.findElement(By.name("firstname")).sendKeys(name);
			
			String name1="opt";
			  
			  driver.findElement(By.name("lastname")).sendKeys(name1);
			  
			  Thread.sleep(3000);
			  
			  driver.findElement(By.id("email")).sendKeys("raahisultha@gmail.com");
			  
			  
			  driver.findElement(By.name("reference")).click();
			  
			  
			  
			  driver.findElement(By.cssSelector("input[class=\"crmButton small save\"]")).click();
			
			  Thread.sleep(3000);
				
				  WebElement ele=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
				  
				  
				  Actions act=new Actions(driver) ; act.moveToElement(ele).build().perform();
				  
				  Thread.sleep(3000);
				  
				  driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				  driver.close();
				 
		
		
		
	}

}
