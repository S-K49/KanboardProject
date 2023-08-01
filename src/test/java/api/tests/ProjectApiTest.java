package api.tests;

import api.methods.Project;
import api.steps.ProjectApiSteps;
import api.steps.UserApiSteps;
import org.testng.annotations.Test;

public class ProjectApiTest {

    private static final String USERNAME = "admin123";
    private static final String PASSWORD = "admin123";

    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    UserApiSteps userApiSteps = new UserApiSteps();

    @Test
    public void createProjectApiTest() {

        Integer projectId = Integer.valueOf(projectApiSteps.createProject("My new project"));
        System.out.println(projectApiSteps.getProjectById(projectId));
    }
}
