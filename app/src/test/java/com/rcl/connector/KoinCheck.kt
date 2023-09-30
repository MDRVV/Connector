package com.rcl.connector

import com.rcl.connector.koin.ktor.KtorModel.networkModule
import org.junit.jupiter.api.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.verify.verify

class KoinCheck {
    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun checkKoinModule() {
        networkModule.verify(
            extraTypes = listOf(
                io.ktor.client.engine.HttpClientEngine::class,
                io.ktor.client.HttpClientConfig::class
            )
        )
    }
}