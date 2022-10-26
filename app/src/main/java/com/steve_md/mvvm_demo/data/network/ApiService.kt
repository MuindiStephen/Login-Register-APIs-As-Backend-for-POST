package com.steve_md.mvvm_demo.data.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
   @POST("login")
    fun userLogin(
        @Field("email") email:String,
        @Field("password") password:String
    ) : Call<ResponseBody>

}