package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlertConcept {
    static WebDriver driver;
	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
//	      
//	     driver.get("https://mail.rediff.com/cgi-bin/login.cgi");  
//	     driver.findElement(By.name("proceed")).click();
//	     
         
         driver.get(" https://demo.opencart.com/index.php?route=account/login");
//	     WebDriverWait wait = new WebDriverWait(driver,10);
//	    Alert alert =  wait.until(ExpectedConditions.alertIsPresent());
//	    
//	    System.out.println(alert.getText());
//	     alert.accept();
	     
	     String text = getAlertText(10);
	     System.out.println(text);
	   
	     driver.findElement(By.name("proceed")).click(); 
	     
	     
	     }
	public static String waitForUrl(String UrlFraction ,int timeOut) {
		 WebDriverWait wait = new WebDriverWait(driver,timeOut);
		    if(wait.until(ExpectedConditions.urlContains(UrlFraction))) {
		    	return driver.getCurrentUrl();
		      }
		    return null;
		    }
	public static String waitForFullUrl(String UrlValue ,int timeOut) {
		 WebDriverWait wait = new WebDriverWait(driver,timeOut);
		    if(wait.until(ExpectedConditions.urlToBe(UrlValue))) {
		    	return driver.getCurrentUrl();
		      }
		    return null;
		    }

	
	public static String waitForTitleContains(String titleValue ,int timeOut) {
		 WebDriverWait wait = new WebDriverWait(driver,timeOut);
		    if(wait.until(ExpectedConditions.titleContains(titleValue))) {
		    	return driver.getTitle();
		      }
		    return null;
		    }

	public static String waitForTitleIs(String fullTitile ,int timeOut) {
		 WebDriverWait wait = new WebDriverWait(driver,timeOut);
		    if(wait.until(ExpectedConditions.titleIs(fullTitile))) {
		    	return driver.getTitle();
		      }
		    return null;
		    }

	public static Alert waitForAlert(int timeOut) {
		 WebDriverWait wait = new WebDriverWait(driver,timeOut);
		    return wait.until(ExpectedConditions.alertIsPresent());
		
    }
	public static String getAlertText(int timeOut) {
	    String text= waitForAlert(timeOut).getText();
	    acceptAlert(timeOut);
		return text;
	}
	public static void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}
	public static void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}
	public static void sendKeysOnAlert(int timeOut,String value) {
		waitForAlert(timeOut).sendKeys(value);
	}
}
