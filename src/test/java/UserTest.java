import entities.User;
import org.junit.jupiter.api.Test;
import useCase.Account.AccountInputBoundary;
import useCase.Account.AccountRequestModel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    @Test
    void checkPasswordValidFalse() {
        AccountRequestModel user = new AccountRequestModel("User", "12345");
        assertFalse(user.checkPasswordValid());
    }

    @Test
    void checkPasswordCorrectFalse() {
        AccountRequestModel user = new AccountRequestModel("User", "User1234");
        assertTrue(user.checkPasswordValid());
    }
}
