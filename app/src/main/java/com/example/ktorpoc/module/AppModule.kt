package com.example.ktorpoc.module

import com.example.ktorpoc.repository.ApiRepository
import org.koin.dsl.module

val appModule = module {
    single { ApiRepository(get()) }
}