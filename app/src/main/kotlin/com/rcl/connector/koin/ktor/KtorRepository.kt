package com.rcl.connector.koin.ktor

import com.rcl.connector.model.StreetModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class KtorRepository(private val httpClient: HttpClient) {
    private val baseUrl = "https://stat-api.airnet.ru/v2/utils/get"


    suspend fun getStreetsList(): List<StreetModel> {
        val url = "${baseUrl}/allStreets/"
        return httpClient.get(url).body()
    }
}