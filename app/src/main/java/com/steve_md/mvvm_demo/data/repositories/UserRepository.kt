package com.steve_md.mvvm_demo.data.repositories

import com.steve_md.mvvm_demo.data.network.LoginUser
import com.steve_md.mvvm_demo.data.network.SafeApiRequest
import com.steve_md.mvvm_demo.data.network.responses.AuthResponse


// Interact with the Backend API

class UserRepository(
    private val myApi: AuthResponse
)
    : SafeApiRequest() {
   suspend fun userLogin(email: String , password: String): String {
       //val loginResponse = MutableLiveData<String>()

//        LoginUser.api.userLoginService(email, password)
//            .enqueue(object : Callback<ResponseBody> {
//                override fun onResponse(
//                    call: Call<ResponseBody>,
//                    response: Response<ResponseBody>
//                ) {
//                    if (response.isSuccessful){
//                        // return the body of the response if it is successful
//                        loginResponse.value = response.body()?.string()
//                    } else {
//                        // if unsuccessful return the body of the error
//                        loginResponse.value = response.errorBody()?.string()
//                    }
//                }
//
//                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                    loginResponse.value = t.message   // A Throwable exception
//                }
//
//            })
       // return loginResponse


       return apiRequest<AuthResponse> { LoginUser.api.userLoginService(email, password) }

   }
}