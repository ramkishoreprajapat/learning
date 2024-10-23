package com.rk.bankingdemoapp.ui.app_host

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rk.bankingdemoapp.domain.core.ErrorType
import com.rk.bankingdemoapp.domain.core.OperationResult
import com.rk.bankingdemoapp.domain.features.app_lock.CheckAppLockUseCase
import com.rk.bankingdemoapp.domain.features.login.CheckIfLoggedInUseCase
import com.rk.bankingdemoapp.domain.features.onboarding.CheckIfPassedOnboardingUseCase
import com.rk.bankingdemoapp.ui.core.error.asUiTextError
import com.rk.bankingdemoapp.ui.navigation.model.ConditionalNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

// This is a global app's viewModel
@HiltViewModel
class AppViewModel @Inject constructor(
    private val checkIfLoggedInUseCase: CheckIfLoggedInUseCase,
    private val checkIfPassedOnboardingUseCase: CheckIfPassedOnboardingUseCase,
    private val checkAppLockUseCase: CheckAppLockUseCase
) :
    ViewModel() {
    private val _appState: MutableStateFlow<AppState> = MutableStateFlow(AppState.Loading)
    val appState = _appState.asStateFlow()

    init {
        emitIntent(AppIntent.EnterApp)
    }

    fun emitIntent(intent: AppIntent) {
        when (intent) {
            AppIntent.EnterApp -> {
                reduceAppLoading()
                reduceAppReadyCheck()
            }

            AppIntent.TryPostUnlock -> {
                val currState = _appState.value

                if (currState is AppState.Ready) {
                    _appState.update {
                        currState.copy(
                            requiredUnlock = false
                        )
                    }
                }
            }

            is AppIntent.AppLockLogout -> {
                reduceAppReady(
                    appLocked = false,
                    conditionalNavigation = ConditionalNavigation(
                        requireLogin = true,
                        requireOnboarding = false,
                        requireCreateAppLock = false
                    )
                )
            }
        }
    }

    private fun reduceAppLoading() {
        _appState.update {
            AppState.Loading
        }
    }

    private fun reduceAppReadyCheck() {
        viewModelScope.launch {
            val isLoggedIn = OperationResult.runWrapped {
                checkIfLoggedInUseCase.execute()
            }

            when (isLoggedIn) {
                is OperationResult.Success -> {
                    val hasPassedOnboarding = checkIfPassedOnboardingUseCase.execute()
                    val appLocked = checkAppLockUseCase.execute()

                    reduceAppReady(
                        appLocked = appLocked,
                        conditionalNavigation = ConditionalNavigation(
                            requireLogin = !isLoggedIn.data,
                            requireOnboarding = !hasPassedOnboarding,
                            requireCreateAppLock = !appLocked && isLoggedIn.data
                        )
                    )
                }

                is OperationResult.Failure -> {
                    reduceError(isLoggedIn.error.errorType)
                }
            }
        }
    }

    private fun reduceAppCheck() {
        viewModelScope.launch {

        }
    }

    private fun reduceAppReady(
        conditionalNavigation: ConditionalNavigation,
        appLocked: Boolean
    ) {
        _appState.value = AppState.Ready(
            conditionalNavigation = conditionalNavigation,
            requiredUnlock = appLocked
        )
    }

    private fun reduceError(errorType: ErrorType) {
        _appState.value = AppState.InitFailure(errorType.asUiTextError())
    }

}