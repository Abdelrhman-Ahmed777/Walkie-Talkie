package com.example.walkie_talkie.system.presentation.app_design.ui.screens.home.status

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.walkie_talkie.R
import com.example.walkie_talkie.R.drawable.photo_ic
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.ui_thames.DarkColorScheme.black
import com.example.walkie_talkie.ui_thames.DarkColorScheme.darkBlue2
import com.example.walkie_talkie.ui_thames.DarkColorScheme.lightBlue
import com.example.walkie_talkie.ui_thames.DarkColorScheme.midPurple

@Composable
fun StatusScreen(navController: NavController) {
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
            val (status , newStatusButton , newPhotoButton) = createRefs()
            Button(
                onClick = { } ,
                modifier = Modifier
                    .size(90.dp)
                    .constrainAs(newStatusButton) {
                        bottom.linkTo(parent.bottom , margin = 24.dp)
                        end.linkTo(parent.end , margin = 24.dp)
                    } ,
                colors = ButtonDefaults.buttonColors(
                    darkBlue
                ) ,
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(photo_ic) ,
                    contentDescription = null ,
                    tint = lightBlue ,
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )
            }
            Button(
                onClick = { } ,
                modifier = Modifier
                    .size(70.dp)
                    .constrainAs(newPhotoButton) {
                        bottom.linkTo(newStatusButton.top , margin = 24.dp)
                        end.linkTo(parent.end , margin = 24.dp)
                    } ,
                      colors = ButtonDefaults.buttonColors(
                    darkBlue
                )
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.camera_ic) ,
                    contentDescription = null ,
                    tint = lightBlue ,
                )
            }


        }


    }
}


