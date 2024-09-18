package com.rk.bankingdemoapp.ui.components.snackbar

import androidx.compose.ui.graphics.Color

sealed class SnackBarMode {
    object Positive: SnackBarMode()
    object Negative: SnackBarMode()
    object Neutral: SnackBarMode()

    fun getSurfaceColor(): Color {
        return when (this) {
            Positive -> SnackbarColors.positiveColor
            Negative -> SnackbarColors.negativeColor
            Neutral -> SnackbarColors.neutralColor
        }
    }

}