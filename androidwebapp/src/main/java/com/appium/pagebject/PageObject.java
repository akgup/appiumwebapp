package com.appium.pagebject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class PageObject {

	static AndroidDriver driver;

	public void setCapabilities() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("deviceName", "Redmi3SPrime");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver(url, capabilities);

	}

	public void navigateToSingupPage() {
		driver.get("http://www.gmail.com");
		driver.findElement(By.linkText("Create account")).click();
	}

	public void fillUserDetails(String fname, String lname, String newmailid, String passwd, String passwdagain,
			String phone, String recovermail) {
		driver.findElement(By.id("FirstName")).sendKeys(fname);
		driver.findElement(By.id("LastName")).sendKeys(lname);
		driver.findElement(By.id("GmailAddress")).sendKeys(newmailid);
		driver.findElement(By.id("Passwd")).sendKeys(passwd);
		driver.findElement(By.id("PasswdAgain")).sendKeys(passwdagain);
		driver.findElement(By.id("RecoveryPhoneNumber")).sendKeys(phone);
		driver.findElement(By.id("RecoveryEmailAddress")).sendKeys(recovermail);

	}

	public String getTextById(String locatorid) {
		String text = driver.findElement(By.id(locatorid)).getText();

		return text;
	}

	public void quitDriver() {
		driver.quit();
	}

}
