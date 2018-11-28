package pages;

import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by monwarjalil on 11/13/18.
 */
public class ConfigPages extends AbstractPage {

    public ConfigPages() {
        verifyPresence();
    }

    public Header header = new Header();


    public void verifyPresence() {
        wait.until(visibilityOfElementLocated(configBodySectionLocator));
    }


    By configBodySectionLocator = By.cssSelector("#variant-info > fieldset > legend");

}


