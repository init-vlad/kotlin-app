package com.example.myapplication.ui.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

@Composable
fun FirstScreen() {
    val client = remember { OkHttpClient() }

    var btcPrice by remember { mutableStateOf<Double?>(null) }
    var ethPrice by remember { mutableStateOf<Double?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    // Загружаем данные при запуске
    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            try {
                val request = Request.Builder()
                    .url("https://api.coingecko.com/api/v3/simple/price?ids=bitcoin,ethereum&vs_currencies=usd")
                    .build()
                val response = client.newCall(request).execute()
                val body = response.body?.string()
                if (body != null) {
                    val json = JSONObject(body)
                    btcPrice = json.getJSONObject("bitcoin").getDouble("usd")
                    ethPrice = json.getJSONObject("ethereum").getDouble("usd")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                isLoading = false
            }
        }
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Курсы криптовалют", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(24.dp))

            if (isLoading) {
                CircularProgressIndicator()
            } else {
                if (btcPrice != null && ethPrice != null) {
                    CryptoPriceRow("Bitcoin (BTC)", btcPrice!!)
                    Spacer(modifier = Modifier.height(16.dp))
                    CryptoPriceRow("Ethereum (ETH)", ethPrice!!)
                } else {
                    Text("Ошибка загрузки данных 😢")
                }
            }
        }
    }
}

@Composable
fun CryptoPriceRow(name: String, price: Double) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(name, style = MaterialTheme.typography.bodyLarge)
        Text("$${"%.2f".format(price)}", style = MaterialTheme.typography.bodyLarge)
    }
}
