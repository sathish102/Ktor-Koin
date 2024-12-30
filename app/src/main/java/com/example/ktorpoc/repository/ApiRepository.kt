package com.example.ktorpoc.repository

import com.example.ktorpoc.model.ApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class ApiRepository(private val client : HttpClient) {
    suspend fun getData() : ApiResponse {
        return client.get("https://catfact.ninja/fact")
    }

}