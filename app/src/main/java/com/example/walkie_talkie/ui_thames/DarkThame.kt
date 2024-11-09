package com.example.walkie_talkie.ui_thames

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


/*
val darkTheme = MaterialTheme (
     DarkColorScheme,
    content = {

    }
)
*/


object DarkColorScheme {
    val black = Color(0xFF000000)
    val white = Color(0xFFFFFFFF)
    val lightBlue = Color(0xFF40a3ff)
    val midBlue = Color(0xFF142A62)
    val darkBlue = Color(0xFF152946)
    val darkBlue2 = Color(0xFF051935)
    val darkPurple = Color(0xFF350750)
    val midPurple = Color(0xFF571081)
    val lightPurple = Color(0xFF7616AF)
    val background :Brush = Brush.verticalGradient(
        colors = listOf(
            black,
            darkBlue2,
            darkPurple,
            midPurple,
            darkBlue,
            lightBlue
        )
    )
}


