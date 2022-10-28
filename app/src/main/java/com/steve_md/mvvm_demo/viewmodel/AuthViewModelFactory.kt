package com.steve_md.mvvm_demo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.steve_md.mvvm_demo.data.network.LoginUser
import com.steve_md.mvvm_demo.data.repositories.UserRepository


// This class creates an instance of ViewModel in User Repository
class AuthViewModelFactory(
    repository: UserRepository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthViewModel(repository = UserRepository(myApi = LoginUser)) as T
    }
}