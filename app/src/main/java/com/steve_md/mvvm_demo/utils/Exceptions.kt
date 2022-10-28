package com.steve_md.mvvm_demo.utils


import java.io.IOException

class ApiException(override var message: String) : IOException(message)