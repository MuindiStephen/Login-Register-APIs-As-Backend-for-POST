package com.steve_md.mvvm_demo.data.network

import com.steve_md.mvvm_demo.data.network.responses.AuthResponse
import com.steve_md.mvvm_demo.utils.constants.Constants.LOGIN_END_POINT
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
   @POST(LOGIN_END_POINT)
    suspend fun userLoginService(
        @Field("email") email:String,
        @Field("password") password:String
    ) : Response<AuthResponse>  // Coroutines at work

}