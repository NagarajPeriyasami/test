package usingexcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class login_jxl {
	
	Object [][] data=null;
	
	@DataProvider
	public Object[][] logindata() throws BiffException, IOException{
	
	data=jxl();
	return data;
	}
	
	
	public Object [][] jxl() throws BiffException, IOException {
		
		FileInputStream fis=new FileInputStream("D:\\newtest.xls");
		
		Workbook wbook=Workbook.getWorkbook(fis);
		
		Sheet sheet=wbook.getSheet(0);
		int rows=sheet.getRows();
		int col=sheet.getColumns();
		
		Object[][]newdata=new Object [rows-1][col];
		
		for(int i=1;i<rows;i++) {
			for(int j=0;j<col;j++) {
				
				
				newdata[i-1][j]=sheet.getCell(j, i).getContents();
				
				
				
			}
		}
		
		return newdata;
	}
	
	
	@Test(dataProvider = "logindata")
	public void login(String us,String passw) {
		System.setProperty("webdriver.chrome.driver", "C://driver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		
		
		WebElement name=driver.findElement(By.id("txtUsername"));
		name.sendKeys(us);

		WebElement pass=driver.findElement(By.id("txtPassword"));
		pass.sendKeys(passw);
		
		WebElement submit=driver.findElement(By.id("btnLogin"));
		submit.click();
		driver.close();}
		
	
		
		
		
		
		
		
		
		
		
	}
	
	
	
	


