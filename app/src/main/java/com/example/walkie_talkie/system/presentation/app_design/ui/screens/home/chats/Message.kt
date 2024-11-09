package com.example.walkie_talkie.system.presentation.app_design.ui.screens.home.chats

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.walkie_talkie.R.drawable.seen_ic
import com.example.walkie_talkie.theme.lightBlue

@Preview(showBackground = true)
@Composable
fun Message() {

    var isthereStatus = true
    var bordered = if (isthereStatus) 4.dp else 0.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(Color.Transparent)
    ) {
        ConstraintLayout(Modifier.fillMaxSize()) {
            val (userProfile , name , message , seen , timee , massegeConter) = createRefs()
            AsyncImage(
                model = rememberAsyncImagePainter
                    (model = "android.resource://com.example.walkie_talkie/drawable/user_profile") ,
                contentDescription = "user profile" ,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(70.dp)
                    .aspectRatio(1f)
                    .border(bordered , lightBlue , CircleShape)
                    .clickable(enabled = true , onClick = {})
                    .constrainAs(userProfile) {
                        top.linkTo(parent.top , margin = 8.dp)
                        start.linkTo(parent.start , margin = 8.dp)
                    }
            )

            Text(
                text = "Arthur Morgan" ,
                color = lightBlue ,
                style = TextStyle(fontWeight = FontWeight.Bold) ,
                modifier = Modifier.constrainAs(name) {
                    top.linkTo(userProfile.top , margin = 8.dp)
                    start.linkTo(userProfile.end , margin = 8.dp)
                }
            )

            Text(
                text = "Hello from midgard and i just want to say that i do love you" ,
                color = lightBlue ,
                modifier = Modifier
                    .width(275.dp)
                    .constrainAs(message) {
                        top.linkTo(name.bottom , margin = 8.dp)
                        start.linkTo(userProfile.end , margin = 8.dp)
                    } ,
                maxLines = 1 ,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "12:00" ,
                color = lightBlue ,
                modifier = Modifier
                    .width(300.dp)
                    .constrainAs(timee) {
                        end.linkTo(parent.end)
                        top.linkTo(message.bottom , margin = 8.dp)
                    }
            )
            Icon(
                imageVector = ImageVector.vectorResource(seen_ic) ,
                contentDescription = "seen" ,
                tint = if (true) lightBlue else Color.Gray ,
                modifier = Modifier
                    .constrainAs(seen) {
                        top.linkTo(name.bottom , margin = 8.dp)
                        end.linkTo(parent.end , margin = 8.dp)
                    }
                    .size(20.dp)
            )


        }
    }
}