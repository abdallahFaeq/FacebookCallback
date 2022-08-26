package com.example.facebookv2callback.data;

import com.example.facebookv2callback.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {
    @GET("posts")
    Call<List<PostModel>> getPosts();
}
