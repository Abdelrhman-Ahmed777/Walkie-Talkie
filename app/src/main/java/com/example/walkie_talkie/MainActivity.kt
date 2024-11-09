package com.example.walkie_talkie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.walkie_talkie.system.MyApp
import com.example.walkie_talkie.theme.Walkie_TalkieDarkTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Walkie_TalkieDarkTheme {
                val systemUiController = rememberSystemUiController()
                systemUiController.isSystemBarsVisible = false
                MyApp()
            }
        }
    }
}


