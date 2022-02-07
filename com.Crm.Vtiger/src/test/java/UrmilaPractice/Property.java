package UrmilaPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Property {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis=new FileInputStream("C:\\\\MavenTyss\\\\Excel\\\\Book1.xlsx");
		
		Workbook book=WorkbookFactory.create(fis);
		
		String str=book.getSheet("Sheet1").getRow(5).getCell(2).getStringCellValue();
		
		System.out.println(str);

	}

}
