package salt.domcoverage.casestudies.photogallery.originaltestsJSCover;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CategoryDeleteTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver(salt.domcoverage.core.dom.proxy.BrowserProfile.getProfile());
		baseUrl = "http://localhost:8888";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testAddCategory() throws Exception {
		driver.get(baseUrl + "/phormer-photoGallery331/");
		driver.findElement(By.linkText("Admin Page")).click();
		driver.findElement(By.id("loginAdminPass")).clear();
		driver.findElement(By.id("loginAdminPass")).sendKeys("editor");
		driver.findElement(By.cssSelector("input.submit")).click();
		driver.findElement(By.linkText("Manage Categories")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("flowers");
		driver.findElement(By.name("desc")).clear();
		driver.findElement(By.name("desc")).sendKeys("contains photos of all the flowers !");
		driver.findElement(By.id("listRadioNo")).click();
		driver.findElement(By.id("listRadioYe")).click();
		driver.findElement(By.cssSelector("input.submit")).click();
		// Warning: verifyTextPresent may require manual changes
		try {
			assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Category \"flowers\" added succesfully![\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("(//a[contains(text(),'Delete / Clear')])[2]")).click();
		// Warning: verifyTextPresent may require manual changes
		try {
			assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Clears Category flowers of all its own \\(direct\\) photos, nothing will be removed[\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		// FileUtils.write(new
		// File("salt.domcoverage.casestudies.photogallery.Add_category.testAddCategory.html"),
		// driver.getPageSource());
		driver.findElement(By.xpath("(//input[@name='howto'])[4]")).click();
		driver.findElement(By.cssSelector("input.submit")).click();
		assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to delete [\\s\\S]*$"));
		// driver.findElement(By.cssSelector("a[title=\"Log Out\"] > img.logo")).click();
	}

	@After
	public void tearDown() throws Exception {
		((JavascriptExecutor) driver).executeScript("		if (window.jscoverage_report) {return jscoverage_report('report');}");
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
