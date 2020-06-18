package day2;






import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.*;
public class Action {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shubhanshu.sharma\\Desktop\\chromedriver_win32(3)_latest\\chromedriver.exe" );
		
		WebDriver dobj=new ChromeDriver();
		 
		
		dobj.get("https://www.amazon.in/");
		dobj.manage().window().maximize();
		
		dobj.findElement(By.id("twotabsearchtextbox")).sendKeys("face mask");//sending chars for search in the search box
		dobj.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		dobj.findElement(By.className("a-dropdown-prompt")).click();//click on sorting tab on the top right of the screen
		dobj.findElement(By.xpath("//a[@id='s-result-sort-select_1']")).click();//selecting on sort by low to high price option
		Thread.sleep(3000);//making the java code slept for 3 seconds
		dobj.findElement(By.xpath("//i[@class='a-icon a-icon-star-medium a-star-medium-4']")).click();//selecting filter of star rating above 4
		Thread.sleep(3000);//change these to wait
		dobj.findElement(By.xpath("//li[@id='p_89/3M']//i[@class='a-icon a-icon-checkbox']")).click();
		//dobj.findElement(By.xpath("	//*[text()='3M 9004 IN Foldable Dust/Pollution Particulate Respirator Mask - (White, Pack of 15)']")).click();;
		Thread.sleep(3000);
		dobj.findElement(By.xpath("//*[contains(text(),'3M 9504 ')]")).click();//here i will look for mask of my choice 
		Thread.sleep(4000);
		Set<String> multihandle=	dobj.getWindowHandles();//the mask will open in a new tab for which i will switch to that specific tab, verify the title and then add it to the cart
		int wincount=multihandle.size();
		System.out.println(wincount);
		
		ArrayList<String> alist=new ArrayList<>(multihandle);
		System.out.println(alist);
		Thread.sleep(3000);
		dobj.switchTo().window(  alist.get(1));//switching to the child tab
		dobj.findElement(By.id("add-to-cart-button")).click();  //adding to the cart
		System.out.println(dobj.getTitle()); //getting the title
		
	
	
	
		
		
	File scrshtfile=((TakesScreenshot)dobj).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrshtfile,new File("D:\\New folder\\take here\\bhayanak.jpg"));   	//saving a screen shot to verify that the item has been added to the cart :p
	//deleting cookies
	//dobj.manage().deleteAllCookies();
	 
		
		}

		}