package pages;

import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by monwarjalil on 11/30/18.
 */
public class DeactivateAccountModalPage extends AbstractPage {

    public DeactivateAccountModalPage () {verifyPresence();}

    public void verifyPresence() {
        wait.until(visibilityOfElementLocated(DeactivateAccountModalBodySectionLocator));
    }

    By DeactivateAccountModalBodySectionLocator = By.cssSelector("body > div.container > h3");

    By cancelButtonSelector = By.className("btn");

    By deactiveButtonSelector = By.xpath("/html//button[@id='deactivate-user']");

    public UserDetailsPage deactivateUser() {
        click(wait.until(visibilityOfElementLocated(deactiveButtonSelector)));
        return new UserDetailsPage();
    }


}
