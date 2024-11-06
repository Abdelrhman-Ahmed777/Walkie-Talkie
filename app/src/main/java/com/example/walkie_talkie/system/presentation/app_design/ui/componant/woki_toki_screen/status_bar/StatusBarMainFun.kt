package com.example.walkie_talkie.system.presentation.app_design.ui.componant.woki_toki_screen.status_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walkie_talkie.R.drawable.signal_ic
import com.example.walkie_talkie.R.drawable.sunny_ic
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.ui.theme.digital

// the function that will set the status bar
@Preview(showBackground = true)
@Composable
fun StatusBar() {
    Row(
        horizontalArrangement = Arrangement.End ,
        verticalAlignment = Alignment.Top ,
        modifier = Modifier
            .fillMaxWidth()
            .height(20.dp)
            .background(darkBlue)

    ) {
        Text(
            text = currentTime() ,
            color = lightBlue ,
            fontSize = 20.sp ,
            fontFamily = digital ,
            modifier = Modifier
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
            text = "Toronto   canada" ,
            color = lightBlue ,
            fontSize = 20.sp ,
            fontFamily = digital ,
            modifier = Modifier
                .height(20.dp)
                .width(80.dp)

        )
        //  MovingText("Toronto canada")


    }

}