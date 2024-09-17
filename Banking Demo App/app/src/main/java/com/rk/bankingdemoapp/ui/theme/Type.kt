package com.rk.bankingdemoapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rk.bankingdemoapp.R

val primaryFontFamily = FontFamily(
    Font(
        R.font.poppins,
        FontWeight.Normal
    ),
    Font(
        R.font.poppins_medium,
        FontWeight.Medium
    ),
    Font(
        R.font.poppins_semibold,
        FontWeight.SemiBold
    )
)

val ubuntuFontFamily = FontFamily(
    Font(
        R.font.ubuntu,
        FontWeight.Normal
    ),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    titleSmall = TextStyle(
        fontFamily = primaryFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold
    ),

    titleMedium = TextStyle(
        fontFamily = primaryFontFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold
    ),
    titleLarge = TextStyle(
        fontFamily = primaryFontFamily,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold
    ),
    bodyMedium = TextStyle(
        fontFamily = primaryFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = Gray30,
        lineHeight = 24.sp
    ),

    labelSmall = TextStyle(
        fontFamily = primaryFontFamily,
        fontSize = 12.sp,
        color = Gray50,
        fontWeight = FontWeight.Normal
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