package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Products {

    public WebDriver driver;
    WebDriverWait wait;

    public Products() {
        driver = Hooks.driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    @Given("^I am in the home page$")
    public void i_am_in_the_home_page() throws Throwable {
        driver.get("https://www.salesforce.com");
    }

    @When("^I click on Products$")
    public void i_click_on_Vendas() throws Throwable {
        WebElement tab_products = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".navbar-expander")));
        tab_products.click();
    }

    @When("^select Ver Demo$")
    public void select_Ver_Demo() throws Throwable {
        WebElement btn_watchDemo = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-lg.btn-primary.salesforce-sans-regular  ")));
        btn_watchDemo.click();
    }

    @Then("^I should see a form to fill$")
    public void i_should_see_a_form_to_fill() throws Throwable {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.switchTo().window(tabs.get(0));
        driver.close();
        // TODO: check form
    }
}
