package salt.domcoverage.casestudies.photogallery.originaltestsJSCover;

//import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

//import org.openqa.selenium.support.ui.Select;

public class MainViewTest {
	private WebDriver driver;
	// private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver(salt.domcoverage.core.dom.proxy.BrowserProfile.getProfile());
		// baseUrl = "http://localhost/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testMainView() throws Exception {
		driver.get("http://localhost:8888/phormer-photoGallery331/?p=1");
		try {
			assertTrue(isElementPresent(By.cssSelector("div#theImage")));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.linkText("Hide  info")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [getEval | window.document.getElementById("photoBoxes").style.display == "none" | ]]
		assertTrue(driver.findElement(By.id("photoBoxes")).isDisplayed() == false);
		driver.findElement(By.linkText("Show info")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [getEval | window.document.getElementById("photoBoxes").style.display == "none" | ]]
		assertTrue(driver.findElement(By.id("photoBoxes")).isDisplayed());
		// ERROR: Caught exception [ERROR: Unsupported command [getEval | (window.document.getElementById("rateSelect").value % 5) + 1 | ]]
		WebElement select = driver.findElement(By.id("rateSelect"));
		int rating = Integer.parseInt(select.getAttribute("value"));
		int nextRating = rating % 5 + 1;
		System.out.println(nextRating);
		List<WebElement> allOptions = select.findElements(By.tagName("option"));
		for (WebElement option : allOptions) {
			if (Integer.parseInt(option.getAttribute("value")) == nextRating) {
				option.click();
				break;
			}
		}
		try {
			assertEquals("Your rating saved!", driver.findElement(By.cssSelector("span#rateStatus")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("//div[@id='Granny']/div[5]/div[2]/center/a/img")).click();
		try { // ^http://localhost:8888/[\\s\\S]*mode=stories
			assertTrue(driver.getCurrentUrl().matches("^http://localhost:8888/[\\s\\S]*p=2$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
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
}
