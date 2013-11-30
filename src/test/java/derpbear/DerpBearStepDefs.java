package derpbear;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.text.WordUtils;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created with IntelliJ IDEA.
 * User: orieken
 * Date: 11/12/13
 * Time: 1:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class DerpBearStepDefs {
    protected WebDriver driver;
    protected WebElement title;



    @Before
    public void andSoItBegins() throws MalformedURLException {
        driver = new ChromeDriver();
    }

    @After
    public void andThenItEnds() {
        driver.close();
        driver.quit();
    }

    @Given("^I hop$")
    public void I_hop() throws Throwable {
        driver.navigate().to("http://derp-bear.herokuapp.com");
    }

    @When("^I land$")
    public void I_land() throws Throwable {
        WebDriverWait nowWeWait = new WebDriverWait(driver, 30);
        By my_by_locator = By.tagName("h1");
        nowWeWait.until(presenceOfAllElementsLocatedBy(my_by_locator));
        title = driver.findElement(my_by_locator);
    }

    @Then("^I am on the ground$")
    public void I_am_on_the_ground() throws Throwable {
        assertThat(title.getText(), is(equalTo("HERE ARE A FEW EXAMPLE PAGES.")));
    }

}
