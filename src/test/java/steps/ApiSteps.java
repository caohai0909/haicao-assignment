package steps;

import api.endpoint.UserEndPoint;
import api.payload.ApiUserModel;
import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import static core.common.BuiltInAction.*;

import java.io.File;

public class ApiSteps {
    private Faker faker;
    private ApiUserModel userPayload;

    @Before
    public void setupData(){
        faker = new Faker();
        userPayload = new ApiUserModel();
        userPayload.setName(faker.name().name());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(6, 10));
        userPayload.setLocation(faker.address().country());
    }

    @Given("Post user registration api")
    public void postUserRegistrationApi(){
        File file = new File(getProjectPath()+"\\src\\test\\java\\api\\schema\\CreateUser.json");
        Response response = UserEndPoint.createUser(userPayload);
        response.then().log().all();
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("message").toString(), "success");
        Assert.assertEquals(response.jsonPath().get("data.Name").toString(), this.userPayload.Name);
        Assert.assertEquals(response.jsonPath().get("data.Email").toString(), this.userPayload.Email);
    }
    @Given("Post user login api")
    public void postUserLoginApi(){
        File file = new File(getProjectPath()+"\\src\\test\\java\\api\\schema\\LoginUser.json");
        UserEndPoint.createUser(userPayload);
        Response response = UserEndPoint.loginUser(this.userPayload);
        response.then().log().all();
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("message").toString(), "success");
        Assert.assertEquals(response.jsonPath().get("data.Name").toString(), this.userPayload.Name);
        Assert.assertEquals(response.jsonPath().get("data.Email").toString(), this.userPayload.Email);
    }

    @Given("Get user by userId api")
    public void getUserByUserIdApi(){
        File file = new File(getProjectPath()+"\\src\\test\\java\\api\\schema\\GetUser.json");
        UserEndPoint.createUser(userPayload);
        Response loginResponse = UserEndPoint.loginUser(this.userPayload);
        String token = loginResponse.jsonPath().get("data.Token").toString();
        String userId = loginResponse.jsonPath().get("data.Id").toString();
        Response response = UserEndPoint.readUserByUserId(token, userId);
        response.then().log().all();
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("name").toString(), this.userPayload.Name);
        Assert.assertEquals(response.jsonPath().get("email").toString(), this.userPayload.Email);
    }
    @Given("Put user by userId api")
    public void putUserByUserIdApi(){
        UserEndPoint.createUser(userPayload);
        Response loginResponse = UserEndPoint.loginUser(this.userPayload);
        String token = loginResponse.jsonPath().get("data.Token").toString();
        Integer userId = loginResponse.jsonPath().get("data.Id");
        userPayload.setUserId(userId);
        userPayload.setName(faker.name().name());
        Response response = UserEndPoint.updateUser(token, userId, this.userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("data.Name").toString(), this.userPayload.Name);
        Assert.assertEquals(response.jsonPath().get("data.Email").toString(), this.userPayload.Email);
    }

    @Given("Delete user by userId api")
    public void deleteUserByUserIdApi(){
        UserEndPoint.createUser(userPayload);
        Response loginResponse = UserEndPoint.loginUser(this.userPayload);
        String token = loginResponse.jsonPath().get("data.Token").toString();
        Integer userId = loginResponse.jsonPath().get("data.Id");

        Response response = UserEndPoint.deleteUser(token, userId);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Then("Validation api response")
    public void validationApiResponse(){
        System.out.println("Already validated in [Given] Step");
    }

}
