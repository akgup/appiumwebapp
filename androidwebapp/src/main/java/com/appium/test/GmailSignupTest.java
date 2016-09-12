package com.appium.test;

import java.net.MalformedURLException;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.appium.pagebject.PageObject;

public class GmailSignupTest {

	PageObject pageObject = new PageObject();

	@BeforeClass
	public void setUp() throws MalformedURLException {
		pageObject.setCapabilities();
	}

	@Test
	public void VerifyAlreadyTakenMailIdError() {

		pageObject.navigateToSingupPage();
		pageObject.fillUserDetails("akshay", "gupta", "akshay19vit", "abcd1234@1324", "abcd1234@1324", "7387152444",
				"recover1234@gmail.com");

		String errmsg = pageObject.getTextById("errormsg_0_GmailAddress");

		AssertJUnit.assertEquals(errmsg, "That username is taken. Try another.");

	}

	@Test
	public void VerifyPasswdMismatchError() {

		pageObject.navigateToSingupPage();
		pageObject.fillUserDetails("akshay", "gupta", "akshay743749", "abcd1234@1324", "abcd123@3534", "7387152444",
				"recover1234@gmail.com");

		String errmsg = pageObject.getTextById("errormsg_0_PasswdAgain");

		AssertJUnit.assertEquals("These passwords don't match. Try again?", errmsg);

	}

	@Test
	public void VerifyPhoneNumberFormatError() {

		pageObject.navigateToSingupPage();
		pageObject.fillUserDetails("akshay", "gupta", "akshay743749", "abcd1234@1324", "abcd123@3534", "738715244453",
				"recover1234@gmail.com");

		String errmsg = pageObject.getTextById("errormsg_0_RecoveryPhoneNumber");

		AssertJUnit.assertEquals("This phone number format is not recognized. Please check the country and number.",
				errmsg);

	}

	@AfterClass
	public void tearDown() {
		pageObject.quitDriver();
	}

}
