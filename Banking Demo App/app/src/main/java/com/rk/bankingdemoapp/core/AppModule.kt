package com.rk.bankingdemoapp.core

import com.rk.bankingdemoapp.data.app.AppSettingsRepository
import com.rk.bankingdemoapp.ui.core.permission.PermissionHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {
    @Provides
    @Singleton
    fun providePermissionHelper(appSettings: AppSettingsRepository): PermissionHelper {
        return PermissionHelper(appSettings)
    }
}