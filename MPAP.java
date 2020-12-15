package com.specreader.automation.mpap;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MPAP {
	WebDriver driver;
	@BeforeClass
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Desktop\\chromedriver_win\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://specsqaap.pg.com/login");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("Anywheretwo.im");
		driver.findElement(By.id("password")).sendKeys("Sa061920");
		driver.findElement(By.id("loginButton")).click();
		driver.manage().timeouts().implicitlyWait(3600,TimeUnit.SECONDS);
		driver.findElement(By.id("searchBox")).sendKeys("MPAP");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/form/div/div[1]/div/button")).click();
		Thread.sleep(1000);
		if(driver.findElement(By.linkText("MPAP-00000001")).isDisplayed()) {
			driver.findElement(By.linkText("MPAP-00000001")).click();
		}
		else {
			driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[2]/div/div/div/div/table/tbody/tr[1]/td[1]/a/span")).click();
		}
		Thread.sleep(1000);
	  }
	@Test
	public void attributes() {
		System.out.println("Validation of attributes web table is in progress...");
		List<String> att=new ArrayList<String>();
		att.add("Title");
		att.add("Description");
		att.add("Type");
		att.add("Revision");
		att.add("Originated");
		att.add("Phase");
		att.add("Originator");
		att.add("Last Update User");
		att.add("Structured Release Criteria Required");
		att.add("Storage Temperature Limits - °C");
		att.add("Storage Humidity Limits - %");
		att.add("Decoration Details");
		att.add("Project Initiative MileStone");
		att.add("Expiration Date");
		att.add("Previous Revision Obsolete Date");
		att.add("Reason for CHange");
		att.add("Brand");
		att.add("Class");
		att.add("Sub-Class");
		att.add("Reported Function");
		att.add("Local Description");
		att.add("Other Names");
		att.add("Outer Dimension Width");
		att.add("Outer Dimension Depth");
		att.add("Outer Dimension Height");
		att.add("Inner Dimension Width");
		att.add("Inner Dimension Depth");
		att.add("Inner Dimension Height");
		att.add("Dimension Unit of Measure");
		att.add("Packaging Material Type");
		att.add("Packaging Size");
		att.add("Packaging Component Type");
		att.add("Packaging Technology");
		att.add("Storage Conditions");
		att.add("Comments");
		att.add("Obsolete Date");
		att.add("Obsolete comment");
		att.add("Classification");
		att.add("Shipping Information");
		att.add("Labeling Information");
		att.add("Packaging Size UoM");
		att.add("Release Date");
		att.add("Effective Date");
		att.add("owner");
		List <WebElement> ele = driver.findElements(By.id("pageheaders"));
		for(String s:att) {
			int count=0;
			for(WebElement w:ele) {
				String s1=w.getText();
				if(s.equalsIgnoreCase(s1)) {
					System.out.println(s+"is present");
					break;
				}
				else {
					count+=1;
					if(count>=ele.size()) {
						System.out.println(s+"Not in webpage");
					}
					continue;
				}
			}
		}
	}
	
	@Test
	public void notes() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Validation of notes web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("Notes")).isDisplayed()) {
				System.out.println("Notes table is Present");
				}
		}			
		catch(Exception e) {
							
			    System.out.println("Notes table is not present in the web table but it is present in the template");
			}			
	}
	@Test
	public void billOfMaterials() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of bill of materials web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("Bill of Materials")).isDisplayed()){
				
				System.out.println("Bill of material is Present");
			}	
							
		}
		catch (Exception e){
							
				System.out.println("bill of material is not present but it is present in the template");
		}
		
	}
	@Test
	public void substitutes() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of substitutes web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("Substitutes")).isDisplayed()) {
				System.out.println("substitutes table is Present");
					
			}
		}
		catch(Exception e) 
		{
				System.out.println("Substitute table is not present but it is present in the template");
		}
		
		
	}
	
	@Test
	public void relatedSpecifications() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of related specification  web table is in progress...");
		List<String> rs=new ArrayList<String>();
		rs.add("Name");
		rs.add("Title");
		rs.add("Type");
		rs.add("Revision");
		rs.add("Specification SubType");
		rs.add("State");
		rs.add("Source");
		rs.add("Description");
		rs.add("Inheritance Type");
		rs.add("Originator");
		WebElement tb=driver.findElement(By.xpath("//*[@id=\"four\"]"));
		List <WebElement> el = tb.findElements(By.tagName("th"));
		for (String s:rs) {
			int count=0;
			for (WebElement w:el) {
				String s1=w.getText();
				if(s.equalsIgnoreCase(s1)) {
					System.out.println(s+"Present");
					break;
				}
				else {
					count+=1;
					if(count>=el.size()) {
						System.out.println(s+"not present");
					}
					continue;
				}
			}
		}
	}
	
	@Test
	public void referenceDocuments() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of reference documents web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("Reference Documents")).isDisplayed()) {
				System.out.println("Reference documents table is Present");
					
			}
		}
		catch(Exception e) 
		{	
			System.out.println("Reference table is not present in the web page but it is present in the template");
		}			
					
	}
	@Test
	public void performanceCharacteristic() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of performance characteristic web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("Performance Characteristic")).isDisplayed()) {
				System.out.println("Performance Characteristic is present");
			}
		}
		catch(Exception e) {
					
			System.out.println("Performance Characteristic is not present in the webpage but it is present in the template");
		}
				
	}
	@Test
	public void lifeCyle() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Validation of Lifecycle/Approval Powerview web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("Lifecycle/Approval Powerview")).isDisplayed()) {
				System.out.println("lifecycle table is Present");
			}
		}
		catch(Exception e){		
			System.out.println("lifecycle table is not present in the web page but it is present in the template");
		}
	}
	
	@Test
	public void ownership() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Validation of ownership web table is in progress...");
		List<String> own=new ArrayList<String>();
		own.add("Originator:");
		own.add("Co-Owners:");
		own.add("Last Update User:");
		own.add("Segment:");
		own.add("Approvers:");
		own.add("Last Update Date:");
		WebElement content=driver.findElement(By.id("eight"));
		List <WebElement> el = content.findElements(By.id("pageheaders"));
		for (String s:own) {
			int count=0;
			for (WebElement w:el) {
				String s1=w.getText();
				if(s.equalsIgnoreCase(s1)) {
					System.out.println(s+"Present");
					break;
				}
				else {
					count+=1;
					if(count>=el.size()) {
						System.out.println(s+"not present");
					}
					continue;
				}
			}
		}
	}
	@Test
	public void ipclass() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Validation of ipclass web table is in progress...");
		List<String> ip=new ArrayList<String>();
		ip.add("Name");
		ip.add("Has Class Access?");
		ip.add("Type");
		ip.add("Description");
		ip.add("State");
		WebElement tab=driver.findElement(By.xpath("//*[@id=\"nine\"]"));
		List <WebElement> el = tab.findElements(By.tagName("th"));
		for (String s:ip) {
			int count=0;
			for (WebElement w:el) {
				String s1=w.getText();
				if(s.equalsIgnoreCase(s1)) {
					System.out.println(s+"Present");
					break;
				}
				else {
					count+=1;
					if(count>=el.size()) {
						System.out.println(s+"not present");
					}
					continue;
				}
			}
		}
	}
	
	@Test
	public void securityClasses() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Validation of security classes web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("Security Classes")).isDisplayed()) {
				System.out.println("Security classes web table is Present");
			}
		}
		catch(Exception e) {
				System.out.println("Security classes web table is not present in the webpage but it is present in the template");
			}
							
	}
	
	@Test
	public void organizations() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Validation of organizations web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("Organizations")).isDisplayed()) {
				System.out.println("Organizations web table is present");
			}
		}
		catch(Exception e){
			System.out.println("Organizations web table is not present in the web page but it is present in the template");
		}
				
	}
	@Test
	public void files() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of files web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("Files")).isDisplayed()) {
				System.out.println("Web table Files is present");
			}
		}
		catch(Exception e) {
			System.out.println("Web table Files is not present in the web page but it is present in the template");
		}
		
	}
}
