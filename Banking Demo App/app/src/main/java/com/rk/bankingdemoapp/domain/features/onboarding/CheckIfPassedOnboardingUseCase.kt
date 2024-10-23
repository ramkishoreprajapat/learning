package com.rk.bankingdemoapp.domain.features.onboarding

import com.rk.bankingdemoapp.data.app.AppSettingsRepository

class CheckIfPassedOnboardingUseCase(private val appSettingsRepository: AppSettingsRepository) {
    fun execute(): Boolean {
        return appSettingsRepository.isOnboardingPassed()
    }
}