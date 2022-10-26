package com.steve_md.mvvm_demo.utils.viewUtils

import android.content.Context
import android.widget.Toast

// Extension functions to perform Toast
// In stead of direct Toast Declaration in override functions of AuthListener in LoginActivity

fun Context.toast(text: String) {
    Toast.makeText(
        applicationContext,
        text,
        Toast.LENGTH_LONG
    ).show()
}