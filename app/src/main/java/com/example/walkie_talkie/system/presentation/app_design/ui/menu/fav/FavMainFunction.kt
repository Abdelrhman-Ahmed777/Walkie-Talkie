package com.example.walkie_talkie.system.presentation.app_design.ui.menu.fav


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.walkie_talkie.system.presentation.app_design.ui.menu.MenuWokiTokiScreen
import com.example.walkie_talkie.ui_thames.DarkColorScheme.black
import com.example.walkie_talkie.ui_thames.DarkColorScheme.darkBlue2
import com.example.walkie_talkie.ui_thames.DarkColorScheme.lightBlue
import com.example.walkie_talkie.ui_thames.DarkColorScheme.midPurple

@Preview(showBackground = true)
@Composable
fun FavMainFunction() {
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
            .fillMaxSize()
            .background(background) ,
    ) {
        ConstraintLayout(Modifier.fillMaxSize()) {
            val (screen , Items) = createRefs()


            Box(Modifier
                .constrainAs(screen) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .clip(RoundedCornerShape(bottomStart = 50.dp , bottomEnd = 50.dp)))
            {
                MenuWokiTokiScreen("Favourites")
            }
            LazyColumn(
                Modifier
                    .constrainAs(Items) {
                        top.linkTo(screen.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {

            }

        }

    }
}