package com.example.walkie_talkie.system.presentation.app_design.ui.screens.home.chats.chat_room

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.walkie_talkie.R
import com.example.walkie_talkie.R.drawable.female_profile
import com.example.walkie_talkie.R.drawable.media_ic
import com.example.walkie_talkie.system.presentation.app_design.ui.componant.woki_toki_screen.status_bar.StatusBar
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.darkBlue2
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.ui_thames.theme.digital

@Preview(showBackground = true)
@Composable
fun ProfileInfo() {
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .background(darkBlue2)
    ) {
        val (profileImage , backIcon , statusBar , column) = createRefs()

        StatusBar(   "canada",
            "vancouver",
            modifier = Modifier
                .constrainAs(statusBar) {
                    top.linkTo(parent.top , margin = 10.dp)
                    start.linkTo(parent.start , margin = 8.dp)
                    end.linkTo(parent.end , margin = 8.dp)
                }, backGround = darkBlue2
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.back_ic) ,
            contentDescription = null ,
            modifier = Modifier
                .constrainAs(backIcon) {
                    top.linkTo(statusBar.bottom , margin = 32.dp)
                    start.linkTo(parent.start , margin = 16.dp)
                    end.linkTo(profileImage.start , margin = 16.dp)
                }
                .size(40.dp) , tint = lightBlue
        )





        Card(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .offset(y = 150.dp)
                .constrainAs(column) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                } ,
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp) ,
            shape = RoundedCornerShape(topStart = 50.dp , topEnd = 50.dp) ,
            colors = CardDefaults.cardColors(containerColor = darkBlue)
        )
        {
            ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                val (name , favName , notificationName , mediaName , bio , gender , notification , media , fav) = createRefs()

                Text(
                    text = "lobna mahmoud" ,
                    color = lightBlue ,
                    modifier = Modifier
                        .constrainAs(name) {
                            top.linkTo(parent.top , margin = 124.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        } ,
                    fontSize = 30.sp ,
                    fontFamily = digital
                )
                Text(
                    text = "lobna loves abdelrahman and abdelrahman loves lobna" ,
                    color = lightBlue ,
                    modifier = Modifier
                        .height(70.dp)
                        .width(350.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(darkBlue2)
                        .padding(16.dp)

                        .constrainAs(bio) {
                            top.linkTo(name.bottom , margin = 16.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        } , fontSize = 18.sp
                )


                Row(
                    verticalAlignment = Alignment.CenterVertically ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .padding(start = 32.dp , end = 32.dp)
                        .constrainAs(mediaName) {
                            top.linkTo(bio.bottom , margin = 16.dp)
                            start.linkTo(parent.start , margin = 32.dp)
                            end.linkTo(parent.end , margin = 32.dp)
                        }
                        .clickable {

                        }) {
                    Text(
                        text = "Media" ,
                        color = lightBlue ,
                        fontSize = 26.sp ,
                        fontFamily = digital ,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = ImageVector.vectorResource(id = media_ic) ,
                        contentDescription = "notification" ,
                        tint = Color.Red ,
                        modifier = Modifier
                            .size(30.dp)
                            .offset(x = 10.dp)
                    )
                }


                LazyRow(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(start = 16.dp , end = 16.dp)
                    .constrainAs(media) {
                        top.linkTo(mediaName.bottom , margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)

                    }
                ) { }

                Row(
                    verticalAlignment = Alignment.CenterVertically ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .padding(start = 32.dp , end = 32.dp)
                        .constrainAs(notification) {
                            top.linkTo(media.bottom , margin = 16.dp)
                            start.linkTo(parent.start , margin = 32.dp)
                            end.linkTo(parent.end , margin = 32.dp)
                        }
                        .clickable {

                        }
                ) {
                    Text(
                        text = "Notification" ,
                        color = lightBlue ,
                        fontSize = 26.sp ,
                        fontFamily = digital ,
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Default.Notifications ,
                        contentDescription = "notification" ,
                        tint = Color.Cyan ,
                        modifier = Modifier
                            .size(30.dp)
                            .offset(x = 10.dp)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .padding(start = 32.dp , end = 32.dp)
                        .constrainAs(fav) {
                            top.linkTo(notification.bottom , margin = 16.dp)
                            start.linkTo(parent.start , margin = 32.dp)
                            end.linkTo(parent.end , margin = 32.dp)
                        }
                        .clickable {

                        }
                ) {
                    Text(
                        text = "Favourite" ,
                        color = lightBlue ,
                        fontSize = 26.sp ,
                        fontFamily = digital ,
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Default.Favorite ,
                        contentDescription = "notification" ,
                        tint = Color.Red ,
                        modifier = Modifier
                            .size(30.dp)
                            .offset(x = 10.dp)
                    )
                }


            }

        }
        Image(
            painter = painterResource(female_profile) ,
            contentDescription = "female_profile" ,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .border(
                    6.dp ,
                    lightBlue ,
                    CircleShape
                )
                .constrainAs(profileImage) {
                    top.linkTo(parent.top , margin = 50.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

    }


}


