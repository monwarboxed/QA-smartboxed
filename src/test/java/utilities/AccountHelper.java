package utilities;

import org.testng.Reporter;

import java.util.Random;

/**
 * Created by monwarjalil on 3/23/19.
 */
public class AccountHelper {

    //returns a random string of length
    public static String getRandomString(int length) {
        String charString = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        for(int i=0; i<length; i++) {
            char randomChar = charString.charAt(random.nextInt(charString.length()));
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }

    public static String getNewAccountEmail(int length) {
        String suffix = "@boxed.com", newAccountEmail = getRandomString(length) + suffix;

        Reporter.log("new account email " + newAccountEmail, true);
        return newAccountEmail;
    }

    public static String getNewAccountPassword() {
        String password = getRandomString(8);
        Reporter.log("new account pw " + password, true);
        return password;
    }




}
