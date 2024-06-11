package org.inflectionIo.ResponseSpecification;

import io.restassured.builder.ResponseSpecBuilder;

public class ResponseSpecifications {

    public ResponseSpecifications() {}

    public io.restassured.specification.ResponseSpecification getResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200).build();
    }
}
