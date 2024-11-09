package com.example.walkie_talkie.system.presentation.app_design.ui.componant.woki_toki_screen.status_bar


import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walkie_talkie.R.drawable.signal_ic
import com.example.walkie_talkie.R.drawable.sunny_ic
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.ui_thames.theme.digital
import kotlinx.coroutines.delay

// the function that will set the status bar

@Composable
fun StatusBar(
    century: String ,
    city: String ,
    modifier: Modifier ,
    backGround: Color
) {

    var currentTime by remember { mutableStateOf(currentTime()) }
    var textWidth by remember { mutableStateOf(0f) }
    var animationTarget by remember { mutableStateOf(1000f) }
    val offsetX by animateFloatAsState(
        targetValue = animationTarget ,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 5000 , easing = LinearEasing) ,
            repeatMode = RepeatMode.Restart
        )
    )
    LaunchedEffect(key1 = textWidth) {
        animationTarget = -textWidth
    }

    LaunchedEffect(Unit) {
        while (true) {
            currentTime = currentTime()
            delay(1000)
        }
    }

    Row(
        horizontalArrangement = Arrangement.End ,
        verticalAlignment = Alignment.Top ,
        modifier = modifier
            .fillMaxWidth()
            .height(20.dp)
            .background(color = backGround)
    ) {
        Text(
            text = currentTime ,
            color = lightBlue ,
            fontSize = 20.sp ,
            fontFamily = digital ,
            modifier = Modifier.padding(start = 24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            imageVector = ImageVector.vectorResource(signal_ic) ,
            contentDescription = null ,
            tint = lightBlue ,
            modifier = Modifier
                .height(20.dp)
                .width(20.dp)

        )
        Spacer(modifier = Modifier.weight(1F))
        Icon(
            imageVector = ImageVector.vectorResource(id = sunny_ic) ,
            contentDescription = null ,
            tint = lightBlue ,
            modifier = Modifier
                .height(20.dp)
                .width(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        GetTemperature(temp = "-25")
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "$city  ,  $century" ,
            color = lightBlue ,
            fontSize = 20.sp ,
            fontFamily = digital ,
            modifier = Modifier
                .height(20.dp)
                .padding(end = 24.dp)
                .width(100.dp)
                .basicMarquee(
                    animationMode = MarqueeAnimationMode.Immediately ,
                    initialDelayMillis = 0 ,
                    velocity = 30.dp ,
                    iterations = Int.MAX_VALUE
                )



        )
        /*    MovingText(
                text = "Toronto canada" , containerWidth = 90.dp , modifier = Modifier
                    .height(20.dp)
                    .width(90.dp)
                    .padding(end = 24.dp)
            )*/
    }

}

