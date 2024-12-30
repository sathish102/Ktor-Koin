package com.example.ktorpoc.application

import android.app.Application
import com.example.ktorpoc.module.appModule
import com.example.ktorpoc.module.networkModule
import com.example.ktorpoc.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(networkModule,appModule,viewModelModule)
        }
    }
}