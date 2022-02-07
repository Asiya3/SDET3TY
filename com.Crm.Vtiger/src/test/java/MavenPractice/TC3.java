package MavenPractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		

		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		
		driver.findElement(By.xpath("//img[@title=\'Create Contact...\']")).click();
		Select se=new Select (driver.findElement(By.xpath("//select[@name=\'salutationtype\']")));
	se.selectByVisibleText("Ms.");
	
	String name="ddd";
	
	String name1="d1";
	
	driver.findElement(By.name("firstname")).sendKeys(name);
	
	
	driver.findElement(By.name("lastname")).sendKeys(name1);
	
	driver.findElement(By.xpath("//img[@title='Select']")).click();
	
	
                 Set<String> ven=driver.getWindowHandles();
                 
                 Iterator<String> it=ven.iterator();
                 
	           String parent=it.next();
	           
	           
	           String child=it.next();
	           
	           Thread.sleep(3000);
	           
	           
	           driver.switchTo().window(child);
	           
	           Thread.sleep(2000);
	           driver.findElement(By.id("search_txt")).sendKeys("zzz");
	           
	           driver.findElement(By.xpath("//input[@name='search']")).click();
	           
	           driver.findElement(By.xpath("//a[@id='1']")).click();
	           
	           Thread.sleep(2000);
	           
	           driver.switchTo().window(parent);
	           
	           Thread.sleep(2000);
	           
	           driver.findElement(By.cssSelector("input[class=\"crmButton small save\"]")).click();
				
				  Thread.sleep(3000);
	           
				  driver.findElement(By.xpath("//a[.='Contacts']")).click();
				  
					Thread.sleep(3000);
					
	               driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(name);
	               Select sl=new Select(driver.findElement(By.id("bas_searchfield")));
	               sl.selectByValue("firstname");
	               
	               Thread.sleep(3000);
	               
	               driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
	               Actions aa = new Actions(driver);
	               WebElement ss=driver.findElement(By.xpath("//img[@src='theme/softed/images/user.PNG']"));
	               aa.moveToElement(ss).perform();
	               
	               driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	               
	               	driver.close();
	           
	           
	           
	           
	/*driver.findElement(By.xpath("//input[@name=\"search_text\"]")).sendKeys("lll");
	
    Select se1=new Select(driver.findElement(By.name("search_field")));	
	
	se1.selectByVisibleText("Organization Name");
	*/
	
	
	
	
	
	
	
	
	}

}
