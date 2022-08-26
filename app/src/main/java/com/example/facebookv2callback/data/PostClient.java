package com.example.facebookv2callback.data;

import com.example.facebookv2callback.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    private static PostService postService;
    public static PostClient instance;
    private static Retrofit retrofit;
    public PostClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        postService = retrofit.create(PostService.class);
    }

    public static PostClient getPostClient(){
        if (instance == null){
            instance = new PostClient();
        }
        return instance;
    }

    public Call<List<PostModel>> getPosts(){
        return postService.getPosts();
    }

}
