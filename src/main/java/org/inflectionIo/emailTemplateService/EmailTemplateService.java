package org.inflectionIo.emailTemplateService;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.inflectionIo.RequestionSpecification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;
import static org.inflectionIo.constants.Constants.emailTemplateBaseUrl;

public class EmailTemplateService {

    private final RequestSpecification requestSpecification;

    public EmailTemplateService() {
        this.requestSpecification = new RequestSpecification(emailTemplateBaseUrl);
    }


    public Response getEmailTemplates() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        return RestAssured.given()
                .spec(requestSpecification.getRequestSpecification(headers, "email/templates"))
                .when().get();
    }

    public Response getEmailTemplateById(String templateId) {
        Map<String, String> headers = new HashMap<>();
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("id", templateId);
        headers.put("Accept", "application/json");
        return RestAssured.given()
                .spec(requestSpecification.getRequestSpecification(headers, "email/templates/{id}", pathParams))
                .when().get();
    }
}
