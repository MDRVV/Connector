package com.rcl.connector.koin.ktor

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module

object KtorModel {
    val networkModule = module {
        single {
            HttpClient(OkHttp) {
                expectSuccess = true
                install(ContentNegotiation) {
                    json(Json {
                        isLenient = true
                        ignoreUnknownKeys = true
                        prettyPrint = true
                    })
                }
                install(Logging){
                    logger = Logger.DEFAULT
                    level = LogLevel.ALL
                }
            }
        }

        single {
            KtorRepository(get())
        }
    }
}
