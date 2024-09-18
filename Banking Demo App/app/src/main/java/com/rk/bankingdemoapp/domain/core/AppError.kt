package com.rk.bankingdemoapp.domain.core

data class AppError(val errorType: ErrorType): Exception()
