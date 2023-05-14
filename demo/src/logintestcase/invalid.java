package logintestcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class invalid {
  @Test
  public void invalidlogin() throws InterruptedException {
	  
	  System.setProperty("webdriver.chrome.driver", "C://driver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");

		WebElement name=driver.findElement(By.id("txtUsername"));
		name.sendKeys("Admin");
		
		WebElement pass=driver.findElement(By.id("txtPassword"));
		pass.sendKeys("admin123");

		WebElement submit=driver.findElement(By.id("btnLogin"));
		submit.click();
		
		driver.close();
  }
}
