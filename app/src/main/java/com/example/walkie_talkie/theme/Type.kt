package com.example.walkie_talkie.ui_thames.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.walkie_talkie.R.font.digital7italic658
import com.example.walkie_talkie.R.font.digital7mono94
import com.example.walkie_talkie.R.font.digital7rg1ml
import com.example.walkie_talkie.R.font.philosopherbold
import com.example.walkie_talkie.R.font.philosopherbolditalic
import com.example.walkie_talkie.R.font.philosopheritalic
import com.example.walkie_talkie.R.font.philosopherregular

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default ,
        fontWeight = FontWeight.Normal ,
        fontSize = 16.sp ,
        lineHeight = 24.sp ,
        letterSpacing = 0.5.sp
    )



    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val  digital = FontFamily(
    Font(digital7italic658) ,
    Font(digital7rg1ml),
    Font(digital7mono94)
)

val philosopher = FontFamily(
    Font(philosopherbold)
    ,Font(philosopheritalic)
    ,Font(philosopherbolditalic)
    ,Font(philosopherregular)
)


