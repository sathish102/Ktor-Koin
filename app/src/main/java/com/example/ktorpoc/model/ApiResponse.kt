package com.example.ktorpoc.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
data class ApiResponse (
    val fact : String,
    val length : Int
)