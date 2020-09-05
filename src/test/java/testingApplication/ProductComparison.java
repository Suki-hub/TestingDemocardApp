package testingApplication;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class ProductComparison {
	WebDriver dr;
	
	/*Step1*/
	@Test(priority=1)
	public void open() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
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
	/*Step2*/
	@Test(priority=2)
	public void search() {
	
	dr.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[6]/a")).click();
	Select s=new Select(dr.findElement(By.xpath("//*[@id=\"input-sort\"]")));
    s.selectByIndex(4);			
	
	}
	/*Step3*/
	@Test(priority=3)
	public void productCompare() throws InterruptedException, IOException
	{
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/div[2]/button[3]")).click();
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/div[2]/button[3]")).click();
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[3]/div/div[2]/div[2]/button[3]")).click();
		dr.findElement(By.xpath("//*[@id=\"compare-total\"]")).click();
		dr.findElement(By.xpath("//*[@id=\"content\"]/table/tbody[1]/tr[1]/td[2]/a/strong")).click();
		String feature =dr.findElement(By.xpath("//*[@id=\"tab-description\"]/ul/li[5]")).getText();
	    System.out.println(feature);
	    
	    FileWriter Writer=new FileWriter("C:\\\\Users\\\\ELCOT\\\\Downloads\\\\ProductComparison.csv",false);
	   Writer.append(feature);
	   Writer.close();
	    dr.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
	    Thread.sleep(2000);
	    dr.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]/a[2]")).click();
	    File Source = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(Source, new File("./ScreenShot/Product_Compare.png"));
		dr.quit();
	}
	
	
}
