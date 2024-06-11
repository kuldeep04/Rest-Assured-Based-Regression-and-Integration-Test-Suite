package org.inflectionIo.RequestionSpecification;

import io.restassured.builder.RequestSpecBuilder;

import java.util.Map;

public class RequestSpecification {

    private final String url;

    public RequestSpecification(String url) {
        this.url = url;
    }

    public io.restassured.specification.RequestSpecification getRequestSpecification(Map<String, String> headers, String path) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setBasePath(path)
                .addHeaders(headers).build();
    }


    public io.restassured.specification.RequestSpecification getRequestSpecification(Map<String, String> headers,
                                                                                     String path,
                                                                                     Map<String, String> pathParams) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .addHeaders(headers)
                .setBasePath(path)
                .addPathParams(pathParams)
                .build();
    }

    public io.restassured.specification.RequestSpecification getRequestSpecification(Map<String, String> headers,
                                                                                     String path,
                                                                                     String requestBody) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .addHeaders(headers)
                .setBasePath(path)
                .setBody(requestBody)
                .build();
    }


}
