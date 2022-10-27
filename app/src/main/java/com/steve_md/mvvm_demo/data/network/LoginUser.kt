package com.steve_md.mvvm_demo.data.network

import com.steve_md.mvvm_demo.utils.constants.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LoginUser {
    var retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api by lazy { retrofit.create(ApiService::class.java) }
}