package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by monwarjalil on 11/7/18.
 */
public class UserDetailsPage extends AbstractPage {


    public UserDetailsPage() {verifyPresence();}

    public Header header = new Header();

    By userDetailSectionLocator = By.cssSelector("body > div.container > h3");

    public void verifyPresence() {wait.until(visibilityOfElementLocated(userDetailSectionLocator));}

    By emailFieldLocator = By.id("email");

    By passwordFieldLocator = By.id("password");

    By confirmFieldLocator = By.id("confirm-password");

    By overridePasswordFieldLocator = By.id("override-password");

    By roleSelectorLocator =  By.cssSelector("#role");

    By adminSelectorLocator = By.cssSelector("#role > option:nth-child(1)");

    By managerSelectorLocator = By.cssSelector("#role > option:nth-child(3)");

    By sourceSelectorLocator = By.cssSelector("#source");

    By boxedFulfillmentLocator = By.cssSelector("#source > option:nth-child(3)");

    By warehouseSelectorLocator = By.cssSelector("#warehouse");

    By addButtonLocator = By.cssSelector("#add-user");

    By cancelButtonLocator = By.cssSelector("body > div.container > div > div > div > a.btn.btn-default");

    By deactiveButtonLocator = By.linkText("Deactivate");

    By userTabBodySectionPage = By.cssSelector("body > div.container > h3");

    By deactiveButtonConfirmationLocator = By.xpath("/html//button[@id='deactivate-user']");

    By reactivateButtonLocator = By.xpath("/html//a[@id='reactivate-user']");

   /* private void signUp(String email, String password) {
        clearAndType(emailFieldLocator, email);
        type(passwordInput, password);
        click(signUpButton);

        wait.until(invisibilityOfElementLocated(modalBodyLocator));
    }*/

    public void updateUserDetails () {
        type(emailFieldLocator, "testuser2@boxed.com");
    }

    public DeactivateAccountModalPage deactivateUserAccount () throws  InterruptedException{
        click(elementBy(deactiveButtonLocator));
        return new DeactivateAccountModalPage();
    }

    public UserDetailsPage reactivateAccount() throws InterruptedException{
        click(elementBy(reactivateButtonLocator));
        return new UserDetailsPage();
    }

    private void signUp(String email) throws InterruptedException{
        clearAndType(emailFieldLocator, email);
        type(passwordFieldLocator,"Ismaeljalil94");
        type(confirmFieldLocator,"Ismaeljalil94");
        click(wait.until(visibilityOfElementLocated(roleSelectorLocator)));
        click(wait.until(visibilityOfElementLocated(managerSelectorLocator)));
        click(wait.until(visibilityOfElementLocated(sourceSelectorLocator)));
        click(wait.until(visibilityOfElementLocated(boxedFulfillmentLocator)));
        click(addButtonLocator);
    }

    public UserTabPage signUpWithValidCredentials(String email) throws  InterruptedException {
        signUp(email);
        return new UserTabPage();
    }





}
