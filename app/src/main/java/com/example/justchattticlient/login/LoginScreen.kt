package com.example.justchattticlient.login

import android.R.attr.text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.justchattticlient.ui.theme.DTTextFieldBg
import com.example.justchattticlient.ui.theme.DTTextFieldBorder
import com.example.justchattticlient.R
import com.example.justchattticlient.ui.theme.JustChatttiClientTheme

@Composable
fun LoginScreen() {
    var loginText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
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
                    modifier = Modifier.matchParentSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Box(Modifier.fillMaxWidth()) {
                        Text(
                            text = "Вход\nв аккаунт",
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 47.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    VerticalDivider(Modifier.height(40.dp))

                    OutlinedTextField(
                        value = loginText,
                        onValueChange = { loginText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        shape = RoundedCornerShape(13.dp),
                        placeholder = {
                            Text("Имя пользователя", color = DTTextFieldBorder)
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = DTTextFieldBg,
                            unfocusedContainerColor = DTTextFieldBg,
                            focusedBorderColor = DTTextFieldBorder,
                            unfocusedBorderColor = Color.Transparent,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            cursorColor = DTTextFieldBorder
                        ),
                        singleLine = true,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.user_icon),
                                contentDescription = null,
                                tint = DTTextFieldBorder
                            )
                        }
                    )

                    VerticalDivider(Modifier.height(15.dp))

                    var passwordVisible by remember { mutableStateOf(false) }

                    OutlinedTextField(
                        value = passwordText,
                        onValueChange = { passwordText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        shape = RoundedCornerShape(13.dp),
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        placeholder = {
                            Text("Пароль", color = DTTextFieldBorder)
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = DTTextFieldBg,
                            unfocusedContainerColor = DTTextFieldBg,
                            focusedBorderColor = DTTextFieldBorder,
                            unfocusedBorderColor = Color.Transparent,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            cursorColor = DTTextFieldBorder
                        ),
                        singleLine = true,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.lock_icon),
                                contentDescription = null,
                                tint = DTTextFieldBorder
                            )
                        },
                        trailingIcon = {
                            IconButton(
                                onClick = { passwordVisible = !passwordVisible },
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            {
                                Icon(
                                    imageVector = if (passwordVisible) Icons.Outlined.Visibility else Icons.Outlined.VisibilityOff,
                                    contentDescription = if (passwordVisible) "Скрыть" else "Показать",
                                    tint = DTTextFieldBorder.copy(alpha = 0.8f)
                                )
                            }
                        }
                    )

                    VerticalDivider(Modifier.height(15.dp))

                    Text(
                        modifier = Modifier.align(Alignment.End),
                        text = "Забыли пароль?",
                        color = DTTextFieldBorder,
                        )

                    VerticalDivider(Modifier.height(15.dp))

                    Button(onClick = {TODO()}, modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                        shape = RoundedCornerShape(13.dp),
                        )
                    {
                        Text("Вход", color = Color.White, fontSize = 18.sp)
                    }
                }
            }
        }
}


@Preview
@Composable
fun LoginScreenPreview() {
    JustChatttiClientTheme(dynamicColor = false) {
        LoginScreen()
    }
}