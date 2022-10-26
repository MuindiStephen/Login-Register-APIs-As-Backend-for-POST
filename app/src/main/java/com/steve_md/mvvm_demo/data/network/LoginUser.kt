package com.steve_md.mvvm_demo.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LoginUser {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://registration-postgres.herokuapp.com/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api by lazy { retrofit.create(ApiService::class.java) }
}