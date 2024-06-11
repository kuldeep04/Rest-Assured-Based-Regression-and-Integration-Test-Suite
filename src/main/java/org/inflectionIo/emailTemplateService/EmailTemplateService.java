package org.inflectionIo.emailTemplateService;

import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;
import org.inflectionIo.RequestionSpecification.RequestSpecification;
import org.inflectionIo.ResponseSpecification.ResponseSpecifications;
import java.util.HashMap;
import java.util.Map;

import static org.inflectionIo.constants.Constants.emailTemplateBaseUrl;

public class EmailTemplateService {

    private final RequestSpecification requestSpecification;
    private final ResponseSpecifications responseSpecifications;


    public EmailTemplateService(){
        this.requestSpecification = new RequestSpecification(emailTemplateBaseUrl);
        this.responseSpecifications = new ResponseSpecifications();
    }


    public ResponseSpecification getEmailTemplates(){
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        return (ResponseSpecification) RestAssured.given()
                .spec(requestSpecification.getRequestSpecification(headers, "email/templates"))
                .when().get().then().spec(responseSpecifications.getResponseSpecification());
    }

    public ResponseSpecification getEmailTemplateById(String templateId){
        Map<String, String> headers = new HashMap<>();
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("id", templateId);
        headers.put("Accept", "application/json");
        return (ResponseSpecification) RestAssured.given()
                .spec(requestSpecification.getRequestSpecification(headers, "email/templates/{id}", pathParams))
                .when().get().then().spec(responseSpecifications.getResponseSpecification());
    }
}
