package com.steve_md.mvvm_demo.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.steve_md.mvvm_demo.R
import com.steve_md.mvvm_demo.data.network.responses.AuthResponse
import com.steve_md.mvvm_demo.databinding.ActivityLoginBinding
import com.steve_md.mvvm_demo.utils.viewUtils.toast
import com.steve_md.mvvm_demo.utils.authUtils.AuthListener
import com.steve_md.mvvm_demo.utils.viewUtils.show
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
        val progressBar:ProgressBar = findViewById(R.id.progressBar)
        progressBar.show()
    }

    override fun onSuccess(user: AuthResponse?) {
       toast("${user?.timestamp} is Logged in")
    }

    override fun onFailure(message: String?) {
        toast(message!!)
    }

}