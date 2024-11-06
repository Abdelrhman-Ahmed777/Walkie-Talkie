package com.example.walkie_talkie.system.presentation.app_design.ui.home_screens.chats

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.walkie_talkie.system.presentation.app_design.ui.componant.woki_toki_screen.screen.WokiTokiScreen
import com.example.walkie_talkie.ui_thames.DarkColorScheme.black
import com.example.walkie_talkie.ui_thames.DarkColorScheme.darkBlue2
import com.example.walkie_talkie.ui_thames.DarkColorScheme.lightBlue
import com.example.walkie_talkie.ui_thames.DarkColorScheme.midPurple

@Preview(showBackground = true)
@Composable
fun ChatsScreen() {
    val background: Brush = Brush.verticalGradient(
        colors = listOf(
            black ,
            black ,
            darkBlue2 ,
            midPurple ,
            lightBlue
        )
    )
    Box(
        Modifier
            .fillMaxSize()
            .background(background)
    ) {
        ConstraintLayout(
            Modifier
                .fillMaxSize()
        ) {
            Box(Modifier.clip(RoundedCornerShape(bottomEnd = 60.dp , bottomStart = 60.dp))) {
               WokiTokiScreen()
            }
            val (screen , message , addButton , aiButton) = createRefs()

        }
    }
}