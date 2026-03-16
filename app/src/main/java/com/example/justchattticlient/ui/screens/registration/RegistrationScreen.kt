package com.example.justchattticlient.ui.screens.registration

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.justchattticlient.R
import com.example.justchattticlient.ui.components.AuthTextField
import com.example.justchattticlient.ui.theme.JustChatttiClientTheme

@Composable
fun RegistrationScreen() {
    var login by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var passRepeat by remember { mutableStateOf("") }
    var v1 by remember { mutableStateOf(false) }
    var v2 by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {


                Box(Modifier.fillMaxWidth()) {
                    Text(
                        text = "Создать\nаккаунт",
                        color = Color.White,
                        fontSize = 47.sp,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 55.sp
                    )
                }

                Spacer(Modifier.height(40.dp))

                AuthTextField(login, {login = it}, "Имя пользователя", R.drawable.user_icon)
                Spacer(Modifier.height(15.dp))

                AuthTextField(pass, {pass = it}, "Пароль", R.drawable.lock_icon,
                    isPassword = true, passwordVisible = v1, onVisibilityClick = {v1 = !v1})
                Spacer(Modifier.height(15.dp))

                AuthTextField(passRepeat, {passRepeat = it}, "Повторите пароль", R.drawable.lock_icon,
                    isPassword = true, passwordVisible = v2, onVisibilityClick = {v2 = !v2})


                Spacer(Modifier.height(40.dp))

                Button(
                    onClick = { /* TODO: Регистрация */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(13.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1E2124) // Подбери цвет под свою тему
                    )
                ) {
                    Text("Регистрация", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }

                Spacer(Modifier.height(20.dp))

                Row {
                    Text(text = "Уже есть аккаунт? ", color = Color.Gray)
                    Text(
                        text = "Вход",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable { /* TODO: Переход на логин */ }
                    )
                }
            }
        }
    }
}



@Preview
@Composable
fun LoginScreenPreview() {
    JustChatttiClientTheme(dynamicColor = false) {
        RegistrationScreen()
    }
}