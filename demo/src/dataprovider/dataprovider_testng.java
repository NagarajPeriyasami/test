package dataprovider;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class dataprovider_testng {
  @Test(dataProvider = "dp")
  public void Login(String Username , String Password) {
	  
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
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admin", "aamin123" },
      new Object[] { "abc", "ddb" },
      new Object[] { "gb", "bv" },
      new Object[] { "test", "123" },
    };
  }
}
