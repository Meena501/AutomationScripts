package com.specreader.automation.cup;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class CupObject {
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
		driver.findElement(By.id("searchBox")).sendKeys("CUP");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/form/div/div[1]/div/button")).click();
		Thread.sleep(1000);
		if(driver.findElement(By.linkText("CUP-00000871")).isDisplayed())
		{
				driver.findElement(By.linkText("CUP-00000871")).click();
		}
		else 
		{
			driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[2]/div/div/div/div/table/tbody/tr[3]/td[1]/a/span")).click();
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
		att.add("Phase");
		att.add("Originator");
		att.add("Last Update User");
		att.add("Segment");
		att.add("Specification Sub Type");
		att.add("Expiration Date");
		att.add("Previous Revision Obsolete Date");
		att.add("Reason for CHange");
		att.add("Base Unit of Measure");
		att.add("Alternative Unit of Measure");
		att.add("Local Description");
		att.add("Other Names");
		att.add("Packaging Type");
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
		att.add("Packaging UoM");
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
	public void weightCharacteristics() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Validation of weight characteristics web table is in progress...");
		List<String> weight=new ArrayList<String>();
		weight.add("Gross Weight:");
		weight.add("Weight UoM:");
		weight.add("Legacy Weight Factor:");
		weight.add("Legacy Weight Factor UoM:");
		WebElement content=driver.findElement(By.id("collapseOne"));
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
	public void Storage() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of storage web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("Storage, Transportation, Labelling Assessment Data")).isDisplayed()) {
				System.out.println("Web table Storage, Transportation, Labelling Assessment Data is present");
			}
		}
		catch(Exception e){
			System.out.println("Web table Storage, Transportation, Labelling Assessment Data is not present in the web page but present in the template");
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
		bill.add("DUOM");
		List<String>bill1=new ArrayList<String>();
		WebElement table=driver.findElement(By.xpath("//*[@id=\"collapseFour\"]/div/div/table/thead"));
		List <WebElement> rows=table.findElements(By.tagName("tr"));
		List <WebElement> cols=rows.get(0).findElements(By.tagName("th"));
		for (WebElement col:cols) {
			String ss=col.getText();
			bill1.add(ss);
		}
		List<String> b=new ArrayList<String>();
		WebElement table2=driver.findElement(By.xpath("//*[@id=\"collapseFour\"]/div/div/table/tbody")); 
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
		sub.add("Substitute Parts (SP) Rev(R)");
		sub.add("Chg");
		sub.add("Substitution Combination Number(SCN) Title");
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
		WebElement table=driver.findElement(By.xpath("//*[@id=\"collapseFive\"]/div/div/table/thead"));
		List <WebElement> rows=table.findElements(By.tagName("tr"));
		List <WebElement> cols=rows.get(0).findElements(By.tagName("th"));
		for (WebElement col:cols) {
			String ss=col.getText();
			sub11.add(ss);
		}
		List<String> b=new ArrayList<String>();
		WebElement table2=driver.findElement(By.xpath("//*[@id=\"collapseFive\"]/div/div/table/tbody"));
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
	public void performanceCharacteristic() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of performance characteristic web table is in progress...");
		try
		{
			if(driver.findElement(By.linkText("Performance Characteristic")).isDisplayed()) {
				System.out.println("Web table Performance Characteristic is present");
			}
		}
		catch(Exception e) {
			System.out.println("Web table Performance Characteristic is not present");
		}
		
	}
	
	@Test
	public void plants() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validation of plants web table is in progress...");
		List<String> plant=new ArrayList<String>();
		plant.add("Plants");
		plant.add("Authorized");
		WebElement content=driver.findElement(By.id("collapseTen"));
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
		WebElement table=driver.findElement(By.id("collapseElevan"));
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
		WebElement content=driver.findElement(By.id("collapseTwelve"));
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
		WebElement tab=driver.findElement(By.id("collapseThirteen"));
		List <WebElement> el = tab.findElements(By.tagName("th"));
		for (String s:ip) {
			int count=0;
			for (WebElement w:el) {
				String s1=w.getText();
				if(s.equalsIgnoreCase(s1)) {
					System.out.println(s+" is Present");
					break;
				}
				else {
					count+=1;
					if(count>=el.size()) {
						System.out.println(s+" is not present");
					}
					continue;
				}
			}
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
		WebElement table=driver.findElement(By.id("collapseSeventeen"));
		List<WebElement> l=table.findElements(By.id("pageheaders"));
		for(String s:org) {
			int count=0;
			for(WebElement w:l) {
				String s1=w.getText();
				if(s.equalsIgnoreCase(s1)) {
					System.out.println(s+" is Present");
					break;
				}
				else {
					count+=1;
					if(count>=l.size()) {
						System.out.println(s+" is not present");
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
	
	
}
