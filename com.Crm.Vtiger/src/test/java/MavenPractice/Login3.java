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

public class Login3 {

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

		String str=book.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();

		System.out.println(str);


		driver.findElement(By.name("accountname")).sendKeys(str); //
		driver.findElement(By.xpath("//input[@type='button']")).click(); //
		Thread.sleep(3000); //
		driver.findElement(By.xpath("//a[.='Organizations']")).click(); //
		driver.findElement(By.xpath("//input[@class=\"txtBox\"]")).sendKeys(str); //

		//Checking org is created or not
		Select sel=new	Select(driver.findElement(By.xpath("//select[@id='bas_searchfield']"))); //
		sel.selectByVisibleText("Organization Name");
		driver.findElement(By.name("submit")).click(); // 
		Thread.sleep(3000); // //

		//Validation
		String 	val=driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		if(val.equalsIgnoreCase(str)) // 
		{ //
			System.out.println("TC 1 Pass"); // 
		} // // 
		else // 
		{ //
			System.out.println("TC 1 Fail"); //
		} //

		//Log out from Application
		WebElement ele=driver.findElement(By.xpath(	"//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions act=new Actions(driver) ; act.moveToElement(ele).build().perform();
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();

		
		driver.close();



	}

}
