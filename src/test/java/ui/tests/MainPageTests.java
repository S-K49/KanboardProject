package ui.tests;

import api.steps.ProjectApiSteps;
import api.steps.UserApiSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.steps.LoginPage;
import ui.steps.MainPage;

import static org.testng.TestRunner.PriorityWeight.priority;

public class MainPageTests extends BaseTest {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    private static final String NAME = "Project Name";
    private static final String IDENTIFIER = "identifier";

    private static final String TASK_NAME = "Task 1";

    private static final String TASK_LIMIT = "12";

    private static final String COMMENT = "My comment";

    private static Integer userId;

    private static Integer projectId;

    UserApiSteps userApiSteps = new UserApiSteps();

    ProjectApiSteps projectApiSteps = new ProjectApiSteps();

//    @BeforeMethod
//    public void setUpDataForTest() {
//        userId = Integer.valueOf(userApiSteps.createUser(USERNAME, PASSWORD));
//        projectId = Integer.valueOf(projectApiSteps.createProject("My new project"));
//    }

    @BeforeMethod
    public void loginMainPage() {
        new LoginPage()
                .openLoginPage();
    }

    @Test(priority = 1)
    public void createProject() {

        new LoginPage()
                .loginByUser(USERNAME, PASSWORD);

        new MainPage()
                .createProject(NAME, IDENTIFIER, TASK_LIMIT)
                .assertNewProjectIsCreated(NAME);
    }

    @Test(priority = 2)
    public void createTask() {
        new MainPage()
                .createTask(TASK_NAME)
                .assignToMe(USERNAME)
                .save()
                .assertNewTaskIsCreated(USERNAME, TASK_NAME);
    }

    @Test(priority = 3)
    public void addComment() {
        new MainPage()
                .addComment(COMMENT)
                .save();

    }

    @Test(priority = 4)
    public void closeTaskTest() {
        new MainPage()
                .closeTask()
                .assertTaskIsClosed();
    }

//    @AfterMethod
//    public void ClearDataAfterTest() {
//        projectApiSteps.removeProject(projectId);
//        userApiSteps.deleteUser(userId);
//    }

}
