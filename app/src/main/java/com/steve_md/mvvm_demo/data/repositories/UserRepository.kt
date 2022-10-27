package com.steve_md.mvvm_demo.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.steve_md.mvvm_demo.data.network.LoginUser
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


// Interact with the Backend API

class UserRepository {
    fun userLogin(email: String , password: String) : LiveData<String> {
        val loginResponse = MutableLiveData<String>()

        LoginUser.api.userLoginService(email, password)
            .enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful){
                        // return the body of the response if it is successful
                        loginResponse.value = response.body()?.string()
                    } else {
                        // if unsuccessful return the body of the error
                        loginResponse.value = response.errorBody()?.string()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    loginResponse.value = t.message   // A Throwable exception
                }

            })
        return loginResponse
    }
}