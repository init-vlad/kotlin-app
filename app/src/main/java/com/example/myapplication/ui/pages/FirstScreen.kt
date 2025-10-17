package com.example.myapplication.ui.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.theme.Background
import com.example.myapplication.ui.theme.Typography
import coil.compose.AsyncImage
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun FirstScreen() {
    Surface (modifier = Modifier.systemBarsPadding(), color = Background) {
        Column {
            Text("Crypto Tracker", style = Typography.displayLarge)
            CryptoIcon()
        }
    }
}

@Composable
fun CryptoIcon() {
    AsyncImage(
        model = "https://cdn-icons-png.flaticon.com/512/9584/9584876.png",
        contentDescription = "Crypto Icon",
        modifier = Modifier
            .size(128.dp)
            .padding(16.dp)
    )
}