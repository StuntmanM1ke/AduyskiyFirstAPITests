package tests;

import data.Resource;
import data.UsersFromResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Tests {

    @Test
    public void getUsersListAndAssertAvatarsEquality() {
        List<String> avatars = new ArrayList<>();
        Resource resource = given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .extract().body().as(Resource.class);
        resource.getData().forEach(x-> avatars.add(x.getAvatar()));
        for (String avatar : avatars) {
            Assert.assertEquals(avatar, avatars.get(0));
        }
    }

}
