package api.tests;

import api.models.Result;
import api.steps.UserApiSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiTests extends BaseApiTest {

    private static final String USERNAME = "admin123";
    private static final String PASSWORD = "admin123";

    private static Integer userId;
    UserApiSteps userApiSteps = new UserApiSteps();
    @Test
    public void createUserApiTest() {
        userId = Integer.valueOf(userApiSteps.createUser(USERNAME, PASSWORD));

        Assert.assertTrue(userApiSteps.getUser(Integer.valueOf(userId)).contains(USERNAME), "User us not created");
        System.out.println(userApiSteps.getUser(Integer.valueOf(userId)).contains(USERNAME));

    }

    @Test
    public void deleteUserApiTest() {

        Boolean delete = userApiSteps.deleteUser(Integer.valueOf(userId));

        Assert.assertTrue(delete, "User is not deleted");
        System.out.println(delete);
    }
}
