package com.example.justchattticlient.network

import com.example.justchattticlient.data.LoginResult
import com.example.justchattticlient.data.RegisterRequest
import com.example.justchattticlient.data.RegisterResult
import com.google.gson.Gson

class RegisterRepository {
    private val registerService = NetworkClient.retrofit.create(RegisterService::class.java)
    private val gson = Gson()

    suspend fun register(request: RegisterRequest): RegisterResult {
        return try {
            val response = registerService.register(request)
            val responseBody = response.body()?.string()
            val errorBody = response.errorBody()?.string()

            when (response.code()) {
                201 -> gson.fromJson(responseBody, RegisterResult.Success::class.java)
                400 -> gson.fromJson(errorBody, RegisterResult.Error400::class.java)
                422 -> gson.fromJson(errorBody, RegisterResult.Error422::class.java)
                500 -> RegisterResult.Error500("Ошибка сервера")
                else -> RegisterResult.Error500("Неизвестная ошибка")
            }
        } catch (e: Exception) {
            RegisterResult.Error500("Нет связи с сервером: ${e.message}")
        }
    }
}

