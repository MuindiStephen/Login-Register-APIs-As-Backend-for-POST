package com.steve_md.mvvm_demo.utils.viewUtils

import android.R
import android.app.Activity
import android.content.Context
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

// Extension functions to perform Toast
// In stead of direct Toast Declaration in override functions of AuthListener in LoginActivity

fun Context.toast(text: String) {
    Toast.makeText(
        applicationContext,
        text,
        Toast.LENGTH_SHORT
    ).show()
}

fun Activity.showSnackbar(text: String){
    Snackbar.make(findViewById(R.id.content), text, Snackbar.LENGTH_SHORT)
        .show()
}