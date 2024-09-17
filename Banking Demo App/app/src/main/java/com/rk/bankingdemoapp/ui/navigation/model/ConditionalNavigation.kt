package com.rk.bankingdemoapp.ui.navigation.model

data class ConditionalNavigation(
    val requireLogin: Boolean,
    val requireOnboarding: Boolean,
    val requireCreateAppLock: Boolean,
)
