package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by monwarjalil on 11/5/18.
 */
public class InventoryTabPage extends AbstractPage {

    public InventoryTabPage() {

        verifyPresence();
    }

    By bodySectionLocator = By.cssSelector("body");

    public void verifyPresence() {wait.until(visibilityOfElementLocated(bodySectionLocator));}

}

