package test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class test {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://api.agify.io";
        getAppDetails();
    }

    public static void getAppDetails() {
        Response response = RestAssured.given().queryParams("name", "meelad").get();
        System.out.println(response.getBody().asString());

    }
}
