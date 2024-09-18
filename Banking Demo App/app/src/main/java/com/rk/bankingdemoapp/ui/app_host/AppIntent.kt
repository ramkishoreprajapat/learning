package com.rk.bankingdemoapp.ui.app_host

sealed class AppIntent {
    object EnterApp : AppIntent()
    object TryPostUnlock: AppIntent()
    object AppLockLogout: AppIntent()
}