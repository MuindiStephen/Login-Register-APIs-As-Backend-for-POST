package com.steve_md.mvvm_demo.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.steve_md.mvvm_demo.R
import com.steve_md.mvvm_demo.databinding.ActivityLoginBinding
import com.steve_md.mvvm_demo.utils.viewUtils.toast
import com.steve_md.mvvm_demo.utils.authUtils.AuthListener
import com.steve_md.mvvm_demo.viewmodel.AuthViewModel


class LoginActivity : AppCompatActivity(), AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        val viewModel  = ViewModelProviders.of(this)[AuthViewModel::class.java]

        //binding.viewmodel = AuthViewModel()

        binding.viewmodel = viewModel

        viewModel.authListener = this

        binding.dontHaveAccText.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
            finish()
        }

    }

    override fun onStarted() {
        toast("Login Started")
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
       loginResponse.observe(this, Observer {
           toast(it)
       })
    }

    override fun onFailure(message: String) {
        toast(message)
    }

}