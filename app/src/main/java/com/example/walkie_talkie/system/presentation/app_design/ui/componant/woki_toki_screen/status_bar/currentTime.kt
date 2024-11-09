package com.example.walkie_talkie.system.presentation.app_design.ui.componant.woki_toki_screen.status_bar

import android.annotation.SuppressLint
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@SuppressLint("NewApi")
fun currentTime() : String {
    val currentTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("hh:mm: a")
    return currentTime.format(formatter)
}

