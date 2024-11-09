package com.example.walkie_talkie.system.presentation.app_design.ui.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.walkie_talkie.R
import com.example.walkie_talkie.system.presentation.app_design.ui.componant.woki_toki_screen.status_bar.StatusBar
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.ui_thames.theme.digital

@Composable
fun MenuWokiTokiScreen(page : String  ) {


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(124.dp)
            .background(darkBlue)
            .clip(RoundedCornerShape(bottomStart = 50.dp , bottomEnd = 50.dp))

    ) {
        var isActive = false
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (statusBar , backIcon , pageName , name , typing , online , moreIcon) = createRefs()

            StatusBar(
                "canada",
                "vancouver",
                modifier = Modifier.constrainAs(statusBar) {
                    top.linkTo(parent.top , margin = 10.dp)
                    start.linkTo(parent.start , margin = 8.dp)
                    end.linkTo(parent.end , margin = 8.dp)
                } ,
                backGround = darkBlue
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.back_ic) ,
                contentDescription = null ,
                modifier = Modifier.constrainAs(backIcon) {
                    top.linkTo(statusBar.bottom , margin = 32.dp)
                    start.linkTo(parent.start , margin = 16.dp)
                } , tint = lightBlue

            )


            Text(
                text = page ,
                color = lightBlue ,
                fontFamily = digital ,
                fontSize = 36.sp ,
                modifier = Modifier.constrainAs(pageName) {
                    top.linkTo(statusBar.bottom , margin = 24.dp)
                    start.linkTo(backIcon.end , margin = 16.dp)
                } ,
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.more_ic) ,
                contentDescription = null ,
                tint = lightBlue ,
                modifier = Modifier
                    .size(40.dp)
                    .constrainAs(moreIcon) {
                        top.linkTo(statusBar.bottom , margin = 24.dp)
                        end.linkTo(parent.end , margin = 24.dp)
                    }
                    .clickable {

                    }
            )
        }
    }
}


