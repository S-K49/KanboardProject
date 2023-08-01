package api.steps;

import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.project.CreateProject;
import api.models.args.users.CreateUser;
import api.models.args.users.UserId;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import static api.methods.Project.*;
import static api.methods.Users.CREATE_USER;
import static api.methods.Users.GET_USER;
import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class ProjectApiSteps extends BaseApiSteps {

    public String createProject(String name) {
        CreateProject args = CreateProject.builder()
                .name(name)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(CREATE_PROJECT)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(new TypeRef<>() {
        });
        return result.getResult().toString();
    }

    public String getProjectById(Integer project_id) {

        BodyArgs bodyArgs = BodyArgs.builder().
        params(new api.models.args.projects.ProjectId(project_id))
                .method(GET_PROJECT_BY_ID)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(new TypeRef<>() {
        });
        return result.getResult().toString();
    }


    public boolean removeProject(Integer project_id) {

        BodyArgs bodyArgs = BodyArgs.builder().
                params(new api.models.args.projects.ProjectId(project_id))
                .method(REMOVE_PROJECT)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }

}
