package com.rcl.connector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.rcl.connector.KoinObj.inited
import com.rcl.connector.KoinObj.koin
import com.rcl.connector.koin.ktor.KtorModel
import com.rcl.connector.screen.MainScreen
import com.rcl.connector.ui.theme.Theme.ConnectorTheme
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        if (!inited) {
            koin = startKoin { modules(KtorModel.networkModule) }.koin
            inited = true
        }
        setContent {
            ConnectorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    enableEdgeToEdge()
                    MainScreen().Content()
                }
            }
        }
    }
}