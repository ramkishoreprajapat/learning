package com.rk.bankingdemoapp.domain.features.app_lock

interface AppLockRepository {
    fun checkIfAppLocked(): Boolean
}