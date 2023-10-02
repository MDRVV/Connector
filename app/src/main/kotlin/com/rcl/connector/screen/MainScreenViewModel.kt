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
    val houseList = mutableStateListOf<HouseModel>()
    val selectedStreetID = mutableStateOf("")
    val selectedHouseID = mutableStateOf("")
    val streetInList = mutableStateOf(false)
    val houseInList = mutableStateOf(false)
    val isCustomHouse = mutableStateOf(false)
    val customHouse = mutableStateOf("")
    val customFrame = mutableStateOf("")
    val apartment = mutableStateOf("")
    init {
        getStreetList()
    }
    private fun getStreetList(){
        viewModelScope.launch {
            streetList.addAll(koin.get<KtorRepository>().getStreetList())
        }
    }
    fun getHouses(streetId: String){
        viewModelScope.launch {
            houseList.addAll(koin.get<KtorRepository>().getHouseList(streetId).sortedWith (
                compareBy(
                    { it.house!!.split("K", "/")[0].toIntOrNull() ?: Int.MAX_VALUE },
                    { it.house!!.split("K", "/").getOrNull(1)?.toIntOrNull() ?: Int.MAX_VALUE }
                )
            )
            )
        }
    }
    fun clearHouses(){
        viewModelScope.launch {
            houseList.clear()
        }
    }
}