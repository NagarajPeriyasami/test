package usingpachepoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
	
	static List<String> usernamelist=new ArrayList <String>();
	static List<String> passlist=new ArrayList <String>();
	
	public void readexcel() throws IOException {
		
		FileInputStream fis=new FileInputStream("D:\\newtest.xls");
		
		HSSFWorkbook wrkbook=new HSSFWorkbook(fis);
		
		HSSFSheet sheet=wrkbook.getSheetAt(0);
		
		Iterator<Row> row=	sheet.iterator();
		
		while (row.hasNext()) {
		Row rowvalue=row.next();
		Iterator<Cell> cellvalue=rowvalue.iterator();
			
		int i=2;
		while(cellvalue.hasNext()) {
			//cellvalue.next();
				if(i%2==0) {
					usernamelist.add(cellvalue.next().getStringCellValue());
				}
				else {
					passlist.add(cellvalue.next().getStringCellValue());
				}i++;
				
			}
			
		}
	
		
		
		
	}
	public void executetest() {
		for(int i=0;i<usernamelist.size();i++) {
			login(usernamelist.get(i),passlist.get(i));
		}
	}
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

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		login obj=new login();
		obj.readexcel();
		System.out.println("user name is"+usernamelist);
		System.out.println("password list"+passlist);
		obj.executetest();
		
	}

}
