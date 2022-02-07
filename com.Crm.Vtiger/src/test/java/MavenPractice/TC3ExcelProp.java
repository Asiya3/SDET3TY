package MavenPractice;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

import com.Crm.Vtiger.IAutoConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC3ExcelProp {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		 FileInputStream fis=new FileInputStream(IAutoConstants.proptFilePath);
			
			Properties prop=new Properties();
			
			prop.load(fis);
			String value=prop.getProperty("url");
			String UN=prop.getProperty("username");
			String PWD=prop.getProperty("password");
			
			System.out.println(value);
		 
			
			  WebDriverManager.chromedriver().setup();
			 
			  WebDriver driver=null;
			  String Browser=prop.getProperty("Browser");
			  
			  
			  if(Browser.equalsIgnoreCase("chrome"))
			  {
				 
				  driver=new ChromeDriver();
				  
				  driver.get(value);
				  
			  }
			  
			  else if(Browser.equalsIgnoreCase("opera"))
			  {
				  driver=new OperaDriver();
			  }
			 
			  else
			  {
				  System.out.println("Browser Not Available");
			  }
			  
			  
			
			  
			  
				
				   driver.manage().window().maximize();
				   
				   
				  
				  driver.findElement(By.name("user_name")).sendKeys(UN);
				  driver.findElement(By.name("user_password")).sendKeys(PWD);
				  
				  
				  driver.findElement(By.id("submitButton")).click(); Thread.sleep(3000);
				  
					driver.findElement(By.xpath("//a[.='Contacts']")).click();
					
					driver.findElement(By.xpath("//img[@title=\'Create Contact...\']")).click();
					Select se=new Select (driver.findElement(By.xpath("//select[@name=\'salutationtype\']")));
				se.selectByVisibleText("Ms.");
				
				 FileInputStream fis1=new FileInputStream(IAutoConstants.excelPath);
				  
				  Workbook book=WorkbookFactory.create(fis1);
				  
				  String str=book.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
				  driver.findElement(By.name("firstname")).sendKeys(str);
					
				  String str1=book.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
				  driver.findElement(By.name("lastname")).sendKeys(str1);
					
					driver.findElement(By.xpath("//img[@title='Select']")).click();
					 Set<String> ven=driver.getWindowHandles();
	                 
	                 Iterator<String> it=ven.iterator();
	                 
		           String parent=it.next();
		           
		           
		           String child=it.next();
		           
		           Thread.sleep(3000);
		           
		           
		           driver.switchTo().window(child);
		           
		           Thread.sleep(2000);
		           driver.findElement(By.id("search_txt")).sendKeys("zzz");
		           driver.findElement(By.name("search")).click();
		           Thread.sleep(2000);
		           
		           driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
		           

		           driver.switchTo().window(parent);
		           
		           Thread.sleep(2000);
		           
		           driver.findElement(By.cssSelector("input[class=\"crmButton small save\"]")).click();
					
					  Thread.sleep(3000);
		           
					  driver.findElement(By.xpath("//a[.='Contacts']")).click();
					  driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(str);
		               Select sl=new Select(driver.findElement(By.id("bas_searchfield")));
		               sl.selectByValue("firstname");
		               
		               Thread.sleep(3000);
		               
		               driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		               
		               Thread.sleep(3000);
		               WebElement ele=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
								  
								  
								  Actions act=new Actions(driver) ; act.moveToElement(ele).build().perform();
								 
								  driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
								  
								   
		               	driver.close();
		         
				
		           

		
		
		
	}

}
