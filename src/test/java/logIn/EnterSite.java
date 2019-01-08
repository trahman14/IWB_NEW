package logIn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EnterSite {

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

	}

	@Test(priority = 2)
	public void accept() throws InterruptedException, IOException {

		String popUp = driver.findElement(By.xpath("//*[@id=\"disclaimer-modal\"]/div")).getText();

		System.out.println(popUp);

		if (popUp.contentEquals("FOR CELGENE INTERNAL USE ONLY\n"
				+ "Every region/function should follow its standard processes to ensure compliance in deriving tactics that are consumer facing. Some of the documents, such as journal publications and posters available on this portal, could contain proprietary information protected by copyrights. Except as expressly authorized by Celgene or relevant third parties, you agree not to modify, rent, lease, loan, sell, distribute, or create derivative works based on these materials in whole or in part.\n"
				+ "By clicking 'OK', I acknowledge that I have read and understood the above.\n" + "OK")) {

			System.out.println("is Displayed");
		}

		else {
			System.out.println("Not Displayed");
		}

		driver.findElement(By.xpath("//*[@id=\"disclaimer-modal\"]/div/a")).click();

	}

	@Test(priority = 3)
	public void initiatives() throws InterruptedException, IOException {
		
		driver.findElement(By.id("menu-item-18")).click();
		Thread.sleep(1000);
        
		List<WebElement> ls = driver.findElements(By.xpath("/html/body/div[1]/div[2]/div")); 
		System.out.println("Number of Presentations...............  "+ ls.size());
		
		for(int i=0; i<ls.size(); i++) {
			System.out.println("Presentations " + "\n" +ls.get(i).getText()+ "\n"); 
			
		}
			
		}

		@Test(priority = 4)
		public void Download_Presentaions() throws InterruptedException, IOException {
			
			Thread.sleep(1000);
	        
			List<WebElement> ps = driver.findElements(By.xpath("//div[@class='initiatives']//div[@class='media']/a")); 
			//div[@class='initiatives']//div[2]//div[3]//a[1]//div[1]//div[2]
			
			System.out.println("Download Presentations...............  "+ ps.size());
			
			
			for(int i=0; i<ps.size(); i++) {
				
				System.out.println(ps.get(i).getText());
			
				
				ps.get(i).click();

				
				String mainWindow= driver.getWindowHandle();


				Set<String>childWindow= driver.getWindowHandles();
				for(String child:childWindow) {
					driver.switchTo().window(child);
				
				}
				 
			System.out.println(driver.getCurrentUrl());
			driver.switchTo().window(mainWindow);

			
				 } 

		
		
			}
		
		
		
	@AfterTest
	public void tearDown() {
		// driver.close();

	}

}
