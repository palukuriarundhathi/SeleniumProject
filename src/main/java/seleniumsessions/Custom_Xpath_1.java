package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_Xpath_1   {

	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		//driver.get("https://demo.opencart.com/index.php?route=account/login");

		
		String xpath1="//input[@type='text' and @placeholder='First Name']";
		String xpath2="(//input[@type='text'])[2]";
		By firstname = getBy("xpath" , xpath1);
		
		
		String loginLink = "Login";
		//System.out.println(getElement(firstname));
		//getElement(firstname).sendKeys("Aruna");
	//	getElement("xpath",xpath1).sendKeys("hi");
		//System.out.println(getElement("linkText",loginLink));
		//getElement("linkText",loginLink).click();
		//System.out.println(getElement("linkText",loginLink).isDisplayed());
		doSendkeys(firstname,"aruna");
		
	}
	
	
	public static WebElement getElement(By locator) {
	  return driver.findElement(locator);
	}
	
    public static WebElement getElement(String locatortype,String locatorvalue) {
    	return driver.findElement(getBy(locatortype,locatorvalue));
	}
    public static void doSendkeys(By locator,String value) {
  	  driver.findElement(locator).sendKeys(value);
  	}
    
   public  static By getBy(String locatortype,String locatorvalue ) {
    	By locator = null;
    	switch(locatortype)
    		
    		{
    		case "id" :
    			locator = By.id(locatorvalue);
    		break;
    		case "name" :
    			locator = By.name(locatorvalue);
    		break;
    		case "className" :
    			locator = By.className(locatorvalue);
    		break;
    		case "linkText" :
    			locator = By.linkText(locatorvalue);
    		break;
    		case "partialLinkText" :
    			locator = By.partialLinkText(locatorvalue);
    		break;
    		case "xpath" :
    			locator = By.xpath(locatorvalue);
    		break;
    		case "cssSelector" :
    			locator = By.cssSelector(locatorvalue);
    		break;
    		case "tagName" :
    			locator = By.tagName(locatorvalue);
    		break;
    		default:
    			System.out.println("please pass the correct locator" +locator );
    			break;
    			 
    			
    }
    	return locator;
}  
}
