package com.steve_md.mvvm_demo.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.steve_md.mvvm_demo.R
import com.steve_md.mvvm_demo.ui.auth.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        Handler().postDelayed(
            {
                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                finish()
            }, 3000
        )
    }
}