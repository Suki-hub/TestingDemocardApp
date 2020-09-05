package testingApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddingPhonesToTheCartFromTheHomePage {
	WebDriver dr;
	/*Login_page*/ 
	@Test(priority=1)
	public void open() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.ex");
		dr = new ChromeDriver();
		dr.get("https://demo.opencart.com/");
		dr.manage().window().maximize();
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
        Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("suki6@gmail.com");
		dr.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("koks@12");
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		System.out.println("=========Login successsfully=========");
	}
	/*home_page and add to card*/ 
	@Test(priority=2)
	public void addToCart() throws InterruptedException
	{
		dr.findElement(By.xpath("//*[@id=\"account-account\"]/ul/li[1]/a/i")).click();
		WebElement E=dr.findElement(By.xpath("//*[@id=\"slideshow0\"]/div/div[4]/a/img"));
		Actions act=new Actions(dr);
		act.moveToElement(E).click().build().perform();
		dr.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]/a[2]")).click();
		
	}
	/*Estimate Shipping and taxes*/
	@Test(priority=3)
	public void shippingAndTaxes() throws InterruptedException
	{
		JavascriptExecutor js=((JavascriptExecutor)dr);
		js.executeScript("scroll(0,400)");
		dr.findElement(By.xpath("//*[@id=\"accordion\"]/div[2]/div[1]/h4/a")).click();
	
		Select S1=new Select(dr.findElement(By.xpath("//*[@id=\"input-country\"]")));
		
		S1.selectByIndex(106);
		Thread.sleep(2000);
		Select S2=new Select(dr.findElement(By.xpath("//*[@id=\"input-zone\"]")));
		S2.selectByIndex(29);
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"input-postcode\"]")).sendKeys("600001");
		dr.findElement(By.xpath("//*[@id=\"button-quote\"]")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"modal-shipping\"]/div/div/div[2]/div/label/input")).click();
		
		dr.findElement(By.xpath("//*[@id=\"button-shipping\"]")).click();
		Thread.sleep(2000);
		
		
	}
	/*Coupon code*/
	@Test(priority=4)
	public void couponCode()
	{
		JavascriptExecutor js=((JavascriptExecutor)dr);
		js.executeScript("scroll(0,400)");
		dr.findElement(By.xpath("//*[@id=\"accordion\"]/div[1]/div[1]/h4/a")).click();
		dr.findElement(By.xpath("//*[@id=\"input-coupon\"]")).sendKeys("6");
		dr.findElement(By.xpath("//*[@id=\"button-coupon\"]")).click();
	}
	/*Logout*/
	@Test(priority=5)
	public void logout() {
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
		dr.quit();
	}

	

}
