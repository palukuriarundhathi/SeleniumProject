package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) {

     WebDriverManager.chromedriver().setup();
     WebDriver driver = new ChromeDriver();
     
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.get("https://demo.opencart.com/index.php?route=account/login");
     WebElement emailId = driver.findElement(By.id("input-email"));    
      WebElement password = driver.findElement(By.id("input-password"));    
      WebElement loginbtn = driver.findElement(By.xpath("//input[@type='submit']"));
      emailId.sendKeys("testing");
      password.sendKeys("testing@gmail.com");
      loginbtn.click();	
      
      
      
	}
	

}
