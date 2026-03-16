package com.example.justchattticlient.ui.login

import android.R.attr.password
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.justchattticlient.data.LoginRequest
import com.example.justchattticlient.data.LoginResult
import com.example.justchattticlient.network.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {
    private val repository = AuthRepository()
    var loginResult by mutableStateOf<LoginResult?>(null)
        private set
    fun doLogin(login: String, password: String) {
        viewModelScope.launch {
            val logindata = LoginRequest(
                password = password,
                username = login
            )
            val result = repository.login(logindata)
            loginResult = result
        }
    }
}