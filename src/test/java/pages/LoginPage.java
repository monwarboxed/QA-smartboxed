package pages;

import com.aventstack.extentreports.ExtentTest;
import com.boxed.smartboxed.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by monwarjalil on 11/6/18.
 */
public class LoginPage extends AbstractPage {
    public LoginPage() {
        verifyPresence();
    }

    public void verifyPresence() {wait.until(visibilityOfElementLocated(bodySectionLocator));}

    By bodySectionLocator = By.cssSelector("body");

    By emailFieldLocator = By.cssSelector("[name='username']");

    By passwordFieldLocator = By.cssSelector("[name='password']");

    By signInButtonLocator = By.cssSelector("button");

    By getErrorMessageLocator = By.cssSelector("body > div > div > form > div:nth-child(6)");


    public HomePage signInUser() throws InterruptedException {
        type(emailFieldLocator, "testuser@boxed.com");
        type(passwordFieldLocator, "Boxed123");
        click(wait.until(elementToBeClickable(signInButtonLocator)));
        AbstractTest.report.info("User logged in successfully");
        return new HomePage();
    }

    public void invalidUser() {
        type(emailFieldLocator, "sfsaa");
        type(passwordFieldLocator, "hghfg");
        click(wait.until(elementToBeClickable(signInButtonLocator)));
    }

    public String getErrorMessage() {return  getErrorMessageLocator.toString();}

    public void observeLoginPresence() {
        visibilityOfElementLocated(bodySectionLocator);
        visibilityOfElementLocated(emailFieldLocator);
        visibilityOfElementLocated(passwordFieldLocator);
        visibilityOfElementLocated(signInButtonLocator);
    }
}
