package com.example.walkie_talkie.system.presentation.app_design.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.walkie_talkie.system.presentation.app_design.ui.componant.woki_toki_screen.screen.WokiTokiScreen
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.home.channels.ChannelsScreen
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.home.chats.ChatsScreen
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.home.status.StatusScreen
import com.example.walkie_talkie.ui_thames.DarkColorScheme.black
import com.example.walkie_talkie.ui_thames.DarkColorScheme.darkBlue2
import com.example.walkie_talkie.ui_thames.DarkColorScheme.lightBlue
import com.example.walkie_talkie.ui_thames.DarkColorScheme.midPurple

@SuppressLint("SuspiciousIndentation")
@Composable
fun HomeScreen(navController: NavController) {
    val background: Brush = Brush.verticalGradient(
        colors = listOf(
            black ,
            black ,
            darkBlue2 ,
            midPurple ,
            lightBlue
        )
    )


    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val pageState = rememberPagerState { 3 }
    LaunchedEffect(selectedTabIndex) {
        pageState.animateScrollToPage(selectedTabIndex)// Define pageState here
    }
    LaunchedEffect(pageState.currentPage , pageState.isScrollInProgress) {
        if (!pageState.isScrollInProgress) {
            selectedTabIndex = pageState.currentPage
        }
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize() ,
        topBar = {
            Surface(
                shape = RoundedCornerShape(
                    bottomStart = 50.dp , bottomEnd = 50.dp
                )
            ) {
                WokiTokiScreen(
                    selectedTabIndex ,
                    pageState
                )
            }
        } ,
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(background)
                    .padding(paddingValues)
            ) {
                HorizontalPager(
                    state = pageState ,
                    modifier = Modifier
                        .weight(1f)
                        .background(background)
                ) { page ->
                    when (page) {
                        0 -> ChatsScreen(navController)
                        1 -> StatusScreen(navController)
                        2 -> ChannelsScreen(navController)
                    }
                }
            }
        }
    )
}




