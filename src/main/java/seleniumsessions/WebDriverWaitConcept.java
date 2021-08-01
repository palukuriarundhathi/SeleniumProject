package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {
static WebDriver driver;
	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
	      driver = new ChromeDriver();
	     driver.get("https://demo.opencart.com/index.php?route=account/login");    
	     By emailId =By.id("input-email");
	      By password =By.id("input-password");
	      By loginbtn =By.xpath("//input[@type='submit']");
	      
	   
	   
//	     WebDriverWait wait = new  WebDriverWait(driver, 10);
//	     wait.until(ExpectedConditions.presenceOfElementLocated(emailId)).sendKeys("testing@gmail.com") ;
	     // waitForElementPresence(10,emailId).sendKeys("testing@gmail.com");
	      WebElement ele_emailid= waitForElementPresence(10,emailId);
	    //  doSendKeys(ele_emailid);
	      doSendKeys(waitForElementPresence(10,emailId));
	     driver.findElement(password).sendKeys("testing@gmail.com");
	     driver.findElement(loginbtn).click();	
	   }
/**
 * An expectation for checking that an element is present on the DOM of a page.
 *  This does not necessarily mean that the element is visible.        
 * @param timeout
 * @param locator
 * @return
 */
	public static WebElement waitForElementPresence(int timeout,By locator) {
		 WebDriverWait wait = new  WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator)) ;
	}
 public static void doSendKeys(WebElement ele_emailid)
 {
	 ele_emailid.sendKeys("testing@gmail.com");
 }
 }

