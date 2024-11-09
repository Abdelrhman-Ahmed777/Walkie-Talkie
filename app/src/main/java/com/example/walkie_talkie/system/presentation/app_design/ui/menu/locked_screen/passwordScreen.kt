package com.example.walkie_talkie.system.presentation.app_design.ui.menu.locked_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.walkie_talkie.R
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.theme.white
import com.example.walkie_talkie.ui_thames.theme.digital

@Preview(showBackground = true)
@Composable
fun PasswordScreen() {
    var password by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(darkBlue)
            .border(
                width = 1.dp ,
                color = lightBlue ,
                shape = RoundedCornerShape(15.dp)
            )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val (text , enterText , button) = createRefs()


            Text(
                text = "Enter your Password : " ,
                color = lightBlue ,
                fontSize = 20.sp ,
                fontFamily = digital ,
                modifier = Modifier
                    .constrainAs(text) {
                        top.linkTo(parent.top , margin = 16.dp)
                        start.linkTo(parent.start , margin = 16.dp)
                    }
            )
            TextField(value = password ,
                onValueChange = {
                    password = it
                } ,
                enabled = true ,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .border(
                        width = 1.dp ,
                        color = lightBlue ,
                        shape = RoundedCornerShape(50.dp)
                    )
                    .constrainAs(enterText) {
                        top.linkTo(text.bottom , margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    } ,
                placeholder = {
                    Text(text = "Enter your password" , style = TextStyle(color = Color.Gray))
                } ,
                maxLines = 50 ,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = lightBlue ,
                    unfocusedTextColor = lightBlue ,
                    focusedContainerColor = darkBlue ,
                    unfocusedContainerColor = darkBlue ,
                    focusedIndicatorColor = darkBlue ,
                    unfocusedIndicatorColor = darkBlue ,
                    cursorColor = lightBlue
                ) ,
                singleLine = true ,

                textStyle = TextStyle(
                    color = Color.White ,
                    fontSize = 20.sp ,
                ) ,
                leadingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.lock_ic) ,
                        modifier = Modifier.clickable {
                        } ,
                        contentDescription = null ,
                        tint = lightBlue ,
                    )
                } ,
                trailingIcon = {
                    if (password.isNotEmpty()) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.close_ic) ,
                            modifier = Modifier.clickable {
                            } ,
                            contentDescription = "Search" ,
                            tint = Color.Red
                        )
                    }

                }
            )
            Button(
                onClick = { /*TODO*/ } ,
                modifier = Modifier
                    .height(40.dp)
                    .wrapContentWidth()
                    .constrainAs(button){
                        top.linkTo(enterText.bottom , margin = 16.dp)
                        end.linkTo(parent.end, margin = 16.dp)

                    },
                shape = RoundedCornerShape(50.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = white ,
                    contentColor = darkBlue
                )
            ) {
                Text(
                    text = "Enter" ,
                    style = TextStyle(
                        fontSize = 20.sp ,
                        fontFamily = digital
                    )
                )
            }


        }
    }
}