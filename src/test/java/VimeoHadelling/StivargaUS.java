package VimeoHadelling;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StivargaUS {

	WebDriver driver;

	@BeforeTest
	public void OpenBrowser() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/tarek.rahman/Documents/AutomationTestingTraining/Drivers/chromedriver");
		driver = new ChromeDriver();

		driver.get("http://www.stivarga-us.com/what-is-stivarga/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void WhatIsSvUS() throws InterruptedException, IOException {

		List<WebElement> Vframe = driver.findElements(By.tagName("iframe"));
		System.out.println("number of iframes are :" + Vframe.size());

		for (WebElement ele : Vframe) {
			System.out.println(ele.getAttribute("src"));

			{

				if (ele.getAttribute("src").equals("https://player.vimeo.com/video/301506824")) {

					driver.switchTo().frame(0).findElement(By.xpath("/html/body/div/div[7]/div[3]/button")).click();

				} else
					System.out.println("video link is wrong");
			}
			
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"player\"]/div[7]/div[3]/button/div[3]")).click();
		}

	}

	@Test(priority = 2)
	public void Maria() throws InterruptedException, IOException {
		
		Actions ac = new Actions(driver); 
		
		ac.moveToElement(driver.findElement(By.xpath("/body/nav[@id='top-navbar']/div[@class='top-navbar-mega locked']/div[@class='navbar-container']/div[6]/a[1]"))).build().perform();

	}
}
