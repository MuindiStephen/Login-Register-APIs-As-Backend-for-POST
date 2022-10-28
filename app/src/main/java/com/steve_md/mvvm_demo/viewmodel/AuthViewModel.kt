package com.steve_md.mvvm_demo.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.steve_md.mvvm_demo.data.repositories.UserRepository
import com.steve_md.mvvm_demo.data.room_database.User
import com.steve_md.mvvm_demo.utils.ApiException
import com.steve_md.mvvm_demo.utils.Coroutines
import com.steve_md.mvvm_demo.utils.authUtils.AuthListener
import com.steve_md.mvvm_demo.utils.constants.Constants.MIN_PASSWORD_LENGTH

class AuthViewModel (
        private val repository: UserRepository
        ) : ViewModel() {

    // Need to get Email and Password from the UI into our ViewModel
    var email:String? = null
    var password:String? = null

    var authListener: AuthListener? = null

    // Login Activity Model
    @SuppressLint("SuspiciousIndentation")
    fun loginUser() {

        authListener?.onStarted()

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Empty Strings")

            return
        }
        else if (password!!.length < MIN_PASSWORD_LENGTH) {
            authListener?.onFailure("Password is too short")
            return
        }

        // val loginResponse = UserRepository().userLogin(email!!,password!!)
        //authListener?.onSuccess(loginResponse)

        Coroutines.main {

            try {
                val authResponse = repository.userLogin(email!!,password!!)

                authResponse.let {
                    authListener?.onSuccess(User(null,null,null))
                }

            } catch (e: ApiException) {
                authListener?.onFailure(e.message)
            }
        }
    }



        /* Way 2 Sample
    fun loginUser(

    email:String?,
     password:String?
    ) {

    }*/

}