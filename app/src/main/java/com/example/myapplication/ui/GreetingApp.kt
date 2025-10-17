package com.example.myapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.Background
import com.example.myapplication.ui.theme.Primary
import com.example.myapplication.ui.theme.Typography

@Composable
fun GreetingApp() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        color = Background
    ) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Добро пожаловать в", style = MaterialTheme.typography.headlineMedium, color = Primary)
            Text("Crypto Tracker!", style = Typography.displayLarge, color = Primary)
            Button(onClick = {}, shape = RoundedCornerShape(12.dp),     contentPadding = PaddingValues(
                vertical = 10.dp,
                horizontal = 24.dp
            ),  modifier = Modifier.padding(top = 16.dp)) {
                Text("Продолжить", style = Typography.bodyLarge)
            }
        }
    }
}