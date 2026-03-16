package com.example.justchattticlient.data

class RegisterRequest (
    val password: String,
    val password_confirm: String,
    val user_metadata: List<SomeUserData>,
    val username: String
    )

data class SomeUserData (
    val damn: String,
    val example: String
)