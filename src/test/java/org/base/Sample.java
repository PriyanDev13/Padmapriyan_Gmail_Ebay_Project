package org.base;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Sample extends BaseUtilityClass{
	
	@Test
	public void Gmail() throws IOException, InterruptedException {
		WebDriver("https://www.gmail.com");
		maximize();
		WebElement em = xpath("(//input[@type='email'])");
		String ema = excelread("Sheet1", 1, 0);
		em.sendKeys(ema);
		WebElement nx = xpath("(//span[@jsname='V67aGc'])[1]");
		nx.click();
		threadsleep(2000);
		WebElement p = xpath("//input[@type='password']");
		String ps = excelread("Sheet1", 1, 1);
		p.sendKeys(ps);
		WebElement nxx = xpath("(//span[@jsname='V67aGc'])[1]");
		nxx.click();
		threadsleep(3000);
		WebElement acc = xpath("//img[@class='gb_Aa gbii']");
		movetoelement(acc);
		actionClick(acc);
		screenshot();
		closeallbrowser();
	}

	@Test
	public void ebay() throws IOException, InterruptedException {
		WebDriver("https://www.ebay.com/");
		maximize();
		WebElement sign = xpath(
				"//a[@href='https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&ru=https%3A%2F%2Fwww.ebay.com%2F']");
		sign.click();
		WebElement email = findelementById("userid");
		String name = excelread("Sheet1", 1, 0);
		email.sendKeys(name);
		WebElement con = xpath("//button[@name='signin-continue-btn']");
		con.click();
		threadsleep(2000);
		WebElement passs = findelementById("pass");
		String paa = excelread("Sheet1", 1, 1);
		passs.sendKeys(paa);
		WebElement sig = findelementById("sgnBt");
		sig.click();
		threadsleep(2000);

		WebElement se = xpath("//input[@class='gh-tb ui-autocomplete-input']");
		se.sendKeys("Electric guitar ");
		WebElement seec = xpath("//input[@class='btn btn-prim gh-spr']");
		seec.click();
		threadsleep(2000);
		WebElement value = xpath("(//span[@class='s-item__price'])[2]");
		System.out.println("price :" + (value.getText()));
		closeallbrowser();
	}

}


