package homePage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class NewsAndEvents {
	
	WebDriver driver;

	@BeforeTest
	public void OpenBrowser() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/tarek.rahman/Documents/AutomationTestingTraining/Drivers/chromedriver");
		driver = new ChromeDriver();

		driver.get("http://mmiwbdev.pixacore.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void LogIn() throws InterruptedException, IOException {

		driver.findElement(By.id("user_login")).sendKeys("qa@pixacore.com");
		driver.findElement(By.id("user_pass")).sendKeys("Pixacore123!");
		driver.findElement(By.id("wp-submit")).click();
		
		
		
		//waiting until the element is clickable then direct driver to click
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"disclaimer-modal\"]/div/a")));
		elem.click();
		

	}
	
	@Test(priority = 2)
	public void NewsAndEvent() throws InterruptedException, IOException {

		
		List<WebElement> events = driver.findElements(By.xpath("//div[@class='news-events']/div")); 
	    System.out.println(events.size());	 
		
	    for (int i=0; i<events.size(); i++){
	    	String en= events.get(i).getText(); 
	    	System.out.println("News and Events:  " + "\n" + en + "\n");
	    }
	    
	}
	   


}






