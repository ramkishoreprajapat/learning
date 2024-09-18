package com.rk.bankingdemoapp.ui.core.permission

import androidx.compose.runtime.compositionLocalOf

val LocalPermissionHelper = compositionLocalOf<PermissionHelper> { error("No PermissionHelper provided") }