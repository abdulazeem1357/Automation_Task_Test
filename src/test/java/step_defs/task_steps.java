package step_defs;
import cucumber.api.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class task_steps {

    WebDriver driver;
    Actions action;

    @Given("^User navigates to the Login Page$")
    public void user_navigates_to_the_Login_Page() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.gecko.driver", "C://geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        action = new Actions(driver);
    }

    @When("^User Login in to the Website$")
    public void user_Login_in_to_the_Website() {
        // Write code here that turns the phrase above into concrete actions
        WebElement userName = driver.findElement(By.cssSelector("#user-name"));
        WebElement passWord = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        userName.sendKeys("standard_user");
        passWord.sendKeys("secret_sauce");
        loginButton.click();
    }

    @When("^Change Dropdown from A-Z to Z-A$")
    public void change_Dropdown_from_A_Z_to_Z_A() {
        // Write code here that turns the phrase above into concrete actions
        WebElement filterDropdown = driver.findElement(By.cssSelector("option[value='za']"));
        filterDropdown.click();
    }

    @When("^Add item to cat if the price is lower than \\$(\\d+)\\.(\\d+)$")
    public void add_item_to_cat_if_the_price_is_lower_than_$(int arg1, int arg2) {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> productContainers = driver.findElements(By.cssSelector(".inventory_item"));
        for (WebElement productContainer : productContainers) {
            WebElement productPrice = productContainer.findElement(By.cssSelector(".inventory_item_price"));
            System.out.println(productPrice.getText().substring(1));
            if (Double.parseDouble(productPrice.getText().substring(1)) < 15.99) {
                driver.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory")).click();
            }
        }
    }

    @Then("^Click on the Cart$")
    public void click_on_the_Cart() {
        // Write code here that turns the phrase above into concrete actions
        WebElement cartButton = driver.findElement(By.cssSelector(".shopping_cart_link"));
        cartButton.click();
    }

    @Then("^Remove item if the price is greater than \\$(\\d+)$")
    public void remove_item_if_the_price_is_greater_than_$(int arg1) {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> cartContainers = driver.findElements(By.cssSelector(".cart_item"));
        for (WebElement cartContainer : cartContainers) {
            WebElement productPrice = cartContainer.findElement(By.cssSelector(".inventory_item_price"));
            System.out.println(productPrice.getText().substring(1));
            if (Double.parseDouble(productPrice.getText().substring(1)) > 9 ) {
                driver.findElement(By.cssSelector(".btn.btn_secondary.btn_small.cart_button")).click();
            }
        }
    }

    @Then("^Click Check out$")
    public void click_Check_out() {
        // Write code here that turns the phrase above into concrete actions
        WebElement checkoutButton = driver.findElement(By.cssSelector("#checkout"));
        checkoutButton.click();
    }

    @Then("^Click on the Continue Button$")
    public void click_on_the_Continue_Button() {
        // Write code here that turns the phrase above into concrete actions
        WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
        continueButton.click();
    }

    @Then("^Place assertion on the error$")
    public void place_assertion_on_the_error() {
        // Write code here that turns the phrase above into concrete actions
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        assertEquals("Error: First Name is required", errorMessage.getText());
        System.out.println(errorMessage.getText());
        WebElement closeErrorButton = driver.findElement(By.cssSelector(".error-button"));
        closeErrorButton.click();
    }

    @Then("^Fill the form$")
    public void fill_the_form() {
        // Write code here that turns the phrase above into concrete actions
        WebElement firstName = driver.findElement(By.cssSelector("#first-name"));
        WebElement lastName = driver.findElement(By.cssSelector("#last-name"));
        WebElement zipCode = driver.findElement(By.cssSelector("#postal-code"));
        firstName.sendKeys("testFirstName");
        lastName.sendKeys("testLastName");
        zipCode.sendKeys("zipTestCode");
    }

    @Then("^Press the Continue Button$")
    public void press_the_Continue_Button() {
        // Write code here that turns the phrase above into concrete actions
        WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
        continueButton.click();
    }

    @Then("^Press the Finish Button$")
    public void press_the_Finish_Button() {
        // Write code here that turns the phrase above into concrete actions
        WebElement continueButton = driver.findElement(By.cssSelector("#finish"));
        continueButton.click();
    }

    @Then("^Get the thank you message$")
    public void get_the_thank_you_message() {
        // Write code here that turns the phrase above into concrete actions
        WebElement successBanner = driver.findElement(By.cssSelector(".complete-header"));
        System.out.println(successBanner.getText());
    }

    @Then("^Open a new tab$")
    public void open_a_new_tab() {
        // Write code here that turns the phrase above into concrete actions
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://courses.ultimateqa.com/users/sign_in");
    }

    @Then("^Fill in the credentials and press on the login button$")
    public void fill_in_the_credentials_and_press_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement submitButton = driver.findElement(By.cssSelector(".button.button-primary.g-recaptcha"));
        emailField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        submitButton.click();
    }

    @Then("^I should be logged in to system$")
    public void i_should_be_logged_in_to_system() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#notice")));
        assertEquals("Invalid email or password.", errorMessage.getText());
    }
}
