package api.steps;

import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.users.CreateUser;
import api.models.args.users.UserId;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import static api.methods.Users.*;
import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class UserApiSteps extends BaseApiSteps {
    public String createUser(String username, String pass) {
        CreateUser args = CreateUser.builder()
                .username(username)
                .password(pass)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(CREATE_USER)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(new TypeRef<>() {});
        return result.getResult().toString();
    }

    public String getUser(Integer user_id) {

        BodyArgs bodyArgs = BodyArgs.builder().
                params(new UserId(Integer.valueOf(user_id)))
                .method(GET_USER)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(new TypeRef<>() {});
        return result.getResult().toString();
    }

    public boolean deleteUser(Integer userId) {

        BodyArgs bodyArgs = BodyArgs.builder().
                params(new UserId(Integer.valueOf(userId)))
                .method(DELETE_USER)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }

}
