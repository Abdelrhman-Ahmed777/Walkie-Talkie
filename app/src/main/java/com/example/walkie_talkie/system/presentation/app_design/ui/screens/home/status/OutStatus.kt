package com.example.walkie_talkie.system.presentation.app_design.ui.screens.home.status

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.walkie_talkie.R
import com.example.walkie_talkie.R.drawable.witcher
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.ui_thames.theme.digital

@Preview(showBackground = true)
@Composable
fun OutStatus() {
    Box(
        modifier = Modifier
            .height(180.dp)
            .width(110.dp)
            .shadow(

                elevation = 15.dp ,
                shape = RoundedCornerShape(15.dp),
                spotColor = DefaultShadowColor,
                ambientColor = Color.Black
            )
            .border(1.dp , lightBlue , RoundedCornerShape(15.dp))
            .clip(RoundedCornerShape(15.dp))
            .clickable {

            }
    ) {


        Image(
            painter = painterResource(id = witcher) ,
            contentDescription = "user profile" ,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
                .wrapContentSize(Alignment.Center)
                .aspectRatio(1f)
        )



        ConstraintLayout(Modifier.fillMaxSize()) {
            val (userProfile , name , time) = createRefs()
            Image(painter = painterResource(id = R.drawable.pixel) ,
                contentDescription = "user profile" ,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(30.dp)
                    .background(Color.Gray)
                    .aspectRatio(1f)
                    .border(4.dp , lightBlue , CircleShape)
                    .clickable(enabled = true , onClick = {})
                    .constrainAs(userProfile) {
                        top.linkTo(parent.top , margin = 8.dp)
                        start.linkTo(parent.start , margin = 8.dp)
                    }
            )





            Text(
                text = "Arthur Morgan" ,
                style = TextStyle(
                    color = lightBlue ,
                    fontFamily = digital ,
                    fontSize = 12.sp
                ) ,
                modifier = Modifier.constrainAs(name) {
                    bottom.linkTo(parent.bottom , margin = 8.dp)
                    start.linkTo(parent.start , margin = 8.dp)

                }
            )


        }

    }
}