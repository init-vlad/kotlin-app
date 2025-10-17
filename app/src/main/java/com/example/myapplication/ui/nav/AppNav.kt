package com.example.myapplication.ui.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.pages.FirstScreen
import com.example.myapplication.ui.pages.SecondScreen

@Composable
fun AppNav() {
    val navController = rememberNavController()

    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(navController = navController, startDestination = "first")
        {
            composable("first") { FirstScreen() }
            composable("second") { SecondScreen() }
        }
    }
}