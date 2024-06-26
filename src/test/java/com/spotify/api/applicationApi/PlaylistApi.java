package com.spotify.api.applicationApi;

import com.spotify.api.RestResource;
import com.spotify.api.TokenManager;
import com.spotify.pojo.Playlist;
import io.restassured.response.Response;

import static com.spotify.api.TokenManager.renewToken;

public class PlaylistApi {
    static String token = "";

    public static Response post(Playlist requestPlaylist){
        return RestResource.post("/users/c0sb51wjod0fli2g7k0r2lc5e/playlists",renewToken(), requestPlaylist);

    }

    public static Response get(String playlistId){
        return RestResource.get("/playlists/"+playlistId, renewToken());

    }

    public static Response update(Playlist requestPlaylist,String playlistId){
        return RestResource.update("/users/"+playlistId+"/playlists",renewToken(), requestPlaylist);
    }

}
