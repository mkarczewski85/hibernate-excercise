package car_rent.account;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class UserRepositoryTest {

    private static final String EMAIL = "test@gmail.com";
    private static final String PASSWORD = "123456";


    @Test
    public void findUser() throws Exception {

        Optional<User> user = UserRepository.findUserByMailAndPassword(EMAIL, PASSWORD);
        Assert.assertTrue("find User", user.isPresent());
    }


    @Test
    public void saveUser() throws Exception {
        User user = new User(EMAIL, PASSWORD);
        Assert.assertTrue("saveOrUpdate User", UserRepository.saveUser(user));
    }


}