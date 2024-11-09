package com.example.walkie_talkie.system.presentation.app_design.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.Auth(navController: NavController) {
    navigation(
        startDestination = Screen.AuthScreen1.route ,
        Screen.Authentication.route ,
    ) {
        composable(Screen.AuthScreen1.route) {}
        composable(Screen.AuthScreen2.route) {}
        composable(Screen.AuthScreen3.route) {}
        composable(Screen.Login.route) {}
        composable(Screen.Signup.route) {}
        composable(Screen.ForgotPassword.route) {}
        composable(Screen.Verification.route) {}
    }
}