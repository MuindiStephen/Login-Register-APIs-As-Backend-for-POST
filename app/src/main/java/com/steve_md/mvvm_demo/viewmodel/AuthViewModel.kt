package com.steve_md.mvvm_demo.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.steve_md.mvvm_demo.utils.authUtils.AuthListener
import com.steve_md.mvvm_demo.utils.constants.Constants.MIN_PASSWORD_LENGTH

class AuthViewModel : ViewModel() {

    // Need to get Email and Password from the UI into our ViewModel
    var email:String? = null
    var password:String? = null

    var authListener: AuthListener? = null

    // Login Activity Model
    fun loginUser(
        view: View
    ) {

        authListener?.onStarted()

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Empty Strings")
        }
        else if (password!!.length < MIN_PASSWORD_LENGTH) {
            authListener?.onFailure("Password is too short")
        }
        else {
            authListener?.onSuccess()
        }
    }



        /* Way 2 Sample
    fun loginUser(

    email:String?,
     password:String?
    ) {

    }*/

}