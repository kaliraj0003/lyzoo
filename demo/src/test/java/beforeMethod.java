import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class beforeMethod {
	static WebDriver d;
  @Test(priority = 0)
  public void ToCheckLoginToGiveValidInputs() throws InterruptedException {
	  String mail1="thomasraj@gmail.com";
	  String pass="thomas@12";
	  d.findElement(By.name("email")).sendKeys(mail1);
	  d.findElement(By.name("password")).sendKeys(pass);
	  boolean b=d.findElement(By.xpath("//input[@type='checkbox']")).isSelected();
	  if(b==false) {
		  d.findElement(By.xpath("//label")).click();
	  }
	  else {
		  System.out.println("Already Checked");
	  }
	  d.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(2000);
	  String mail=d.findElement(By.xpath("//div//p[@class]")).getText();
	  
	  if(mail==mail1) {
		  System.out.println("Login Successful");
	  }
	  
	  
	  
  }
  @Test(priority = 1)
  public  void ToCheckLoginToGiveInValidInputs() throws InterruptedException{
	  String mail1="thomasraj@gmail.com";
	  String pass="thomas@123";
	  String err="Invalid email or password";
	  d.findElement(By.name("email")).sendKeys(mail1);
	  d.findElement(By.name("password")).sendKeys(pass);
	  boolean b=d.findElement(By.xpath("//input[@type='checkbox']")).isSelected();
	  if(b==false) {
		  d.findElement(By.xpath("//label")).click();
	  }
	  else {
		  System.out.println("Already Checked");
	  }
	  d.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(2000);
	 String s=d.findElement(By.xpath("//h2")).getText();
	 
	 if(s==err) {
		 System.out.println("User entered worng input ");
	 }
	 
	  
  }
  
  @Test
public void ToVerifyInputTypesEnterCorrectly() {
	  String mail1="thomasraj@gmail.com";
	  String pass="thomas@12";
	  d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  d.findElement(By.name("email")).sendKeys(mail1);
	  d.findElement(By.name("password")).sendKeys(pass);
	  boolean b=d.findElement(By.xpath("//input[@type='checkbox']")).isSelected();
	  if(b==false) {
		  d.findElement(By.xpath("//label")).click();
	  }
	  else {
		  System.out.println("Already Checked");
	  }
	  d.findElement(By.xpath("//button[@type='submit']")).click();
	  if(d.findElement(By.xpath("//div//p[@class]")).isDisplayed()) {
		  System.out.println("ALready visible");
	  }
	  else {
		  d.findElement(By.xpath("//i[@class='icon-Menu']")).click();
	  }
	  
	  
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  d=new ChromeDriver();
	  d.get("https://www.e2wstudy.lyzooapp.co.in/");
	  d.manage().window().maximize();
  }
  

  @AfterMethod
  public void afterMethod() {
	  d.quit();
  }

}
