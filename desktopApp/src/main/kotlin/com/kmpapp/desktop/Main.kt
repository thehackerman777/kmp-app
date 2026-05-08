package com.kmpapp.desktop

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.kmpapp.createGreeting

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMP Desktop",
        state = rememberWindowState(width = 500.dp, height = 400.dp)
    ) {
        MaterialTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                DesktopGreeting()
            }
        }
    }
}

@Composable
fun DesktopGreeting() {
    val greeting = remember { createGreeting() }
    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("🖥️ KMP Desktop", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(24.dp))
        Text(greeting.message, fontSize = 18.sp)
        Spacer(Modifier.height(8.dp))
        Text("Platform: ${greeting.platform}", fontSize = 14.sp,
             color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}
