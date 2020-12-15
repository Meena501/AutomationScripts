package com.specreader.automation.pap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PAP {
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
		driver.findElement(By.id("searchBox")).sendKeys("91697550");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/form/div/div[1]/div/button")).click();
		Thread.sleep(1000);
		if(driver.findElement(By.linkText("91697550")).isDisplayed()) {
			driver.findElement(By.linkText("91697550")).click();
		}
		else {
			System.out.println("Object is not present in the web page");
		}
		Thread.sleep(1000);
	  }
	
	@Test
	public void attributes() {
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
		att.add("Classification");
		att.add("Shipping Information");
		att.add("Labeling Information");
		att.add("Packaging Size UofM");
		att.add("Release Date");
		att.add("Effective Date");
		att.add("owner");
		att.add("Storage Temperature Limits - °C");
		att.add("Storage Humidity Limits - %");
		att.add("Battery Type");
		att.add("Class");
		att.add("Sub-Class");
		att.add("SAP BOM Base QTY");
		att.add("Manufacturing Status");
		att.add("Brand");
		att.add("Power Source");
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
		weight.add("Name:");
		weight.add("Type:");
		weight.add("Gross Weight:");
		weight.add("Legacy Product Weight:");
		weight.add("Legacy Weight Factor:");
		weight.add("Legacy Weight Factor UoM:");
		weight.add("Weight UoM:");
		weight.add("Net Weight of Product in Consumer Unit:");
		weight.add("Net Weight UoM:");
		weight.add("Comments:");
		WebElement content=driver.findElement(By.id("One"));
		List <WebElement> el = content.findElements(By.id("pageheaders"));
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
	public void sapBom() {
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
		WebElement table=driver.findElement(By.xpath("//*[@id=\"Two\"]/div/div/table/thead")); 
		List <WebElement> rows=table.findElements(By.tagName("tr"));
		List <WebElement> cols=rows.get(1).findElements(By.tagName("th"));
		for (WebElement col:cols) {
			String ss=col.getText();
			sap1.add(ss);
		}
		List<String> b=new ArrayList<String>();
		WebElement table2=driver.findElement(By.xpath("//*[@id=\"Two\"]/div/div/table/tbody"));
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
	public void billOfMaterials() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of bill of material web table is in progress...");
		List<String> bill=new ArrayList<String>();
		bill.add("Name(N) Rev(R)");
		bill.add("Chg");
		bill.add("F/N");
		
		bill.add("Title");
		bill.add("Type");
		bill.add("Substitute Parts (SP) Alternate (Alt)");
		bill.add("Qty");
		bill.add("Base Unit of Measure");
		bill.add("EBOM Comments");
		bill.add("State");
		bill.add("Phase");
		bill.add("Ref Des");
		bill.add("On-shelf Product Density(OSPD) Density Unit of Measure(DUOM)");
		bill.add("Optional Components");
		bill.add("N");
		bill.add("R");
		bill.add("SP");
		bill.add("Alt");
		bill.add("OSPD");
		bill.add("DUoM");
		List<String>bill1=new ArrayList<String>();
		WebElement table=driver.findElement(By.id("Four"));
		List <WebElement> rows=table.findElements(By.tagName("tr"));
		List <WebElement> cols=rows.get(0).findElements(By.tagName("th"));
		for (WebElement col:cols) {
			String ss=col.getText();
			bill1.add(ss);
		}
		List<String> b=new ArrayList<String>();
		WebElement table2=driver.findElement(By.xpath("//*[@id=\"Four\"]/div/div/table/tbody"));
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
	public void substitutes() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of substitutes web table is in progress...");
		List<String> sub=new ArrayList<String>();
		sub.add("Substitute Parts(SP) REV(R)");
		sub.add("Chg");
		sub.add("Substitution Combination Number (SCN) Title");
		sub.add("Type(T) Specification SubType(SST)");
		sub.add("Qty");
		sub.add("Base Unit of Measure");
		sub.add("Valid Start Date");
		sub.add("Valid Until Date");
		sub.add("Ref Des");
		sub.add("Comments");
		sub.add("Substitute For(SF) REV(R)");
		sub.add("Type(T) Title(Ti)");
		sub.add("Specification Sub Type(SST) Optional Components(OC)");
		sub.add("SP");
		sub.add("R");
		sub.add("SCN");
		sub.add("Title");
		sub.add("T");
		sub.add("SST");
		sub.add("SF");
		sub.add("R");
		sub.add("T");
		sub.add("Ti");
		sub.add("SST");
		sub.add("OC");
		List<String>sub11=new ArrayList<String>();
		WebElement table=driver.findElement(By.xpath("//*[@id=\"Five\"]/div/div"));
		List <WebElement> rows=table.findElements(By.tagName("tr"));
		List <WebElement> cols=rows.get(0).findElements(By.tagName("th"));
		for (WebElement col:cols) {
			String ss=col.getText();
			sub11.add(ss);
		}
		List<String> b=new ArrayList<String>();
		WebElement table2=driver.findElement(By.xpath("//*[@id=\"Five\"]/div/div/table/tbody"));
		List <WebElement> rows2=table2.findElements(By.tagName("tr"));
		List <WebElement> cols2=rows2.get(0).findElements(By.className("bomFontClass"));
		for(WebElement col:cols2) {
			String ss=col.getText();
			b.add(ss);
		}
		for(String s:b) {
			for(String ss:s.split(":")) {
				sub11.add(ss);
			}
		}
		for(String s:sub) {
			int count=0;
			for(String s1:sub11) {
				if(s.equalsIgnoreCase(s1)) {
					System.out.println(s+"is present");
					break;
				}
				else {
					count+=1;
					if(count>=sub11.size()) {
						System.out.println(s+" not present");
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
	public void relatedSpecification() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of related specification web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("Related Specifications")).isDisplayed()) {
				System.out.println("Web table Related Specifications is present");
			}
		}
		catch(Exception e){
			System.out.println("Web table Related Specifications is not present in the web page but present in the template");
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
		WebElement table=driver.findElement(By.id("Fourteen"));
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
		WebElement content=driver.findElement(By.id("Fifteen"));
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
		WebElement content=driver.findElement(By.id("Sixteen"));
		List <WebElement> el = content.findElements(By.tagName("th"));
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
	public void organizations() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Validation of organizations web table is in progress...");
		List<String> org=new ArrayList<String>();
		org.add("Primary Organization:");
		org.add("Secondary Organization:");
		WebElement table=driver.findElement(By.id("Nineteen"));
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
	public void plants() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of plants web table is in progress...");
		List<String> plant=new ArrayList<String>();
		plant.add("Plants");
		plant.add("Plants Authorized To Use");
		plant.add("Plants Authorized to Produce");
		plant.add("Activated");
		
		WebElement content=driver.findElement(By.id("Eleven"));
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
	public void masterSpecification() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of Master Specification web table is in progress...");
		List<String> mass=new ArrayList<String>();
		mass.add("Name");
		mass.add("Title");
		mass.add("Type");
		mass.add("Master Part Name");
		mass.add("Specification SubType");
		mass.add("State");
		WebElement content=driver.findElement(By.id("Thirteen"));
		List <WebElement> el = content.findElements(By.tagName("th"));
		for (String s:mass) {
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
	public void performanceCharacteristic() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of Performance characteristic web table is in progress...");
		List<String> per=new ArrayList<String>();
		
		per.add("Chg");
		per.add("Characteristic(Ch) Characteristic Specifics(CS) Path(P)");
		
		per.add("Test Method (Name) Test Method Logic(TML) Te st Method Origin (TMO) Other Test Method Number (TM#) Test Method	Specifics (Sp) Test Method	Reference Document	Name(TMRDN)");
		per.add("Sampling(SM) Subgroup(SG)");
		per.add("Plant Testing Level(LVL) Plant Testing:Retesting(RT) Retesting Unit Of Measure(UoM)");
		per.add("Lower Spec Limit(LSL) Lower Target(LTGT) Target(TGT) Upper Target(UTGT) Upper Spec Limit(USL)");
		per.add("Unit of Measure(UoM) Report to Nearest(RTN) Report Type(RT)");
		per.add("Release Criteria(RC)");
		per.add("Action Required(AC) Criticality Factor(CR) Basis(BA)");
		per.add("Test Group(TG) Application(AP) Master Part Title(MPT)");
		per.add("CH");
		per.add("CS");
		per.add("P");
		per.add("Name");
		per.add("TML");
		per.add("TMO");
		per.add("TM");
		per.add("SP");
		per.add("TMRDN");
		per.add("SM");
		per.add("SG");
		per.add("LVL");
		per.add("RT");
		per.add("UoM");
		per.add("LSL");
		per.add("LTGT");
		per.add("TGT");
		per.add("UTGT");
		per.add("USL");
		per.add("UoM");
		per.add("RTN");
		per.add("RT");
		per.add("RC");
		per.add("AC");
		per.add("CR");
		per.add("BA");
		per.add("TG");
		per.add("AP");
		per.add("MPT");
		List<String>per1=new ArrayList<String>();
		WebElement table=driver.findElement(By.id("Nine"));
		List <WebElement> rows=table.findElements(By.tagName("tr"));
		List <WebElement> cols=rows.get(0).findElements(By.tagName("th"));
		for (WebElement col:cols) {
			String ss=col.getText();
			per1.add(ss);
		}
		List<String> b=new ArrayList<String>();
		WebElement table2=driver.findElement(By.xpath("//*[@id=\"Nine\"]/div/div/table/tbody"));
		List <WebElement> rows2=table2.findElements(By.tagName("tr"));
		List <WebElement> cols2=rows2.get(0).findElements(By.className("bomFontClass"));
		for(WebElement col:cols2) {
			String ss=col.getText();
			b.add(ss);
		}
		for(String s:b) {
			for(String ss:s.split(":")) {
				per1.add(ss);
			}
		}
		for(String s:per) {
			int count=0;
			for(String s1:per1) {
				if(s.equalsIgnoreCase(s1)) {
					System.out.println(s+"is present");
					break;
				}
				else {
					count+=1;
					if(count>=per1.size()) {
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
		
		WebElement content=driver.findElement(By.id("Ten"));
		List <WebElement> el = content.findElements(By.tagName("th"));
		for (String s:mar) {
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
	 public void pqrViewManufacturerEquivalents() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of PQR View Manufacturer Equivalents web table is in progress...");
		List<String> pqr=new ArrayList<String>();
		pqr.add("Name");
		pqr.add("Revision");
		pqr.add("Type");
		pqr.add("Description");
		pqr.add("Manufacturer");
		pqr.add("State");
		pqr.add("PQR Qualification Name (N) PQR State(S) PQR Revision(R)");
		pqr.add("PQR Qualification Description");
		pqr.add("PQR Location Status");
		pqr.add("PQR Business Area (BA) PQR Product Category Platform (PCP)");
		pqr.add("PQR Plants");
		pqr.add("Comments");
		pqr.add("N");
		pqr.add("S");
		pqr.add("R");
		pqr.add("BA");
		pqr.add("PCP");
		pqr.add("PQR");
		List<String>pqr1=new ArrayList<String>();
		WebElement table=driver.findElement(By.id("Twelve"));
		List <WebElement> rows=table.findElements(By.tagName("tr"));
		List <WebElement> cols=rows.get(1).findElements(By.tagName("th"));
		for (WebElement col:cols) {
			String ss=col.getText();
			pqr1.add(ss);
		}
		List <WebElement> cols1=rows.get(0).findElements(By.tagName("th"));
		for (WebElement col:cols1) {
			String ss1=col.getText();
			pqr1.add(ss1);
		}
		List<String> b=new ArrayList<String>();
		WebElement table2=driver.findElement(By.xpath("//*[@id=\"Twelve\"]/div/div/table/tbody"));
		List <WebElement> rows2=table2.findElements(By.tagName("tr"));
		List <WebElement> cols2=rows2.get(0).findElements(By.className("bomFontClass"));
		for(WebElement col:cols2) {
			String ss=col.getText();
			b.add(ss);
		}
		for(String s:b) {
			for(String ss:s.split(":")) {
				pqr1.add(ss);
			}
		}
		for(String s:pqr) {
			int count=0;
			for(String s1:pqr1) {
				if(s.equalsIgnoreCase(s1)) {
					System.out.println(s+"is present");
					break;
				}
				else {
					count+=1;
					if(count>=pqr1.size()) {
						System.out.println(s+" not present");
					}
					continue;
				}
			}
		}
		 
	 }
	 
	@Test
	public void pqrViewSupplierEquivalents() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of PQR View Supplier Equivalents web table is in progress...");
		List<String> pqr=new ArrayList<String>();
		pqr.add("Name");
		pqr.add("Revision");
		pqr.add("Type");
		pqr.add("Description");
		pqr.add("Supplier");
		pqr.add("State");
		pqr.add("PQR Qualification Name (N) PQR State(S) PQR Revision(R)");
		pqr.add("PQR");
		pqr.add("PQR Qualification Description");
		pqr.add("PQR Location Status");
		pqr.add("PQR Business Area (BA) PQR Product Category Platform (PCP)");
		pqr.add("PQR Plants");
		pqr.add("Comments");
		pqr.add("N");
		pqr.add("S");
		pqr.add("R");
		pqr.add("BA");
		pqr.add("PCP");
		List<String>pqr1=new ArrayList<String>();
		//WebElement table=driver.findElement(By.xpath("//*[@id=\"Thirteen\"]/div/div/table")); 
		WebElement table=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/div/div[11]/div[2]"));
		List <WebElement> rows=table.findElements(By.tagName("tr"));
		List <WebElement> cols=rows.get(1).findElements(By.tagName("th")); //or get(0)
		for (WebElement col:cols) {
			String ss=col.getText();
			pqr1.add(ss);
		}
		List <WebElement> cols1=rows.get(0).findElements(By.tagName("th"));
		for (WebElement col:cols1) {
			String ss1=col.getText();
			pqr1.add(ss1);
		}
		
		List<String> b=new ArrayList<String>();
		WebElement table2=driver.findElement(By.xpath("//*[@id=\"Thirteen\"]/div/div/table/tbody"));
		List <WebElement> rows2=table2.findElements(By.tagName("tr"));
		List <WebElement> cols2=rows2.get(0).findElements(By.className("bomFontClass"));
		for(WebElement col:cols2) {
			String ss=col.getText();
			b.add(ss);
		}
		for(String s:b) {
			for(String ss:s.split(":")) {
				pqr1.add(ss);
			}
		}
		for(String s:pqr) {
			int count=0;
			for(String s1:pqr1) {
				if(s.equalsIgnoreCase(s1)) {
					System.out.println(s+"is present");
					break;
				}
				else {
					count+=1;
					if(count>=pqr1.size()) {
						System.out.println(s+" not present");
					}
					continue;
				}
			}
		}
		 
	 }
	
}
