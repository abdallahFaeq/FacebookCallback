package com.example.facebookv2callback.ui.main;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.facebookv2callback.data.PostClient;
import com.example.facebookv2callback.pojo.PostModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    MutableLiveData<List<PostModel>> postMutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> posts = new MutableLiveData<>();

    public void getPosts(){
         Observable<List<PostModel>> observable = PostClient.getPostClient().getPosts()
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread());


        Observer observer = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                postMutableLiveData.setValue((List<PostModel>) o);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("error", e.getMessage()+"");
            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);
    }
}
