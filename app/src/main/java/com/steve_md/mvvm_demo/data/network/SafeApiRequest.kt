package com.steve_md.mvvm_demo.data.network


import com.steve_md.mvvm_demo.data.network.responses.AuthResponse
import okhttp3.ResponseBody
import org.json.JSONException
import retrofit2.Response



// Handle API Exceptions
abstract class SafeApiRequest {

    suspend fun <T : Any> apiRequest(call: suspend () -> Response<AuthResponse>): String {
        val response = call.invoke() // execute that function

        if (response.isSuccessful) {
            return response.body().toString()
        } else {
          return response.errorBody().toString()
        }

    }
}
