package com.example.justchattticlient.network

import com.example.justchattticlient.data.LoginRequest
import com.example.justchattticlient.data.LoginResult
import com.google.gson.Gson


class AuthRepository {
    private val authService = NetworkClient.retrofit.create(AuthService::class.java)
    private val gson = Gson()

    suspend fun login(request: LoginRequest): LoginResult {
        return try {
            val response = authService.login(request)
            val responseBody = response.body()?.string()
            val errorBody = response.errorBody()?.string()

            when (response.code()) {
                200 -> gson.fromJson(responseBody, LoginResult.Success::class.java)
                400 -> gson.fromJson(errorBody, LoginResult.Error400::class.java)
                422 -> gson.fromJson(errorBody, LoginResult.Error422::class.java)
                500 -> LoginResult.Error500("Ошибка сервера")
                else -> LoginResult.Error500("Неизвестная ошибка")
            }
        } catch (e: Exception) {
            LoginResult.Error500("Нет связи с сервером: ${e.message}")
        }
    }
}
