package com.rcl.connector.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

class MainScreen {
    @Composable
    fun Content(
        mainViewModel: MainScreenViewModel = viewModel()
    ){
        Scaffold(

        ) {
            Box(modifier = Modifier.padding(it)){

            }
        }
    }
}