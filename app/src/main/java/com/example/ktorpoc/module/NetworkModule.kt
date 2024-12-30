package com.example.ktorpoc.module

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.HttpTimeout
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import org.koin.dsl.module

val networkModule = module {
    single{
        HttpClient(Android){
            install(Logging){
                level = LogLevel.BODY
            }
            install(JsonFeature){
                serializer = KotlinxSerializer()
            }
            install(HttpTimeout){
                requestTimeoutMillis = 6000
            }
        }
    }
}