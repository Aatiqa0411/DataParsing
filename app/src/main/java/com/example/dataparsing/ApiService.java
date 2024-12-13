package com.example.dataparsing;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/posts")
    Call<List<Post>> getAllPosts();

    @GET("/posts/{id}")
    Call<Post> getPost(@Path("id") int postId);

    @GET("/posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);

    @PUT("/posts/{id}")
    Call<Post> updatePost(@Path("id") int postId, @Body Post post);

    @DELETE("/posts/{id}")
    Call<Void> deletePost(@Path("id") int postId);
}
