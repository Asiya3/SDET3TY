package MavenPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFetch2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		FileInputStream fis=new FileInputStream("C:\\MavenTyss\\Excel\\Book1.xlsx");
		
               
		   Workbook book=WorkbookFactory.create(fis);
		   
		   
		   
	String str=book.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
		   
	System.out.println(str);
		   
	}

}
