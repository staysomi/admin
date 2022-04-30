package com.example.admin.rest;

import com.example.admin.model.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestAPI {
    @GET("example/buku")
    Call<Model> loadListKarbu();
}
