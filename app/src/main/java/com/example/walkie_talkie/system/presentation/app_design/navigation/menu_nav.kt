package com.example.walkie_talkie.system.presentation.app_design.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation


fun NavGraphBuilder.Menu(navController: NavController) {
    navigation(
        startDestination = Screen.Fav.route ,
        Screen.Menu.route ,
    ) {
        composable(Screen.Fav.route) {}
        composable(Screen.Arch.route) {}
        composable(Screen.LockedChats.route) {}
        composable(Screen.Settings.route) {}
    }
}