package com.example.demomvvm

import android.app.Application
import com.example.demomvvm.di.networkModule
import com.example.demomvvm.di.sourceModule
import com.example.demomvvm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    networkModule,
                    sourceModule,
                    viewModelModule
                )
            )
        }
    }
}
