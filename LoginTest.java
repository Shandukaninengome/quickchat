package account.creation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LoginTest {

    Login login = new Login();

    @Test
    public void testUsernameCorrectlyFormatted() {

        assertTrue(
                login.checkUserName("kyl_1")
        );
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {

        assertFalse(
                login.checkUserName("kyle!!!!")
        );
    }

    @Test
    public void testPasswordCorrectlyFormatted() {

        assertTrue(
                login.checkPasswordComplexity(
                        "Password@1"
                )
        );
    }

    @Test
    public void testPasswordIncorrectlyFormatted() {

        assertFalse(
                login.checkPasswordComplexity(
                        "pass"
                )
        );
    }

    @Test
    public void testCellphoneCorrectlyFormatted() {

        assertTrue(
                login.checkCellPhoneNumber(
                        "+27831234567"
                )
        );
    }

    @Test
    public void testCellphoneIncorrectlyFormatted() {

        assertFalse(
                login.checkCellPhoneNumber(
                        "0831234567"
                )
        );
    }
}
