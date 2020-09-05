package testingApplication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;

public class GiftVoucher {
	WebDriver dr;
	String File_Path="C:\\\\Users\\\\ELCOT\\\\Downloads\\\\Giftvoucher.csv";
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
		dr.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("suki4@gmail.com");
		dr.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("koks@12");
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		System.out.println("=========Login successsfully=========");
	}
	/*Step2*/
	@Test(priority=2)
	public void giftVoucher() throws IOException, InterruptedException
	{
		JavascriptExecutor js=((JavascriptExecutor)dr);
		js.executeScript("scroll(0,400)");
		dr.findElement(By.xpath("/html/body/footer/div/div/div[3]/ul/li[2]/a")).click();
		CSVReader Reader=new CSVReader(new FileReader(File_Path));
		String[] cell;
		
		while((cell=Reader.readNext())!=null)
		{
			String R_name =cell[0];
		String Recipient_email =cell[1];
		String Message =cell[2];
		
		dr.findElement(By.xpath("//*[@id=\"input-to-name\"]")).sendKeys(R_name);
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"input-to-email\"]")).sendKeys(Recipient_email);
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"input-message\"]")).sendKeys( Message);
		Thread.sleep(2000);
		}
		
		dr.findElement(By.xpath("//*[@id=\"content\"]/form/div[5]/div/div[1]/label/input")).click();
		
		dr.findElement(By.xpath("//*[@id=\"content\"]/form/div[8]/div/input[1]")).click();
		dr.findElement(By.xpath("//*[@id=\"content\"]/form/div[8]/div/input[2]")).click();
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		
		Thread.sleep(2000);
		
		/*dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr[1]/td[4]/div/span/button[2]")).click();
		Thread.sleep(2000);
		dr.findElement(By.cssSelector("#content > form > div > table > tbody > tr:nth-child(1) > td:nth-child(4) > div > span > button.btn.btn-danger")).click();
		Thread.sleep(2000);*/
		dr.findElement(By.cssSelector("#content > form > div > table > tbody > tr > td:nth-child(4) > div > span > button")).click();
		Thread.sleep(3000);
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		
	  
	}
	/*step-4*/
	@Test(priority=3)
	public void contact() throws InterruptedException {
        JavascriptExecutor js=((JavascriptExecutor)dr);
		
		js.executeScript("scroll(0,400)");
		
	
		
		dr.findElement(By.xpath("/html/body/footer/div/div/div[2]/ul/li[1]/a")).click();
		
		
		dr.findElement(By.xpath("//*[@id=\"input-enquiry\"]")).sendKeys("I need to change my registered phone number,While i am changing the phone number i can't able to do it ,it keep on showing my older number.I can't able to track the location of ordered product .Kindly update  my  number from 8131512976 to 9865444671"); 
	
		dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input")).click();
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
	}
	/*step-5*/
	@Test(priority=4)
	public void wishList() throws IOException, InterruptedException
	{
		JavascriptExecutor js=((JavascriptExecutor)dr);
		js.executeScript("scroll(0,400)");
		
		dr.findElement(By.xpath("/html/body/footer/div/div/div[4]/ul/li[3]/a")).click();
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		
		
		dr.findElement(By.xpath("//*[@id=\"content\"]/ul[1]/li[1]/a")).click();
		dr.findElement(By.xpath("//*[@id=\"input-telephone\"]")).clear();
		CSVReader Reader=new CSVReader(new FileReader(File_Path));
		String[] cell;
		while((cell=Reader.readNext())!=null)
		{
			Thread.sleep(2000);
		String Changed_num=cell[3];
		dr.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys(Changed_num);
		}
		dr.findElement(By.cssSelector("#content > form > div > div.pull-right > input")).click();
	}
	/*Step-6-logout*/
	@Test(priority=5)
	public void logout() {
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
		dr.quit();
	}
	
}
	


