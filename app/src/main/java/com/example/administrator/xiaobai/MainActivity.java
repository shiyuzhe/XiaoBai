package com.example.administrator.xiaobai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.xiaobai.retrofit.RetrofitFactory;
import com.example.administrator.xiaobai.retrofit.base.BaseBean;
import com.example.administrator.xiaobai.retrofit.base.BaseObserver;
import com.example.administrator.xiaobai.retrofit.bean.ApiService;
import com.example.administrator.xiaobai.retrofit.bean.BookBean;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitFactory.getInstance().getRetrofit().create(ApiService.class).getBooks(1,9).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<BookBean>>() {
                    @Override
                    protected void onSuccees(BaseBean<List<BookBean>> t) throws Exception {

                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

                    }
                });
    }
}
