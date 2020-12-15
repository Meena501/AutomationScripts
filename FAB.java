package com.specreader.automation.fab;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FAB {
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
		driver.findElement(By.id("searchBox")).sendKeys("91672665"); //object id of FAB
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/form/div/div[1]/div/button")).click();
		Thread.sleep(1000);
		if(driver.findElement(By.linkText("91672665")).isDisplayed())
		{
				driver.findElement(By.linkText("91672665")).click();
		}
		else 
		{
			driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[2]/div/div/div/div/table/tbody/tr/td[1]/a/span")).click();
		}
		Thread.sleep(1000);
	  }
	
	@Test
	public void attribute() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Validation of attributes web table is in progress...");
		List<String> att=new ArrayList<String>();
		att.add("Title");
		att.add("Description");
		att.add("Type");
		att.add("Revision");
		att.add("Originated");
		att.add("Structured Release Criteria Required");
		att.add("Legacy Environmental Class");
		att.add("Phase");
		att.add("Originator");
		att.add("Last Update User");
		att.add("Segment");
		att.add("Reported Function");
		att.add("Expiration Date");
		att.add("Previous Revision Obsolete Date");
		att.add("Reason for Change");
		att.add("Base Unit of Measure");
		att.add("Local Description");
		att.add("Other Names");
		att.add("Packaging Size");
		att.add("Packaging Technology");
		att.add("Storage Conditions");
		att.add("Comments");
		att.add("Obsolete Date");
		att.add("Obsolete comment");
		att.add("Shipping Information");
		att.add("Labeling Information");
		att.add("Packaging Size UoM");
		att.add("Release Date");
		att.add("Effective Date");
		att.add("owner");
		att.add("Storage Temperature Limits - °C");
		att.add("Storage Humidity Limits - %");
		att.add("Battery Type");
		att.add("Class");
		att.add("Sub Class");
		att.add("SAP BOM Base QTY");
		att.add("Manufacturing Status");
		att.add("Brand");
		att.add("Power Source");
		att.add("Base Quantity");
		att.add("Expand BOM on SAP BOM as Fed");
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
	public void weightCharacteristics() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Validation of weight characteristics web table is in progress...");
		List<String> weight=new ArrayList<String>();
		weight.add("Name");
		weight.add("Type");
		weight.add("Gross Weight");
		weight.add("Weight UoM");
		weight.add("Comments");
		WebElement content=driver.findElement(By.id("one"));
		List <WebElement> el = content.findElements(By.tagName("th"));
		for (String s:weight) {
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
	public void notes() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of notes web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("Notes")).isDisplayed()) {
				System.out.println("Web table Notes is present");
				}
		}
		catch(Exception e) {
			System.out.println("Web table Notes is not present in the web page but present in the template");
		}
	}
	@Test 
	public void sapBomfed() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Validation of Sap Bom as Fed web table is in progress...");
		List<String> sap=new ArrayList<String>();
		sap.add("Name");
		sap.add("SAP Description");
		sap.add("Type");
		sap.add("Specification SubType");
		sap.add("SAP Type");
		sap.add("Substitute/ Alternate Grouping");
		sap.add("BOM Quantity(BQ)");
		sap.add("Base Unit of Measure(BUoM)");
		sap.add("Authorized(A) Authorized To Use(AU)");
		sap.add("Authorized To Produce(AP) Optional Component (OC)");
		sap.add("Transport Unit(TU) Comments(C)");
		sap.add("BQ");
		sap.add("BUoM");
		sap.add("A");
		sap.add("AU");
		sap.add("AP");
		sap.add("OC");
		sap.add("TU");
		sap.add("C");
		List<String>sap1=new ArrayList<String>();
		WebElement table=driver.findElement(By.id("three")); 
		List <WebElement> rows=table.findElements(By.tagName("tr"));   
		List <WebElement> cols=rows.get(1).findElements(By.tagName("th"));
		for (WebElement col:cols) {
			String ss=col.getText();
			sap1.add(ss);
		}
		List<String> b=new ArrayList<String>();
		WebElement table2=driver.findElement(By.xpath("//*[@id=\"three\"]/div/div/table/tbody"));
		List <WebElement> rows2=table2.findElements(By.tagName("tr"));
		List <WebElement> cols2=rows2.get(0).findElements(By.className("bomFontClass"));
		for(WebElement col:cols2) {
			String ss=col.getText();
			b.add(ss);
		}
		for(String s:b) {
			for(String ss:s.split(":")) {
				sap1.add(ss);
			}
		}
		for(String s:sap) {
			int count=0;
			for(String s1:sap1) {
				if(s.equalsIgnoreCase(s1)) {
					System.out.println(s+"is present");
					break;
				}
				else {
					count+=1;
					if(count>=sap1.size()) {
						System.out.println(s+" not present");
					}
					continue;
				}
			}
		}
		
	}
	
	@Test
	public void marketOfSale() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of Market of Sale web table is in progress...");
		List<String> mar=new ArrayList<String>();
		//mar.add("Date and Time of Last Market of Sale Calculation:");
		//mar.add("Please note that changes which have occurred after this calculation Date and Time are NOT reflected in the table below");
		mar.add("Market of Sale");
		mar.add("Market of Sale Restrictions?");
		List<String>val = new ArrayList<String>();
		WebElement content=driver.findElement(By.id("four"));
		List <WebElement> rows = content.findElements(By.tagName("tr"));
		int rsize=rows.size();
		for(int i=0;i<rsize;i++) {
			List<WebElement> cols= rows.get(i).findElements(By.tagName("th"));
			for(WebElement c:cols) {
				String sc=c.getText();
				val.add(sc);
			}
		}
		for (String s:mar) {
			int count=0;
			for (String w:val) {
			
				if(s.equalsIgnoreCase(w)) {
					System.out.println(s+" is Present");
					break;
				}
				else {
					count+=1;
					if(count>=val.size()) {
						System.out.println(s+"not present");
					}
					continue;
				}
			}
		 
		}
		
	}
	
	@Test
	public void billOfMaterials() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of bill of material web table is in progress...");
		List<String> bill=new ArrayList<String>();
		bill.add("Name(N) Rev(R)");
		bill.add("Chg");
		bill.add("F/N");
		
		bill.add("Title");
		bill.add("Type");
		bill.add("Substitute Parts(SP) Alternate(Alt)");
		bill.add("Quantity(Qty) Base UofM(UoM)");
		bill.add("Net(N) Loss(L) Net Weight(NW) Weight UoM(UoM) ");
		bill.add("Function");
		bill.add("EBOM Comments");
		bill.add("Phase(Pha) State(St)");
		
		bill.add("Ref Des");
		bill.add("On-Shelf Product Density(OSPD) Density Unit Of Measure(DUoM) Optional Components(OC)");
		bill.add("N");
		bill.add("R");
		bill.add("SP");
		bill.add("Alt");
		bill.add("Qty");
		bill.add("UoM");
		bill.add("N");
		bill.add("L");
		bill.add("NW");
		bill.add("UoM");
		bill.add("Pha");
		bill.add("St");
		bill.add("OSPD");
		bill.add("DUoM");
		bill.add("OC");

		List<String>bill1=new ArrayList<String>();
		WebElement table=driver.findElement(By.id("six"));
		List <WebElement> rows=table.findElements(By.tagName("tr"));
		List <WebElement> cols=rows.get(0).findElements(By.tagName("th"));
		for (WebElement col:cols) {
			String ss=col.getText();
			bill1.add(ss);
		}
		List<String> b=new ArrayList<String>();
		WebElement table2=driver.findElement(By.xpath("//*[@id=\"six\"]/div/div/table/tbody"));
		List <WebElement> rows2=table2.findElements(By.tagName("tr"));
		List <WebElement> cols2=rows2.get(0).findElements(By.className("bomFontClass"));
		for(WebElement col:cols2) {
			String ss=col.getText();
			b.add(ss);
		}
		for(String s:b) {
			for(String ss:s.split(":")) {
				bill1.add(ss);
			}
		}
		for(String s:bill) {
			int count=0;
			for(String s1:bill1) {
				if(s.equalsIgnoreCase(s1)) {
					System.out.println(s+"is present");
					break;
				}
				else {
					count+=1;
					if(count>=bill1.size()) {
						System.out.println(s+" not present");
					}
					continue;
				}
			}
		}
	}
	
	
	@Test
	public void relatedSpecification() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Validation of related specification web table is in progress...");
		List<String> rel=new ArrayList<String>();
		rel.add("Name");
		rel.add("Title");
		rel.add("Source");
		rel.add("Type");
		rel.add("Specification SubType");
		rel.add("State");
		rel.add("Originator");
		rel.add("Revision");
		rel.add("Description");
		WebElement table=driver.findElement(By.id("eight"));
		List<WebElement> content=table.findElements(By.tagName("th"));
		for (String s:rel) {
			int count=0;
			for (WebElement w:content) {
				String s1=w.getText();
				if(s.equalsIgnoreCase(s1)) {
					System.out.println(s+"Present");
					break;
				}
				else {
					count+=1;
					if(count>=content.size()) {
						System.out.println(s+"not present");
					}
					continue;
				}
			}
		 
		}
		
		
	}
	@Test
	public void plants() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of plants web table is in progress...");
		List<String> plant=new ArrayList<String>();
		plant.add("Plants");
		plant.add("Plants Authorized To Use");
		plant.add("Plants Authorized to Produce");
		plant.add("Activated");
		
		WebElement content=driver.findElement(By.id("twelve"));
		List <WebElement> el = content.findElements(By.tagName("th"));
		for (String s:plant) {  
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
	public void lifeCycle() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Validation of Lifecycle web table is in progress...");
		List<String> life=new ArrayList<String>();
		life.add("Tasks/Signatures");
		life.add("Name");
		life.add("Approver");
		life.add("Title");
		life.add("Approval Status");
		life.add("Approval/Due Date");
		life.add("Comments/Instructions");
		List<String>val=new ArrayList<String>();
		WebElement table=driver.findElement(By.id("fifteen"));
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		int rsize=rows.size(); 
		for(int i=0;i<rsize;i++) {
			List<WebElement> cols= rows.get(i).findElements(By.tagName("th"));
			for(WebElement c:cols) {
				String sc=c.getText();
				val.add(sc);
			}
		}
		for(String s:life) {						
			int count=0;						
			for(String w:val) {
				
				if(s.equalsIgnoreCase(w)) {
					System.out.println(s+"Present");
					break;
				}
				else {
					count+=1;
					if(count>=val.size()) {
						System.out.println(s+"not present");
					}
					continue;
				}
			}
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
		WebElement content=driver.findElement(By.id("sixteen"));
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
		WebElement tab=driver.findElement(By.id("seventeen"));
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
	public void organizations() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Validation of organizations web table is in progress...");
		List<String> org=new ArrayList<String>();
		org.add("Primary Organization:");
		org.add("Secondary Organization:");
		WebElement table=driver.findElement(By.id("twenty"));
		List<WebElement> l=table.findElements(By.id("pageheaders"));
		for(String s:org) {
			int count=0;
			for(WebElement w:l) {
				String s1=w.getText();
				if(s.equalsIgnoreCase(s1)) {
					System.out.println(s+"Present");
					break;
				}
				else {
					count+=1;
					if(count>=l.size()) {
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
	public void files() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of Files web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("Files")).isDisplayed()) {
				System.out.println("Web table Files is present");
			}
		}
		catch(Exception e) {
			System.out.println("Web table Files is not present in the web page but present in the template");
		}
		
	}
	@Test
	public void relatedATS() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of Related ATS web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("Related ATS")).isDisplayed()) {
				System.out.println("Web table Related ATS is present");
			}
		}
		
		catch(Exception e) {
			System.out.println("Web table Related ATS is not present in the web page but present in the template");
		}
		
	}
	@Test
	public void referenceDocuments() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of reference documents web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("Reference Documents")).isDisplayed()) {
				System.out.println("Web table Reference Documents is present");
			}
		}
		catch(Exception e) {
			System.out.println("Web table Reference Documents is not present in the web page but present in the template");
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
	public void masterSpecification() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of master specification web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("Master Specifications")).isDisplayed()) {
				System.out.println("Web table Master Specifications is present");
			}
		}
		catch(Exception e){
			System.out.println("Web table Master Specifications is not present in the web page but present in the template");
		}
		
	}
	@Test
	public void substancesMaterials(){
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of Substances & Materials web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("Substances & Materials")).isDisplayed()) {
				System.out.println("Web table Substances & Materials is present");
			}
		}
		catch(Exception e){
			System.out.println("Web table Substances & Materials is not present in the web page but present in the template");
		}
		
	}
	@Test
	public void pqrViewManufacturer() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of PQR View - Manufacturer Equivalents web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("PQR View - Manufacturer Equivalents")).isDisplayed()) {
				System.out.println("Web table PQR View - Manufacturer Equivalents is present");
			}
		}
		catch(Exception e){
			System.out.println("Web table PQR View - Manufacturer Equivalents is not present in the web page but present in the template");
		}
		
	}
	@Test
	public void pqrViewSupplier() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of PQR View - Supplier Equivalents web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("PQR View - Supplier Equivalents")).isDisplayed()) {
				System.out.println("Web table PQR View - Supplier Equivalents is present");
			}
		}
		catch(Exception e){
			System.out.println("Web table PQR View - Supplier Equivalents is not present in the web page but present in the template");
		}
		
	}
	

}
