package com.steve_md.mvvm_demo.utils.authUtils

import android.os.Message

interface AuthListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)
}