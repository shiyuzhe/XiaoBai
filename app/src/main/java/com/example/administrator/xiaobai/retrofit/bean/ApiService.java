package com.example.administrator.xiaobai.retrofit.bean;

import com.example.administrator.xiaobai.retrofit.base.BaseBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("Book")
    Observable<BaseBean<BookBean>> getBook(@Query("id") long id);

    @GET("LatestBooks")
    Observable <BaseBean<List<BookBean>>> getBooks(@Query("start") int start, @Query("end") int end);

    @GET("Teacher")
    Observable<BaseBean<TeacherBean>> getTeacher(@Query("id") long id);

    @GET("LatestTeachers")
    Observable <BaseBean<List<TeacherBean>>> getTeachers(@Query("start") int start, @Query("end") int end);
}
