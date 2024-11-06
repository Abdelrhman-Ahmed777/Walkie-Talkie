package com.example.walkie_talkie.system.presentation.app_design.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController


// the navigation graph
@Composable
fun NestedNavigationGraph() {

    val navController = rememberNavController()

    NavHost(
        navController ,
        startDestination = Screen.Home.route
    ) {
        home(navController)
        menu(navController)
        aiScreen(navController)
        settings(navController)
        authentication(navController)
    }
}


