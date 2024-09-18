package com.rk.bankingdemoapp.ui.onboarding

sealed class OnboardingIntent {
    object CompleteOnboarding: OnboardingIntent()
}