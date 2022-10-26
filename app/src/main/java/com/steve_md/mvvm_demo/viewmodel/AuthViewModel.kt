package com.steve_md.mvvm_demo.viewmodel

import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    // Need to get Email and Password from the UI into our ViewModel
    var email:String? = null
    var password:String? = null



}