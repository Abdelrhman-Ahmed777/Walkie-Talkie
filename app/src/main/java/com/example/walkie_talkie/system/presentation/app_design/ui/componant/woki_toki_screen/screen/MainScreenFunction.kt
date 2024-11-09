@file:Suppress("NAME_SHADOWING")

package com.example.walkie_talkie.system.presentation.app_design.ui.componant.woki_toki_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.example.walkie_talkie.R
import com.example.walkie_talkie.R.drawable.groupes_ic
import com.example.walkie_talkie.R.drawable.message_ic
import com.example.walkie_talkie.R.drawable.stories_ic
import com.example.walkie_talkie.system.presentation.app_design.ui.componant.woki_toki_screen.status_bar.StatusBar
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.darkBlue2
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.theme.white
import com.example.walkie_talkie.ui_thames.DarkColorScheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WokiTokiScreen(
    selected: Int ,
    pageState: PagerState,
    onclick: () -> Unit
) {
    val items = listOf(
        TopAppItems(
            title = "Home" ,
            selectedIcon = ImageVector.vectorResource(message_ic) ,
            color = DarkColorScheme.lightBlue ,
            hasNews = false ,
            badgeCount = null ,
        ) ,
        TopAppItems(
            title = "Status" ,
            selectedIcon = ImageVector.vectorResource(stories_ic) ,
            color = DarkColorScheme.lightBlue ,
            hasNews = false ,
            badgeCount = null ,
        ) ,
        TopAppItems(
            title = "Home" ,
            selectedIcon = ImageVector.vectorResource(groupes_ic) ,
            color = DarkColorScheme.lightBlue ,
            hasNews = false ,
            badgeCount = null ,
        )
    )
    var selected = selected
    val scope = rememberCoroutineScope()



    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .background(darkBlue)
            .clip(RoundedCornerShape(bottomStart = 50.dp , bottomEnd = 50.dp))
    ) {
        ConstraintLayout(
            Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(bottomStart = 50.dp , bottomEnd = 50.dp))
        ) {
            val (statusBar , userProfile , search , tapMenu) = createRefs()
            StatusBar(
                "canada" ,
                "vancouver" , modifier = Modifier
                    .constrainAs(statusBar) {
                        top.linkTo(parent.top , margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    } , backGround = darkBlue
            )
            AsyncImage(
                model = R.drawable.male_profile ,
                contentDescription = "user profile" ,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(50.dp)
                    .aspectRatio(1f)
                    .clickable(enabled = true , onClick = onclick)
                    .constrainAs(userProfile) {
                        top.linkTo(parent.top , margin = 48.dp)
                        start.linkTo(parent.start , margin = 24.dp)
                    }
            )
            var text by remember { mutableStateOf("") }
            TextField(value = text ,
                onValueChange = {
                    text = it
                } ,
                modifier = Modifier
                    .height(50.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(
                        width = 1.dp ,
                        color = lightBlue ,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .constrainAs(search) {
                        top.linkTo(parent.top , margin = 50.dp)
                        start.linkTo(userProfile.end)
                        end.linkTo(parent.end)
                    } ,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = lightBlue ,
                    unfocusedTextColor = lightBlue ,
                    focusedContainerColor = darkBlue2 ,
                    unfocusedContainerColor = darkBlue2 ,
                    focusedIndicatorColor = darkBlue2 ,
                    unfocusedIndicatorColor = darkBlue2 ,
                    cursorColor = lightBlue
                ) ,
                singleLine = true ,

                textStyle = TextStyle(
                    color = lightBlue , fontSize = 20.sp
                ) ,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search ,
                        modifier = Modifier.clickable {

                        } ,
                        contentDescription = "Search" ,
                        tint = lightBlue
                    )
                })

            TabRow(
                modifier = Modifier
                    .height(50.dp)
                    .wrapContentWidth()
                    .background(darkBlue)
                    .clip(RoundedCornerShape(topStart = 50.dp , topEnd = 50.dp))
                    .constrainAs(tapMenu) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    } ,
                selectedTabIndex = selected ,
                containerColor = darkBlue ,
                contentColor = lightBlue
            ) {
                items.forEachIndexed { index , item ->
                    Tab(
                        selected = index == selected ,
                        onClick = {
                            selected = index
                            scope.launch {
                                withContext(Dispatchers.Main) {
                                    pageState.animateScrollToPage(index)
                                }
                            }
                        } ,
                        icon = {
                            Icon(
                                imageVector = item.selectedIcon ,
                                contentDescription = item.title ,
                                modifier = Modifier
                                    .size(24.dp)
                                    .offset(y = -8.dp)

                            )
                        } ,
                        modifier = Modifier ,
                        unselectedContentColor = lightBlue ,
                        selectedContentColor = white ,
                    )
                }
            }
        }


    }
}







