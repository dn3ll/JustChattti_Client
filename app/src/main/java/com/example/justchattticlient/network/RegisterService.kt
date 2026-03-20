package com.example.justchattticlient.network

import com.example.justchattticlient.data.RegisterRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterService {
    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<ResponseBody>
}