package MavenPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fis=new FileInputStream("C:\\MavenTyss\\login.txt");
		
		Properties prop=new Properties();
		prop.load(fis);
		
		String str=prop.getProperty("password");
		
		System.out.println(str);
		
		
		
	}

}
