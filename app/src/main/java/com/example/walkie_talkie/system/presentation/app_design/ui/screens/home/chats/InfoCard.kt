package com.example.walkie_talkie.system.presentation.app_design.ui.screens.home.chats

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.walkie_talkie.R
import com.example.walkie_talkie.R.drawable.female_profile
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.lightBlue

@Preview(showBackground = true)
@Composable
fun InfoCard() {
    Card(
        modifier = Modifier
            .height(200.dp)
            .width(170.dp)
            .clip(RoundedCornerShape(5.dp)) ,
        colors = CardDefaults.cardColors(containerColor = darkBlue)
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (image , items) = createRefs()

            Image(
                painter = painterResource(id = female_profile) ,
                contentDescription = "Chat info" ,
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .border(2.dp , lightBlue , RoundedCornerShape(15.dp))
                    .clip(RoundedCornerShape(15.dp))
                    .constrainAs(image) {
                        top.linkTo(parent.top , margin = 8.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)

                    }
            )
            Row(
                verticalAlignment = Alignment.CenterVertically ,
                horizontalArrangement = Arrangement.Center ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .height(40.dp)
                    .constrainAs(items) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.message_ic) ,
                    contentDescription = "Message" ,
                    modifier = Modifier
                        .size(20.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .clickable {

                        } ,
                    tint = lightBlue

                )
                Spacer(modifier = Modifier.weight(1F))
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.info_ic) ,
                    contentDescription = "Message" ,
                    modifier = Modifier
                        .size(20.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .clickable {

                        } ,
                    tint = lightBlue

                )
            }
        }

    }
}
