package com.spotify.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {

    static String  access_token = "BQBeuH2Rb1C_K1BF9S0-dR_LXvN62ZHyTDX4spCIG9f6RcD4WXtbw6Yj6WABHiFgAjKI7uVW1I-Q3tircSNOK9ATa8DLFVpVUdZw6NdZ4gMigKzLzrE";
    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder().
                setBaseUri("https://api.spotify.com").
                setBasePath("/v1").
                addHeader("Authorization","Bearer "+access_token).
                setContentType(ContentType.JSON).
                log(LogDetail.ALL).build();

    }

    public static ResponseSpecification getResponseSpecification(){
        return new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }
}
