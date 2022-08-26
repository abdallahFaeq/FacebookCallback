package com.example.facebookv2callback.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.facebookv2callback.R;
import com.example.facebookv2callback.pojo.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PostAdapter postAdapter;
    RecyclerView recyclerView;
    PostViewModel postViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);

        postViewModel.getPosts();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        postAdapter = new PostAdapter();
        recyclerView.setAdapter(postAdapter);



        postViewModel.postMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                postAdapter.setList(postModels);
            }
        });

    }
}
/* to convert from callBack to RxJava follow this steps:
    1. add RxJava dependency
    2. convert from call to observable by adding adapterRxJava
    this adapter convert call to observable.
    3. observer
    4. operators
 */