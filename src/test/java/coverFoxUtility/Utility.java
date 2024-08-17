package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {
	
	public static void takeScreenShot(WebDriver driver , String fileName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Reporter.log("taking screenshot",true);
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		File dest=new File(System.getProperty("user.dir")+"\\screenShots\\"+fileName+timeStamp+".png");
		Reporter.log("screenshot saving at location "+ dest, true);
		FileHandler.copy(src, dest);
	}	
	
	public static String readDataFromExcel(String filePath , String SheetName ,int RowNum , int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream myFile = new FileInputStream(filePath);
		//Reporter.log("reading data from excel",true);
		String value = WorkbookFactory.create(myFile).getSheet(SheetName).getRow(RowNum).getCell(CellNum).getStringCellValue();
		return value;
	}
	
	 public static String readDataFromPropertiesFile(String key) throws IOException
	  {
		  FileInputStream myFile=new FileInputStream(System.getProperty("user.dir")+"\\fbTest.properties");
	      Properties prop=new Properties();
	       prop.load(myFile);
	     //  Reporter.log("reading data from properties file",true);
	       String value = prop.getProperty(key);
	       return value;
	  }
	 
	

}
