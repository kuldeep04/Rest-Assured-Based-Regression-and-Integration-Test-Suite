package org.inflectionIo.RecipientService;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.inflectionIo.RequestionSpecification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static org.inflectionIo.constants.Constants.recipientListBaseUrl;

public class RecipientService {

    private final RequestSpecification requestSpecification;

    public RecipientService() {
        this.requestSpecification = new RequestSpecification(recipientListBaseUrl);
    }

    public Response getListOfRecipients() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        return RestAssured.given().spec(requestSpecification.getRequestSpecification(headers, "recipients/lists"))
                .when().get();
    }

    public Response getListOfRecipientsById(String id) {
        Map<String, String> headers = new HashMap<>();
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("id", id);
        headers.put("Accept", "application/json");
        return RestAssured.given().spec(requestSpecification.getRequestSpecification(headers, "recipients/lists/{id}", pathParams))
                .when().get();
    }

}
