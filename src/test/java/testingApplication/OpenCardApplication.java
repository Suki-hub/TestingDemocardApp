package testingApplication;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class OpenCardApplication {
	WebDriver dr;
	/*Step-1*/
	@Test(priority=1)
	public void open() {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.get("https://demo.opencart.com/");
		dr.manage().window().maximize();
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
	    dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		}
	/*Step-2*/
	@Test(priority=2)
	public void register() {
		dr.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("Sukiii");
		dr.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys("M");
	    dr.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("suki6@gmail.com");
	    dr.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys("8563738838");
		dr.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("koks@12");
	    dr.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys("koks@12");
	    dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		System.out.println("======Account has been created========");
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
}
	/*Step-3*/
	@Test(priority=3)
	public void contact() throws InterruptedException {
        JavascriptExecutor js=((JavascriptExecutor)dr);
		
		js.executeScript("scroll(0,400)");
		
	
		
		dr.findElement(By.xpath("/html/body/footer/div/div/div[2]/ul/li[1]/a")).click();
		
		
		dr.findElement(By.xpath("//*[@id=\"input-enquiry\"]")).sendKeys("I need to change my registered phone number,While i am changing the phone number i can't able to do it ,it keep on showing my older number.I can't able to track the location of ordered product .Kindly update my number from 8131512976 to 9865444671"); 
	
		dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input")).click();
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		
	}
	/*Step-4*/
	@Test(priority=4)
	public void samsungGalaxy() throws InterruptedException
	{
		Thread.sleep(2000);
		Actions act=new Actions(dr);
		
		WebElement img=dr.findElement(By.xpath("//*[@id=\"slideshow0\"]/div/div[4]/a/img"));
		act.moveToElement(img).click().perform();
		
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul[2]/li[2]/a")).click();
		dr.findElement(By.xpath("//*[@id=\"input-review\"]")).sendKeys("Best camera, battery life is good,beautiful look! ,Display is excellent,performance is good,mobile speaker sound is good.\r\n");
			Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"form-review\"]/div[4]/div/input[4]")).click();
		dr.findElement(By.xpath("//*[@id=\"button-review\"]")).click();
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[1]/i")).click();
		Thread.sleep(3000);
		dr.findElement(By.cssSelector("#product-product > div.alert.alert-success.alert-dismissible > button")).click();
				
	}
	/*Step-5*/
	@Test(priority=5)
	public void wishList() throws IOException, InterruptedException {
		dr.findElement(By.xpath("//*[@id=\"wishlist-total\"]/span")).click();
		dr.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/i")).click();
		dr.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[2]/button")).click();
		String Pound_sterling=dr.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[5]")).getText(); 
	
		
		
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/i")).click();
		dr.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]/button")).click();
		String Euro=dr.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[5]")).getText(); 

	
		
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/i")).click();
		dr.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[3]/button")).click();
		
		String US_Dollar=dr.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[5]")).getText(); 
        FileWriter Writer=new FileWriter("C:\\Users\\ELCOT\\Downloads\\OpenCardApp.csv",       false);
		
		Writer.append(Pound_sterling);
		Writer.append(',');
		Writer.append(Euro);
		Writer.append(',');
		
		Writer.append(US_Dollar);
		Writer.close();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/button")).click();
		Thread.sleep(3000);
		dr.findElement(By.cssSelector("#account-wishlist > div.alert.alert-success.alert-dismissible > button")).click();
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a")).click();
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();

	}
	/*Step-6*/
	@Test(priority=6)
	public void logout() {
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
		dr.close();
	}
}
		
		
		

		
				


		
	
		
		
		
	

	
	
	
	
	

