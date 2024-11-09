package com.example.walkie_talkie.system.presentation.app_design.navigation


sealed class Screen(val route: String) {

    // page routes
    data object MainScreen : Screen("main_screen")
    data object Chats : Screen("chats")
    data object Channels : Screen("groups")
    data object Status : Screen("stories")
    data object Ai : Screen("ai")
    data object Fav : Screen("favorite")
    data object Arch : Screen("archive")
    data object Settings : Screen("search")
    data object LockedChats : Screen("locked_chats")
    data object Thames : Screen("thames")
    data object Privacy : Screen("privacy")
    data object Notifications : Screen("notifications")
    data object Updates : Screen("updates")
    data object Help : Screen("help")
    data object AiSetting : Screen("ai_setting")
    data object Error : Screen("error")
    data object AuthScreen1 : Screen("auth_screen_1")
    data object AuthScreen2 : Screen("auth_screen_2")
    data object AuthScreen3 : Screen("auth_screen_3")
    data object Login : Screen("login")
    data object Signup : Screen("signup")
    data object ForgotPassword : Screen("forgot_password")
    data object Verification : Screen("verification")


    // groups routes
    data object Home_graph : Screen("home_gram")
    data object Settings_graph : Screen("settings_graph")
    data object Menu : Screen("menu")
    data object Authentication : Screen("authentication")
  //  data object Friends : Screen("friends")
    data object AI_graph : Screen("chat")


}

