package com.steve_md.mvvm_demo.utils.authUtils

import com.steve_md.mvvm_demo.data.room_database.User

interface AuthListener {
    fun onStarted()
    fun onFailure(message: String?)
    fun onSuccess(user: User)
}