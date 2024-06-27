package com.spotify.api.applicationApi;

import com.spotify.api.RestResource;
import com.spotify.pojo.Playlist;
import io.restassured.response.Response;

import static com.spotify.api.TokenManager.getToken;

public class PlaylistApi {
    static String token = "";

    public static Response post(Playlist requestPlaylist){
        return RestResource.post("/users/c0sb51wjod0fli2g7k0r2lc5e/playlists",getToken(), requestPlaylist);

    }

    public static Response get(String playlistId){
        return RestResource.get("/playlists/"+playlistId, getToken());

    }

    public static Response update(Playlist requestPlaylist,String playlistId){
        return RestResource.update("/users/"+playlistId+"/playlists",getToken(), requestPlaylist);
    }

}
