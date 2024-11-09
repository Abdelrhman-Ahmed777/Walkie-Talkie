package com.example.walkie_talkie.system.presentation.app_design.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost


// the navigation graph
@Composable
fun NestedNavigationGraph(navController: NavHostController , isLoggedIn: Boolean) {

    NavHost(
        navController = navController ,
        startDestination = Screen.Home_graph.route
    ) {
        Home(navController = navController)
        Menu(navController = navController)
        AiScreen(navController = navController)
        Settings(navController = navController)
        Auth(navController = navController)
     //   Friends(navController = navController)

    }


    /*   NavHost(
           navController ,
           startDestination = Screen.Home.route
       ) {
           composable(route = Screen.Home.route) {
               Home(navController)
           }

           navigation(
               startDestination = Screen.Menu.route ,
               route = Screen.Menu.route
           ) {
               composable(route = Screen.Menu.route) {
                   Menu(navController)
               }
           }

           navigation(
               startDestination = Screen.Ai.route ,
               route = Screen.Ai.route
           ) {
               composable(route = Screen.Ai.route) { AiScreen(navController) }

           }
           navigation(
               startDestination = Screen.Settings.route ,
               route = Screen.Settings.route
           ) {
               composable(route = Screen.Settings.route) { Settings(navController) }

           }
           navigation(
               startDestination = Screen.Authentication.route ,
               route = Screen.Authentication.route
           ) {
               composable(route = Screen.Authentication.route) { Auth(navController) }
           }

           navigation(
               startDestination = Screen.Friends.route ,
               route = Screen.Friends.route
           ) {
               composable(route = Screen.Friends.route) { Friends(navController) }
           }
       }*/
}



