package seleniumsessions;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MAUILoginPage {

	public  static void main(String args[]) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://toolkit-api-stg.dnb.com/");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@href='/locked/company-search']//button[@class='btn-sm btn-primary rightBoxButton'][normalize-space()='Go']")).click();
		//String CurrentWindow=driver.getWindowHandle();
		//driver.switchTo().window(CurrentWindow);
	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    System.out.println(driver.getCurrentUrl());
	    driver.switchTo().window(tabs2.get(1));
	    System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-invalid ng-touched']")).sendKeys("testeml");
		//driver.findElement(By.className("form-control ng-pristine ng-invalid ng-touched")).sendKeys("testeml");
		driver.findElement(By.xpath("/html[1]/body[1]/app[1]/maui-layout[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ng-component[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys("testeml");
		//driver.quit();
	}
}
