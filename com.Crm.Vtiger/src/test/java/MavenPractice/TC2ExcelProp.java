package MavenPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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

public class TC2ExcelProp {

	public static void main(String[] args) throws InterruptedException, IOException {
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
				  
				  
				  driver.findElement(By.xpath("//a[.='Organizations']")).click(); //
				  driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click(); // 
				  Thread.sleep(3000); 
				  
				  
				  
				  FileInputStream fis1=new FileInputStream(IAutoConstants.excelPath);
				  
				  Workbook book=WorkbookFactory.create(fis1);
				  
				  String str=book.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
				   
					System.out.println(str);
					 driver.findElement(By.name("accountname")).sendKeys(str); //
					 
		
		
					
					 Select sel=new Select(driver.findElement(By.xpath("//select[@name=\"industry\"]")));
							 sel.selectByVisibleText("Environmental"); Thread.sleep(3000);
							 
							
							 Select sel1=new Select(driver.findElement(By.xpath("//select[@name=\"rating\"]")));
							  sel1.selectByVisibleText("Active");
							  
							 
							  Select sel2=new
							  Select(driver.findElement(By.xpath("//select[@name=\"accounttype\"]")));
							 sel2.selectByVisibleText("Analyst");
							 
							 driver.findElement(By.name("button")).click(); Thread.sleep(3000);
		
		
							 driver.findElement(By.xpath("//a[.='Organizations']")).click(); //
							  
							  driver.findElement(By.xpath("//input[@class=\"txtBox\"]")).sendKeys(str); //
							  Select sel23=new
							  Select(driver.findElement(By.xpath("//select[@id='bas_searchfield']"))); //
							  sel23.selectByVisibleText("Organization Name");
							  driver.findElement(By.name("submit")).click(); // Thread.sleep(3000); // //
							  Thread.sleep(3000);
							  
							  String
							  val2=driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
							  Thread.sleep(3000); // // 
							  if(val2.equalsIgnoreCase(str)) //
								  {
							  
							  System.out.println("TC 2 Pass");
							  
							  } 
	                          else
							  
							  { // 
								  System.out.println("TC 2Fail"); // 
								  } //
							  
							  
							  
							  WebElement ele=driver.findElement(By.xpath(
							  "//img[@src=\"themes/softed/images/user.PNG\"]"));
							  
							  
							  Actions act=new Actions(driver) ; act.moveToElement(ele).build().perform();
							  Thread.sleep(3000); driver.findElement(By.xpath(
							  "//a[@href='index.php?module=Users&action=Logout']")).click();
							  
							  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
								/*
								 * WebDriverManager.chromedriver().setup();
								 * 
								 * WebDriver driver=new ChromeDriver();
								 * 
								 * 
								 * driver.get("http://localhost:8888/index.php?action=Login&module=Users");
								 * driver.manage().window().maximize();
								 * 
								 * driver.findElement(By.name("user_name")).sendKeys("admin");
								 * driver.findElement(By.name("user_password")).sendKeys("admin");
								 * 
								 * 
								 * driver.findElement(By.id("submitButton")).click(); Thread.sleep(3000);
								 * driver.findElement(By.xpath("//a[.='Organizations']")).click(); //
								 * driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).
								 * click(); Thread.sleep(3000); String name="ppppp";
								 * driver.findElement(By.name("accountname")).sendKeys(name);
								 * Thread.sleep(3000); Select sel=new
								 * Select(driver.findElement(By.xpath("//select[@name=\"industry\"]")));
								 * sel.selectByVisibleText("Environmental"); Thread.sleep(3000); Select sel1=new
								 * Select(driver.findElement(By.xpath("//select[@name=\"rating\"]")));
								 * sel1.selectByVisibleText("Active");
								 * 
								 * 
								 * Select sel2=new
								 * Select(driver.findElement(By.xpath("//select[@name=\"accounttype\"]")));
								 * sel2.selectByVisibleText("Analyst");
								 * 
								 * 
								 * driver.findElement(By.name("button")).click(); Thread.sleep(3000);
								 * 
								 * driver.findElement(By.xpath("//a[.='Organizations']")).click(); //
								 * 
								 * driver.findElement(By.xpath("//input[@class=\"txtBox\"]")).sendKeys(name); //
								 * Select sel23=new
								 * Select(driver.findElement(By.xpath("//select[@id='bas_searchfield']"))); //
								 * sel23.selectByVisibleText("Organization Name");
								 * driver.findElement(By.name("submit")).click(); // Thread.sleep(3000); // //
								 * Thread.sleep(3000);
								 * 
								 * String
								 * val2=driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
								 * Thread.sleep(3000); // // if(val2.equalsIgnoreCase(name)) // {
								 * 
								 * System.out.println("TC 2 Pass");
								 * 
								 * } else
								 * 
								 * { // System.out.println("TC 2Fail"); // } //
								 * 
								 * 
								 * 
								 * WebElement ele=driver.findElement(By.xpath(
								 * "//img[@src=\"themes/softed/images/user.PNG\"]"));
								 * 
								 * 
								 * Actions act=new Actions(driver) ; act.moveToElement(ele).build().perform();
								 * Thread.sleep(3000); driver.findElement(By.xpath(
								 * "//a[@href='index.php?module=Users&action=Logout']")).click();
								 * 
								 * 
								 */
		 
		
		
	}

}
