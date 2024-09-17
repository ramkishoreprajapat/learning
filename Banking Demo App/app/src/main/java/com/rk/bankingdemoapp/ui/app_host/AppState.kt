package com.rk.bankingdemoapp.ui.app_host

import com.rk.bankingdemoapp.ui.navigation.model.ConditionalNavigation

// Global app state, can include loading state, error state, etc.
sealed class AppState {
    object Loading : AppState()

    data class Ready(
        val conditionalNavigation: ConditionalNavigation,
        val requiredUnlock: Boolean = false
    ): AppState()

    data class InitFailure(val error: Throwable): AppState()
}