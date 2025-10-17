package com.example.myapplication.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.nav.LocalNavController

@Composable
fun SecondScreen() {
    val navController = LocalNavController.current
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Это второй экран", style = MaterialTheme.typography.headlineMedium)
            Button (
                onClick = { navController.navigate("first") },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Перейти на первый экран")
            }
        }
    }
}