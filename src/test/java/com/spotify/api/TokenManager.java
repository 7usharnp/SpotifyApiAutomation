package com.spotify.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.time.Instant;
import java.util.HashMap;

import static com.spotify.api.SpecBuilder.getResponseSpecification;
import static io.restassured.RestAssured.given;

public class TokenManager {

    private static String access_token;
    private static Instant expiry_time;

    public static String getToken(){
        try{
            if(access_token == null || Instant.now().isAfter(expiry_time)){
                System.out.println("Renewing token");
                Response response = renewToken();
                access_token = response.path("access_token");
                expiry_time = Instant.now().plusSeconds(3600);

            }else {
                System.out.println("Using old token..");
            }
        }
        catch (Exception e){
            throw new RuntimeException("ABORT!! Failed to generate Token");
        }
        return access_token;
    }
    public static Response renewToken(){
        HashMap<String,String> formParam = new HashMap<String,String>();
        formParam.put("client_id","ed3f6c865f21439b97b3c3cdad22147e");
        formParam.put("client_secret","8339b7f9c91247d7893d0cad6556b1b8");
        formParam.put("grant_type","client_credentials");

       Response response = given().
                baseUri("https://accounts.spotify.com").
                contentType(ContentType.URLENC).
                formParams(formParam).
                when().post("/api/token").
                then().spec(getResponseSpecification()).
                extract().
                response();

       if(response.statusCode() !=200){
           throw new RuntimeException("ABORT !! Token creation failed......😒");
       }
       return response;
    }


}
