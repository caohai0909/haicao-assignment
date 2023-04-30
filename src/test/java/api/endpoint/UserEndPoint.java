package api.endpoint;

import api.payload.ApiUserModel;
import core.common.Constant;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import static core.common.Constant.*;
import static io.restassured.RestAssured.given;

public class UserEndPoint {

    public static Response createUser(ApiUserModel payload){
        JSONObject createUserTemplate = new JSONObject();
        createUserTemplate.put("name", payload.Name);
        createUserTemplate.put("email", payload.Email);
        createUserTemplate.put("password", payload.Password);
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(createUserTemplate.toJSONString())
            .when()
                .post(Constant.POST_USER_URL);
        return response;
    }
    public static Response readUserByUserId(String token, String userId){
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .pathParam("userId", userId)
            .when()
                .get(Constant.GET_USER_URL);
        return response;
    }
    public static Response updateUser(String token, Integer userId, ApiUserModel payload){
        JSONObject updateUserTemplate = new JSONObject();
        updateUserTemplate.put("id", userId);
        updateUserTemplate.put("name", payload.Name);
        updateUserTemplate.put("email", payload.Email);
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("userId", userId)
                .body(updateUserTemplate.toJSONString())
            .when()
                .put(Constant.PUT_USER_URL);
        return response;
    }
    public static Response deleteUser(String token, Integer userId){
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .pathParam("userId", userId)
            .when()
                .delete(DELETE_USER_URL);
        return response;
    }
    public static Response loginUser(ApiUserModel payload){
        JSONObject loginUserTemplate = new JSONObject();
        loginUserTemplate.put("email", payload.Email);
        loginUserTemplate.put("password", payload.Password);
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(loginUserTemplate.toJSONString())
            .when()
                .post(Constant.LOGIN_USER_URL);

        return response;
    }
}
