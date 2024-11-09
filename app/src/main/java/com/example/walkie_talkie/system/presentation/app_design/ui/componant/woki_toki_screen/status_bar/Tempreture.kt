package com.example.walkie_talkie.system.presentation.app_design.ui.componant.woki_toki_screen.status_bar

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.ui_thames.theme.digital


// get the temperature from the API
@Composable
fun GetTemperature(temp: String)  {
    Text(
        text = temp,
        fontSize = 20.sp,
        maxLines = 1,
        color = lightBlue,
        fontFamily = digital
    )
}