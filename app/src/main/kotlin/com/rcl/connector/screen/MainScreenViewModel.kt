package com.rcl.connector.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rcl.connector.KoinObj.koin
import com.rcl.connector.koin.ktor.KtorRepository
import com.rcl.connector.model.HouseModel
import com.rcl.connector.model.StreetModel
import kotlinx.coroutines.launch

class MainScreenViewModel: ViewModel() {

    val streetList = mutableStateListOf<StreetModel>()
    init {
        getStreetList()
    }
    private fun getStreetList(){
        viewModelScope.launch {
            streetList.addAll(koin.get<KtorRepository>().getStreetList())
        }
    }
}