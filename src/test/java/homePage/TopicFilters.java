package homePage;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TopicFilters {

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
		Thread.sleep(1000);

		System.out.println("LogIn Successful  " + driver.getCurrentUrl());

		driver.findElement(By.xpath("//*[@id=\"disclaimer-modal\"]/div/a")).click();

	}

	@Test(priority = 2)
	public void topic() throws InterruptedException, IOException {

		driver.findElement(By.id("menu-item-18")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[contains(text(),'Topic')]")).click();

	}

	@Test(priority = 3)
	public void topicFilters() throws InterruptedException, IOException {

		List<WebElement> tf = driver.findElements(By.xpath("//ul//li[1]//ul[1]/li"));
		System.out.println("Number of Presentations...............  " + tf.size());

		for (int i = 0; i < tf.size(); i++) {
			System.out.println("topic filter is " + tf.get(i).getText());
			
	
		}
		
	}
		
		@Test(priority =4)
		public void Select_Topic() throws InterruptedException, IOException {
			
			driver.findElement(By.xpath("//label[@for='63']")).click();
			Thread.sleep(1000);
			String content = driver.findElement(By.xpath("//div[@class='initiative test']//div[@class='content']")).getText(); 
			System.out.println("\n\n" + "Initiative under topic:   " + "\n" + content + "\n");
		
		}
		}
		
