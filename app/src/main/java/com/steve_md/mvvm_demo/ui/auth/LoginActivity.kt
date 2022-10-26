package com.steve_md.mvvm_demo.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelStore
import com.steve_md.mvvm_demo.R
import com.steve_md.mvvm_demo.databinding.ActivityLoginBinding
import com.steve_md.mvvm_demo.utils.viewUtils.toast
import com.steve_md.mvvm_demo.utils.authUtils.AuthListener
import com.steve_md.mvvm_demo.viewmodel.AuthViewModel


class LoginActivity : AppCompatActivity(), AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        val viewModel  = ViewModelProviders.of(this)[AuthViewModel::class.java]

        //binding.viewmodel = AuthViewModel()

        binding.viewmodel = viewModel

        viewModel.authListener = this

    }

    override fun onStarted() {
        toast("Login Started")
    }

    override fun onSuccess() {
        toast("Login Success")
    }

    override fun onFailure(message: String) {
        toast(message)
    }

}