package dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ladp {
  @Test(dataProvider = "db")
  public void login(String Username,String Password) {
	  
	  System.setProperty("webdriver.chrome.driver", "C://driver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		
		
		WebElement name=driver.findElement(By.id("txtUsername"));
		name.sendKeys(Username);

		WebElement pass=driver.findElement(By.id("txtPassword"));
		pass.sendKeys(Password);
		
		WebElement submit=driver.findElement(By.id("btnLogin"));
		submit.click();
		driver.close();
	  
  }
  
  @DataProvider
  public String[][] db(){
	  String [][]data= {
			  
			  {"Admin","admin123"},
			  {"abv","admin123"},
			  {"test","admin123"}
			  
	  };return data;
	
	  
	  
  }
  
  
}
