package com.example.myapplication.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val Primary = Color(0xFF00695C)
val Secondary = Color(0xFF26A69A)
val Background = Color(0xFFFFFFFF)
val Error = Color(0xFFD32F2F)

val LightColorScheme = lightColorScheme(
    primary = Primary,
    secondary = Secondary,
    background = Background,
    error = Error
)

val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF80CBC4),
    secondary = Color(0xFFA7FFEB),
    background = Color(0xFF121212)
)
