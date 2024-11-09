package com.example.walkie_talkie.system.presentation.app_design.ui.screens.ai.ai_chat_room

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.walkie_talkie.R
import com.example.walkie_talkie.system.presentation.app_design.ui.componant.woki_toki_screen.status_bar.StatusBar
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.ui_thames.theme.digital

@OptIn(ExperimentalLayoutApi::class)
@Preview(showBackground = true)
@Composable

fun ChatWikiTokiScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(124.dp)
            .background(darkBlue)
            .imeNestedScroll() ,
    ) {
        var isActive = false
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (statusBar , backIcon , userProfile , name , typing , online , moreIcon) = createRefs()

            StatusBar(
                "canada" ,
                "vancouver" ,
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
            Image(
                painter = painterResource(id = R.drawable.robot_profile) ,
                contentDescription = "user profile" ,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(60.dp)
                    .aspectRatio(1f)
                    .clickable(enabled = true , onClick = {

                    })
                    .constrainAs(userProfile) {
                        top.linkTo(statusBar.bottom , margin = 16.dp)
                        start.linkTo(backIcon.end , margin = 16.dp)
                    }
            )

            Text(
                text = "llama" ,
                color = lightBlue ,
                fontFamily = digital ,
                fontSize = 20.sp ,
                modifier = Modifier.constrainAs(name) {
                    top.linkTo(statusBar.bottom , margin = 24.dp)
                    start.linkTo(userProfile.end , margin = 16.dp)
                } ,
            )
            Text(
                text = "typing..." ,
                color = lightBlue ,
                style = TextStyle(fontWeight = FontWeight.Bold) ,
                fontSize = 16.sp ,
                modifier = Modifier.constrainAs(typing) {
                    top.linkTo(name.bottom , margin = 8.dp)
                    start.linkTo(userProfile.end , margin = 16.dp)
                } ,
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.seen_ic) ,
                contentDescription = null ,
                tint = if (isActive) Green else Red ,
                modifier = Modifier
                    .border(1.dp , lightBlue , CircleShape)
                    .constrainAs(online) {
                        top.linkTo(statusBar.bottom , margin = 16.dp)
                        end.linkTo(parent.end , margin = 24.dp)
                    }

            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.more_ic) ,
                contentDescription = null ,
                tint = lightBlue ,
                modifier = Modifier
                    .constrainAs(moreIcon) {
                        top.linkTo(online.bottom , margin = 16.dp)
                        end.linkTo(parent.end , margin = 24.dp)
                    }
                    .clickable {

                    }
            )
        }
    }
}
