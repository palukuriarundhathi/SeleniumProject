import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class NewTest {
  public static WebDriver driver;
  @Test
  public void a() {
	  System.out.println("This is Test  A Method");
		driver.findElement(By.xpath("//a[@href='/locked/company-search']//button[@class='btn-sm btn-primary rightBoxButton'][normalize-space()='Go']")).click();

	  
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is Before Class Method");
	  
	  WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	  driver.get("https://toolkit-api-stg.dnb.com/");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is After Class Method");
	  driver.close();
  }

}
