package com.spotify.tests;

import com.spotify.api.applicationApi.PlaylistApi;
import com.spotify.pojo.Playlist;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class PlaylistTests {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;



    @Test
    public void shouldBeAbleToCreateAPlaylist(){
        Playlist requestPlaylist = new Playlist().
                setName("New Playlist").
                setDescription("New Playlist Description").
                set_Public(false);

       Response response = PlaylistApi.post(requestPlaylist);
       assertThat(response.statusCode(),equalTo(200));
       Playlist responsePlaylist = response.as(Playlist.class);

       assertThat(responsePlaylist.getName(),equalTo(requestPlaylist.getName()));
       assertThat(responsePlaylist.getDescription(),equalTo(requestPlaylist.getDescription()));
       assertThat(responsePlaylist.get_public(),equalTo(requestPlaylist.get_public()));



    }

    @Test
    public void shouldBeAbleToGetAPlaylist(){
        Playlist requestPlaylist = new Playlist().
                setName("New Playlist").
                setDescription("New Playlist Description").
                set_Public(false);
       Response response = PlaylistApi.get("4rad8gpZSq3Z2AXfQu1bfD");
        Playlist responsePlaylist  = response.as(Playlist.class);
        assertThat(responsePlaylist.getName(),equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(),equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.get_public(),equalTo(requestPlaylist.get_public()));


    }

    @Test
    public void shouldBeAbleToUpdatePlaylist(){
        Playlist requestPlaylist = new Playlist().
                setName("New Playlist").
                setDescription("New Playlist Description").
                set_Public(false);
        Response response = PlaylistApi.update(requestPlaylist,"4rad8gpZSq3Z2AXfQu1bfD");
        Playlist responsePlaylist  = response.as(Playlist.class);
        assertThat(responsePlaylist.getName(),equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(),equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.get_public(),equalTo(requestPlaylist.get_public()));


    }
    @Test
    public void shouldNotBeAbleToCreatePlaylistWithName(){
        String payload = "{\n" +
                "    \"name\": \"\",\n" +
                "    \"description\": \"New playlist description\",\n" +
                "    \"public\": false\n" +
                "}";
        given(requestSpecification).
                body(payload).
                when().
                post("/users/c0sb51wjod0fli2g7k0r2lc5e/playlists").
                then().
                spec(responseSpecification).
                assertThat().
                statusCode(401);
    }


}
