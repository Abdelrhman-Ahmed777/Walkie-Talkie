package com.example.walkie_talkie.system.presentation.app_design.ui.screens.home.channels

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.walkie_talkie.R.drawable.add_ic
import com.example.walkie_talkie.R.drawable.robot_ic
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.ui_thames.DarkColorScheme.black
import com.example.walkie_talkie.ui_thames.DarkColorScheme.darkBlue2
import com.example.walkie_talkie.ui_thames.DarkColorScheme.lightBlue
import com.example.walkie_talkie.ui_thames.DarkColorScheme.midPurple
import com.example.walkie_talkie.ui_thames.theme.digital

@Composable
fun ChannelsScreen(navController: NavController) {
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
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(background)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val (chats , newChannelButton ) = createRefs()
            Button(
                onClick = { } ,
                modifier = Modifier
                    .wrapContentWidth()
                    .height(60.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .constrainAs(newChannelButton) {
                        bottom.linkTo(parent.bottom , margin = 24.dp)
                        end.linkTo(parent.end , margin = 24.dp)
                    } , colors = ButtonDefaults.buttonColors(
                    darkBlue
                ) , shape = RectangleShape
            ) { Text(
                text = "ADD CHANNEL" ,
                color = lightBlue ,
                modifier = Modifier,
                fontFamily = digital ,
                fontSize = 24.sp
            )
            }

        }
    }


}

