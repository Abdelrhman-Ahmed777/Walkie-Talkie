package com.example.walkie_talkie.system.presentation.app_design.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.walkie_talkie.R
import com.example.walkie_talkie.R.drawable.baseline_archive_24
import com.example.walkie_talkie.R.drawable.lock_ic
import com.example.walkie_talkie.system.presentation.app_design.navigation.Screen
import com.example.walkie_talkie.system.presentation.app_design.ui.componant.woki_toki_screen.screen.WokiTokiScreen
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.home.channels.ChannelsScreen
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.home.chats.ChatsScreen
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.home.status.StatusScreen
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.ui_thames.DarkColorScheme.black
import com.example.walkie_talkie.ui_thames.DarkColorScheme.darkBlue2
import com.example.walkie_talkie.ui_thames.DarkColorScheme.lightBlue
import com.example.walkie_talkie.ui_thames.DarkColorScheme.midPurple
import com.example.walkie_talkie.ui_thames.theme.digital
import kotlinx.coroutines.launch

@SuppressLint("SuspiciousIndentation")
@Composable
        /*
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
        */



fun HomeScreen(navController: NavController) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState ,
        gesturesEnabled = true ,
        drawerContent = {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.8F)
                    .clip(RoundedCornerShape(topEnd = 50.dp , bottomEnd = 50.dp))
                    .background(darkBlue2)
            ) {
                val (userProf , userName , itemsList) = createRefs()

                Image(
                    painter = painterResource(id = R.drawable.male_profile) ,
                    contentDescription = "Logo" ,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .constrainAs(userProf) {
                            top.linkTo(parent.top , margin = 64.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )
                Text(
                    text = "Abdelrhman Ahmed" ,
                    color = com.example.walkie_talkie.theme.lightBlue ,
                    fontSize = 24.sp ,
                    fontFamily = digital ,
                    modifier = Modifier
                        .constrainAs(userName) {
                            top.linkTo(userProf.bottom , margin = 16.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )
                Column(
                    horizontalAlignment = Alignment.Start ,
                    modifier = Modifier
                        .fillMaxHeight(0.7f)
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(
                                topEnd = 50.dp ,
                                topStart = 50.dp ,
                                bottomEnd = 50.dp
                            )
                        )
                        .background(color = darkBlue)
                        .constrainAs(itemsList) {
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                ) {
                    Spacer(Modifier.height(16.dp))
                    NavigationDrawerItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Home ,
                                contentDescription = "Home" ,
                                modifier = Modifier
                                    .padding(start = 24.dp)
                                    .size(24.dp) ,
                                tint = Cyan
                            )
                        } ,
                        label = {
                            Text(
                                text = "Home" ,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 16.dp) ,
                                color = com.example.walkie_talkie.theme.lightBlue ,
                                fontSize = 20.sp ,
                                fontFamily = digital
                            )
                        } ,
                        selected = false ,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                            }
                            navController.navigate(Screen.MainScreen.route) {
                                popUpTo(0)
                            }

                        }
                    )
                    Spacer(Modifier.height(16.dp))
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = "Favourites" ,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 16.dp) ,
                                color = com.example.walkie_talkie.theme.lightBlue ,
                                fontSize = 20.sp ,
                                fontFamily = digital
                            )
                        } ,
                        selected = false ,
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Favorite ,
                                contentDescription = "Home" ,
                                modifier = Modifier
                                    .padding(start = 24.dp)
                                    .size(24.dp) ,
                                tint = Red
                            )
                        } ,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                            }
                            navController.navigate(Screen.Fav.route) {
                                popUpTo(0)
                            }

                        }
                    )
                    Spacer(Modifier.height(16.dp))
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = "Archive" ,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 16.dp) ,
                                color = com.example.walkie_talkie.theme.lightBlue ,
                                fontSize = 20.sp ,
                                fontFamily = digital
                            )
                        } ,
                        selected = false ,
                        icon = {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = baseline_archive_24) ,
                                contentDescription = "Archive" ,
                                modifier = Modifier
                                    .padding(start = 24.dp)
                                    .size(24.dp) ,
                                tint = com.example.walkie_talkie.theme.midPurple
                            )
                        } ,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                            }
                            navController.navigate(Screen.Arch.route) {
                                popUpTo(0)
                            }

                        }
                    )
                    Spacer(Modifier.height(16.dp))
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = "Locked Chats " ,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 16.dp) ,
                                color = com.example.walkie_talkie.theme.lightBlue ,
                                fontSize = 20.sp ,
                                fontFamily = digital
                            )
                        } ,
                        selected = false ,
                        icon = {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = lock_ic) ,
                                contentDescription = "Home" ,
                                modifier = Modifier
                                    .padding(start = 24.dp)
                                    .size(24.dp) ,
                                tint = Green
                            )
                        } ,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                            }
                            navController.navigate(Screen.LockedChats.route) {
                                popUpTo(0)
                            }

                        }
                    )
                    Spacer(Modifier.height(16.dp))
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = "Settings" ,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 16.dp) ,
                                color = com.example.walkie_talkie.theme.lightBlue ,
                                fontSize = 20.sp ,
                                fontFamily = digital
                            )
                        } ,
                        selected = false ,
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Settings ,
                                contentDescription = "Settings" ,
                                modifier = Modifier
                                    .padding(start = 24.dp)
                                    .size(24.dp) ,
                                tint = Gray
                            )
                        } ,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                            }
                            navController.navigate(Screen.Settings.route) {
                                popUpTo(0)
                            }

                        }
                    )
                }
            }

        }
    ) {
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
                        pageState ,
                        onclick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }
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
        LaunchedEffect(key1 = pageState.currentPage) {
            selectedTabIndex = pageState.currentPage
        }
    }
}



