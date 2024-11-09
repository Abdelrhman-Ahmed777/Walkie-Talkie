package com.example.walkie_talkie.system.presentation.app_design.ui.screens.home.chats.chat_room

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.walkie_talkie.system.presentation.app_design.ui.componant.woki_toki_screen.status_bar.currentTime
import com.example.walkie_talkie.theme.darkPurple
import com.example.walkie_talkie.theme.lightPurple

@Preview
@Composable
fun Messages() {
    Card(
        modifier = Modifier
            .height(200.dp)
            .width(250.dp)
            .clip(RoundedCornerShape(bottomEnd = 24.dp , bottomStart = 24.dp , topEnd = 24.dp)) ,
        colors = CardDefaults.cardColors(containerColor = lightPurple)
    ) {
        ConstraintLayout(Modifier.fillMaxSize()) {
            val (message , seen , time , isFav) = createRefs()

            Icon(
                imageVector = Icons.Default.Favorite ,
                contentDescription = "Favorite" ,
                tint = Color.Red ,
                modifier = Modifier
                    .size(15.dp)
                    .constrainAs(isFav) {
                        top.linkTo(parent.top , margin = 8.dp)
                        end.linkTo(parent.end , margin = 16.dp)
                    }

            )





            Text(
                text = "The Faroe or Faeroe Islands (/ˈfɛəroʊ/ FAIR-oh), or simply the Faroes (Faroese: Føroyar, pronounced [ˈfœɹjaɹ] ⓘ; Danish: Færøerne [ˈfeɐ̯ˌøˀɐnə]), are an archipelago in the North Atlantic Ocean and an autonomous territory of the Kingdom of Denmark. The official language of the country is Faroese, which is closely related to and partially mutually intelligible with Icelandic.\n" +
                        "" ,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 24.dp , bottom = 24.dp , start = 8.dp , end = 8.dp)
                    .constrainAs(message) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    } , color = Color.White

            )

            Text(
                text = currentTime() ,
                modifier = Modifier.constrainAs(time){
                    bottom.linkTo(parent.bottom , margin = 6.dp)
                    end.linkTo(parent.end , margin = 16.dp)
                }
                , color = darkPurple
            )

        }
    }
}