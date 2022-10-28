package com.steve_md.mvvm_demo.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


// Coroutines perform -> to execute code asynchronously (through suspend functions)
object Coroutines {
    fun main(work: suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.IO)  .launch {
            work()
        }                  // Dispatchers handle blocking long-running processes in Kotlin

}