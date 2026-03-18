package com.example.justchattticlient.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.justchattticlient.ui.screens.chats.ChatsScreen
import com.example.justchattticlient.ui.screens.login.LoginScreen
import com.example.justchattticlient.ui.screens.registration.RegistrationScreen


@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login
    ) {
        composable<Screen.Login> {
            LoginScreen(navController = navController)
        }

        composable<Screen.Registration> {
            RegistrationScreen(navController = navController)
        }

        composable<Screen.Chats> {
            ChatsScreen(navController = navController)
        }
    }

}
