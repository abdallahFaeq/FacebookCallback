package com.example.facebookv2callback.data;

import com.example.facebookv2callback.pojo.PostModel;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
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
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
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

    public Observable<List<PostModel>> getPosts(){
        return postService.getPosts();
    }

}
