package com.spotify.api;

import com.spotify.pojo.Playlist;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static com.spotify.api.SpecBuilder.getRequestSpec;
import static com.spotify.api.SpecBuilder.getResponseSpecification;

public class RestResource {
    public static Response post(String path,String token,Object requestPlaylist){
        return  RestAssured.given(getRequestSpec()).
                header("Authorization","Bearer "+token).
                body(requestPlaylist).
                when().
                post(path).
                then().
                spec(getResponseSpecification()).
                extract().response();

    }

    public static Response get(String path,String token){
        return RestAssured.given(getRequestSpec()).
                header("Authorization","Bearer "+token).
                when().
                get(path).
                then().
                spec(getResponseSpecification()).
                extract().response();
    }

    public static Response update(String path,String token,Object requestPlaylist){
        return RestAssured.given(getRequestSpec()).
                header("Authorization","Bearer "+token).
                body(requestPlaylist).
                when().
                put(path).
                then().
                spec(getResponseSpecification()).
                extract().response();
    }
}
