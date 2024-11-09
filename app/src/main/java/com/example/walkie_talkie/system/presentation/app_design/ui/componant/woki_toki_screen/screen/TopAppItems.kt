package com.example.walkie_talkie.system.presentation.app_design.ui.componant.woki_toki_screen.screen

import androidx.compose.ui.graphics.vector.ImageVector

data class TopAppItems(
    val title: String ,
    val selectedIcon: ImageVector ,
    val color: androidx.compose.ui.graphics.Color ,
    var hasNews: Boolean ,
    val badgeCount: Int? = null ,
)
