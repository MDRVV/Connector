package com.rcl.connector.koin.ktor

import com.rcl.connector.model.HouseModel
import com.rcl.connector.model.StreetModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class KtorRepository(private val httpClient: HttpClient) {
    private val baseUrl = "https://stat-api.airnet.ru/v2/utils/get"

    suspend fun getStreetList(): List<StreetModel> {
        val url = "${baseUrl}/allStreets/"
        return Json.decodeFromString<List<StreetModel>>(httpClient.get(url).body())
    }
    suspend fun getHouseList(streedId: String): List<HouseModel> {
        var url = "${baseUrl}/houses/"
        url+="?street_id=${streedId}"
        return Json.decodeFromString<List<HouseModel>>(httpClient.get(url).body())
    }
}