package MavenPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC2 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		

		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Organizations']")).click(); //
		  driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).
		  click();  
		  Thread.sleep(3000); 
		String name="CCC"; 
		  driver.findElement(By.name("accountname")).sendKeys(name); 
		  Thread.sleep(3000); 
		  Select sel=new Select(driver.findElement(By.xpath("//select[@name=\"industry\"]")));
		  sel.selectByVisibleText("Environmental");
		  Thread.sleep(3000); 
		  Select sel1=new Select(driver.findElement(By.xpath("//select[@name=\"rating\"]")));
		  sel1.selectByVisibleText("Active");
		  
		  
		  Select sel2=new Select(driver.findElement(By.xpath("//select[@name=\"accounttype\"]")));
            sel2.selectByVisibleText("Analyst");
            
            
		driver.findElement(By.name("button")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//a[.='Organizations']")).click(); //
			
			  driver.findElement(By.xpath("//input[@class=\"txtBox\"]")).sendKeys(name); //
			  Select sel23=new
			  Select(driver.findElement(By.xpath("//select[@id='bas_searchfield']"))); //
			  sel23.selectByVisibleText("Organization Name");
			  driver.findElement(By.name("submit")).click(); // Thread.sleep(3000); // //
			  Thread.sleep(3000);
			 
			  String  val2=driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
			  Thread.sleep(3000); // //
			  if(val2.equalsIgnoreCase(name)) // 
			  { 
				  
		  System.out.println("TC 2 Pass"); 
		  
		  } 
		  else 

			  { //
		  System.out.println("TC 2Fail"); // 
		  } //
			  
			  
			  
			  WebElement ele=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
				
				
				Actions act=new Actions(driver) ;
				act.moveToElement(ele).build().perform();
			Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
				
			
			
		  
			
			
			
		}

	

		  
		  
		  
		  
		
	}


