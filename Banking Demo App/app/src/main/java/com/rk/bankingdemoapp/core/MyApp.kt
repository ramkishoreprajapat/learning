package com.rk.bankingdemoapp.core

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize any third-party libraries or components here
    }
}