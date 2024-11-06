package com.example.walkie_talkie.system.presentation.app_design.navigation

sealed class Nav(route: String)  {
    data object Home : Nav(home)
}