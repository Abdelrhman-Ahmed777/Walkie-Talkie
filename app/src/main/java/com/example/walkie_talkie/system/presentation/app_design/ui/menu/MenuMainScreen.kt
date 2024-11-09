package com.example.walkie_talkie.system.presentation.app_design.ui.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.compose.rememberNavController
import com.example.walkie_talkie.R
import com.example.walkie_talkie.R.drawable.baseline_archive_24
import com.example.walkie_talkie.system.presentation.app_design.navigation.Screen
import com.example.walkie_talkie.theme.darkBlue2
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.theme.midPurple
import com.example.walkie_talkie.ui_thames.theme.digital
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        modifier = Modifier
            .fillMaxHeight()
            .width(300.dp)
            .background(darkBlue2)
            .clip(RoundedCornerShape(30.dp)) ,
        drawerState = drawerState ,
        gesturesEnabled = true ,
        drawerContent = {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .background(darkBlue2)
            ) {
                val (userProf , userName , itemsList) = createRefs()

                Image(
                    painter = painterResource(id = R.drawable.male_profile) ,
                    contentDescription = "Logo" ,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .constrainAs(userProf) {
                            top.linkTo(parent.top , margin = 32.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )
                Text(
                    text = "Abdelrhman Ahmed" ,
                    color = lightBlue ,
                    fontSize = 24.sp ,
                    fontFamily = digital ,
                    modifier = Modifier
                        .constrainAs(userName) {
                            top.linkTo(userProf.bottom , margin = 16.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
                    .background(color = darkBlue2)
                    .clip(RoundedCornerShape(30.dp))
            ) {
                NavigationDrawerItem(
                    label = {
                        Text(
                            text = "Home" ,
                            color = lightBlue ,
                            fontSize = 20.sp ,
                            fontFamily = digital
                        )
                    } ,
                    selected = false ,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home ,
                            contentDescription = "Home" ,
                            modifier = Modifier.size(24.dp) ,
                            tint = Cyan
                        )
                    } ,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Screen.MainScreen.route) {
                            popUpTo(0)
                        }

                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text(
                            text = "Favourites" ,
                            color = lightBlue ,
                            fontSize = 20.sp ,
                            fontFamily = digital
                        )
                    } ,
                    selected = false ,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Favorite ,
                            contentDescription = "Home" ,
                            modifier = Modifier.size(24.dp) ,
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
                NavigationDrawerItem(
                    label = {
                        Text(
                            text = "Archive" ,
                            color = lightBlue ,
                            fontSize = 20.sp ,
                            fontFamily = digital
                        )
                    } ,
                    selected = false ,
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = baseline_archive_24) ,
                            contentDescription = "Archive" ,
                            modifier = Modifier.size(24.dp) ,
                            tint = midPurple
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
                NavigationDrawerItem(
                    label = {
                        Text(
                            text = "Locked Chats " ,
                            color = lightBlue ,
                            fontSize = 20.sp ,
                            fontFamily = digital
                        )
                    } ,
                    selected = false ,
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.lock_ic) ,
                            contentDescription = "Home" ,
                            modifier = Modifier.size(24.dp) ,
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
                NavigationDrawerItem(
                    label = {
                        Text(
                            text = "Settings" ,
                            color = lightBlue ,
                            fontSize = 20.sp ,
                            fontFamily = digital
                        )
                    } ,
                    selected = false ,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Settings ,
                            contentDescription = "Settings" ,
                            modifier = Modifier.size(24.dp) ,
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
    ) {}
}