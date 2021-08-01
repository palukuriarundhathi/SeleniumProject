package seleniumsessions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DITLoginPage_bkp {

	 static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
		
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://toolkit-api-stg.dnb.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='/locked/company-search']/button")).click();
		Thread.sleep(3000);
		ArrayList<String>  al = new ArrayList<String> (driver.getWindowHandles());
		
		driver.switchTo().window(al.get(1));
		System.out.println(driver.getCurrentUrl());
			
		driver.findElement(By.xpath("//input[@type='text' and @formcontrolname='username']")).sendKeys("testeml");
		driver.findElement(By.xpath("//input[@type='password' and @formcontrolname='password']")).sendKeys("testeml");
		driver.findElement(By.xpath("//button[@class='btn btn-primary' and  contains(text(),'Log In')]")).click();
		Thread.sleep(3000);
		//System.out.println(al.size());
//		String currentwindowhandler = driver.getWindowHandle();
//	    driver.switchTo().window(currentwindowhandler);
//    	System.out.println(driver.getCurrentUrl());
//    	
    	   	
    	By username =By.xpath("//input[@type='text' and @formcontrolname='username']");
       	WebElement username_ele =waitForElementPresence(10,username);
    	username_ele.sendKeys("vari@gmail.com");
    	
    	By password = By.xpath("//input[@type='password' and @formcontrolname='password']");
    	WebElement password_ele =waitForElementPresence(10,password);
    	password_ele.sendKeys("varivari");
    	
    	By confirmpassword = By.xpath("//input[@type='password' and @formcontrolname='confirmPassword']");
    	WebElement confirmpassword_ele =waitForElementPresence(10,confirmpassword);
    	confirmpassword_ele.sendKeys("varivari");
    	
    	By submitBtn = By.xpath("//button[@class='btn btn-primary' and contains(text(),'Submit')]");
    	WebElement submitBtn_ele =waitForElementPresence(10,submitBtn);
    	submitBtn_ele.click();
    	
    	
    	if(submitBtn_ele.isDisplayed()) {
    	System.out.println("Displayed");
    	}
    	
    	
    	//======================= enter User Profile page  =================
    	
//    	String currentwindowhandler1 = driver.getWindowHandle();
//	    driver.switchTo().window(currentwindowhandler1);
    	System.out.println(driver.getCurrentUrl());
    	
    	//By firstname = By.id("firstname");
    	By firstname = By.xpath("/html[1]/body[1]/app[1]/maui-layout[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ng-component[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]");
       	WebElement firstname_ele =waitForElementPresence(10,firstname);
       	firstname_ele.sendKeys("pavan");
       	
       	By lastname = getBy("xpath","//input[@type='text'  and @formcontrolname='lastName']");
       	WebElement lastname_ele =waitForElementPresence(10,lastname);
       	lastname_ele.sendKeys("kumar");
       	
       	
       	
       	By country =  By.id("country");
       	doSelectByValue(country,"INDIA");
       //	selectDropDownValue(country,"INDIA");
       	
    	By language =  By.id("language");
    	doSelectByValue(country,"English");
       //	selectDropDownValue(language,"English");
       	
       	By hintQuestion =  By.id("hintQuestion");
       	doSelectByIndex(hintQuestion,2);
       	
     	By hintAnswer = getBy("xpath","//input[@type='text'  and @formcontrolname='lastName']");
    	WebElement hintAnswer_ele =waitForElementPresence(10,hintAnswer);
    	hintAnswer_ele.sendKeys("White");
    	
    	By submitButton = By.xpath("//button[@class='btn btn-primary' and contains(text(),'Submit')]");
    	WebElement submitButton_ele =waitForElementPresence(10,submitButton);
    	submitButton_ele.click();
       	
    	
		//driver.findElement(By.xpath("//input[@type='text' and @formcontrolname='username']")).sendKeys("akhil@gmail.com");
        //	driver.findElement(By.xpath("//input[@type='password' and @formcontrolname='password']")).sendKeys("babybaby");
		//driver.findElement(By.xpath("//input[@type='password' and @formcontrolname='confirmPassword']")).sendKeys("babybaby");		
		//driver.findElement(By.xpath("//button[@class='btn btn-primary' and contains(text(),'Submit')]")).click();
		
		 //   driver.quit();
		
	}
	public static void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public static void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	public static void waitForFrameAndSwitchToIt(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mainpanel"));

}
	public static WebElement waitForElementPresence(int timeout,By locator) {
		 WebDriverWait wait = new  WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator)) ;
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static  void selectDropDownValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());                     

		for (WebElement e : optionsList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}
		
		public static  By getBy(String locatorType, String locatorValue) {
			By locator = null;
			switch (locatorType) {
			case "id":
				locator = By.id(locatorValue);
				break;

			case "name":
				locator = By.name(locatorValue);
				break;

			case "className":
				locator = By.className(locatorValue);
				break;

			case "linkText":
				locator = By.linkText(locatorValue);
				break;

			case "partialLinkText":
				locator = By.partialLinkText(locatorValue);
				break;

			case "xpath":
				locator = By.xpath(locatorValue);
				break;

			case "cssSelector":
				locator = By.cssSelector(locatorValue);
				break;

			case "tagName":
				locator = By.tagName(locatorValue);
				break;

			default:
				System.out.println("Please pass the correct locator " + locatorType);
				break;
			}

			return locator;
		}

}
