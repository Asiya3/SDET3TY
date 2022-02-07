package MavenPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class AssSal {
	  
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\MavenTyss\\Excel\\Book2.xlsx");
		
		String  str;
		   Workbook book=WorkbookFactory.create(fis);
		   
		   
		  Sheet sh=book.getSheet("Sheet1");
			
		  
			
			  for(int i=0;i<=sh.getLastRowNum();i++) {
			  
			  for(int j=0;j<=1;j++) 
			  { 
				  Row r=sh.getRow(i); 
				
				  Cell  ce=r.getCell(j);
				  
					/*
					 * if(ce50000) { System.out.println(ce); }
					 */
				 System.out.println(ce);
				 
				 
				 if(ce.equals(50000))
				 {
					 System.out.println(ce);
					 
				 }
				
				 
				 
				 
					/*
					 * if(ce>=50000) {
					 * 
					 * }
					 */
				 
				  
					/*
					 * if(ce.getColumnIndex(1)) {
					 * 
					 * str=String.valueOf(ce.getNumericCellValue());
					 * 
					 * 
					 * System.out.println(str);
					 * 
					 * }
					 */
				  
			  }
			
			
			  }
		 	}
}
