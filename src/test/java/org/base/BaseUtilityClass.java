package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtilityClass {
	
	org.openqa.selenium.WebDriver driver;

	public void navigaterefrech() {
	driver.navigate().refresh();
	}
	//1	
		public void WebDriver(String url) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get(url);
		}
		//2
		public String getTitle() {
	String title = driver.getTitle();
	return title;
		}
		//3
		public String getCurrentUrl() {
	String currentUrl = driver.getCurrentUrl();
	return currentUrl;
		}
		//4
		public void Closecurrentbrowser() {
	driver.close();
		}//5
	public void closeallbrowser() {
	driver.quit();
	}
	//6
	public WebElement findelementById(String attributevalue) {
	WebElement element = driver.findElement(By.id(attributevalue));
	return element;
	}
	//7
	public void maximize() {
	driver.manage().window().maximize();
	}
	//8
	public void sendKeys(WebElement element,String text) {
	element.sendKeys(text);
	}
	//9
	public void click(WebElement element) {
	element.click();
	}
	//10
	public WebElement xpath(String path) {
	WebElement findElement = driver.findElement(By.xpath(path));
	return findElement;
	}
	//11
	public String getText(WebElement element) {
	 String text = element.getText();
	return text;
	}
	//12
	public String getAttribute(WebElement element,String attributevalue) {
	String text = element.getAttribute(attributevalue);
	return text;
	}
	//13
	public void simplealert() {
	driver.switchTo().alert().accept();
	}
	//14
	public void switchframeIndex(int index) {
	driver.switchTo().frame(index);
	}
	//15
	public void switchframename(String name) {
	driver.switchTo().frame(name);
	}
	//16
	public void switchframeid(String id) {
	driver.switchTo().frame(id);
	}
	//17
	public void switchframeelement(WebElement  element) {
	driver.switchTo().frame(element);
	}
	//18
	public void switchtodefault() {
	driver.switchTo().defaultContent();
	}
	//19
	public WebElement tablerow(WebElement element, String tagName) {
	List<WebElement> tableref = element.findElements(By.tagName(tagName));
	return (WebElement) tableref;
	}
	//20
	public int tablerowsize(WebElement tableref) {
	int rowsize=((List<WebElement>) tableref).size();
	return rowsize;
	}
	//21
	public void js() {
	JavascriptExecutor jk = (JavascriptExecutor) driver;
	}
	//22
	public Object jsscroll(JavascriptExecutor jk,WebElement element) {
	Object scroll = jk.executeScript("arguments[0].scrollIntoView(true)", element);
	return scroll;
	}
	//23
	public Object jsscrollbottom(JavascriptExecutor jk,WebElement element) {
	Object scroll = jk.executeScript("arguments[0].scrollIntoView(false)", element);
	return scroll;
	}
	//24
	public Object jsclick(JavascriptExecutor jk, WebElement element) {
	Object click = jk.executeScript("arguments[0].click()", element);
	return click;
	}
	//25
	public Object jssetvalue(JavascriptExecutor jk,String text,WebElement element) {
	Object setvalue = jk.executeScript("arguments[0].setAttribute('value','"+text+"')", element);
	return setvalue;
	} 
	//26

	//27
	public void selectByValue(WebElement element,String value) {
		Select s = new Select(element);
	s.selectByValue(value);
	}
	//28
	public void selectByVisibleText(WebElement element,String text) {
		Select s = new Select(element);
	s.selectByVisibleText(text);
	}
	//29
	public void selectByIndex(WebElement element,int index) {
		Select s = new Select(element);
	s.selectByIndex(index);
	}
	//30
	public List<WebElement> getalloption(WebElement element) {
		Select s = new Select(element);
	List<WebElement> options = s.getOptions();
	return options;
	}
	//31
	public void deselectByValue(WebElement element,String value) {
		Select s = new Select(element);
	s.deselectByValue(value);
	}
	//32
	public void deselectByVisibleText(WebElement element,String text) {
		Select s = new Select(element);
	s.deselectByVisibleText(text);
	}
	//33
	public void deselectByIndex(WebElement element,int index) {
		Select s = new Select(element);
	s.deselectByIndex(index);
	}
	//34
	public void deselectall(WebElement element) {
		Select s = new Select(element);
	s.deselectAll();
	}
	//35
	public List<WebElement> getAllselectedOption(WebElement element) {
		Select s = new Select(element);
	 List<WebElement> alloption = s.getAllSelectedOptions();
	return alloption;

	}
	//36
	public WebElement getFirstSelectedOption(WebElement element) {
		Select s = new Select(element);
	WebElement firstSelectedOption = s.getFirstSelectedOption();
	return firstSelectedOption;
	}
	//40
	public Actions Actions() {
	org.openqa.selenium.interactions.Actions a = new Actions(driver);
	return a;
	}
	//41
	public void movetoelement(WebElement btn) {
		Actions a = new Actions(driver);
	a.moveToElement(btn).perform();
	}
	//42
	public void actionClick(WebElement btn) {
		Actions a = new Actions(driver);
	a.click(btn).perform();
	}
	//43
	public void doubleclick(Actions a,WebElement element) {
	a.doubleClick(element).perform();
	}
	//44
	public void contextclick(Actions a,WebElement element) {
	a.contextClick(element).perform();
	}
	//45
	public void draganddrop(Actions a,WebElement source,WebElement target) {
	a.dragAndDrop(source, target).perform();
	}
	public String excelread(String sheetname,int rownum,int cellnum) throws IOException {
	String data=null;
	File file = new File("C:\\Users\\Ajay\\eclipse-workspace\\Konica\\Excel\\usr.xlsx");
	FileInputStream fileinput = new FileInputStream(file);
	Workbook workbook = new XSSFWorkbook(fileinput);
	Sheet sheet = workbook.getSheet(sheetname);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	int type = cell.getCellType();
	switch (type) {
	case STRING:
		data = cell.getStringCellValue();
		
		break;
	case NUMERIC:
		if (DateUtil.isCellDateFormatted(cell)) {
			Date date = cell.getDateCellValue();   
			SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yy");
			data = dateformat.format(date);
		}else {
			double d = cell.getNumericCellValue();
			BigDecimal b = BigDecimal.valueOf(d);
			data = b.toString();
		}break;

	default:
		break;
	}
	return data; 

	}

	public void excelreplace(String sheetname,int rownum,int cellnum,String olddata,String newdata) throws IOException {
		File file = new File("C:\\Users\\Ajay\\eclipse-workspace\\Base\\Excel\\Test.xlsx");
		FileInputStream fileinput = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileinput);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
	String value = cell.getStringCellValue();
	if (value.equals(olddata)) {
		cell.setCellValue(newdata);
	}
	FileOutputStream o = new FileOutputStream(file);
	workbook.write(o);
	}
	public void excelwrite(String sheetname,int rownum,int cellnum,String newdata) throws IOException {
		File file = new File("C:\\Users\\Ajay\\eclipse-workspace\\Base\\Excel\\Test.xlsx");
		FileInputStream fileinput = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileinput);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(newdata);
		FileOutputStream o = new FileOutputStream(file);
		workbook.write(o);
	}
	public void threadsleep(int mins) throws InterruptedException {
	Thread.sleep(mins);
	}
	public void screenshot() throws InterruptedException, IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File file = tk.getScreenshotAs(OutputType.FILE);
		Thread.sleep(2000);
		File fs = new File("C:\\Users\\Ajay\\eclipse-workspace\\Konica\\Scrrenshot\\login.png");
		FileUtils.copyFile(file, fs);
	}

	}


