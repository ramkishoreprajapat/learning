package com.rk.bankingdemoapp.ui.onboarding

import android.content.Context
import com.rk.bankingdemoapp.R

data class OnboardingPage(
    val title: String,
    val description: String,
    val image: Int
) {
    companion object {
        fun getPages(context: Context): List<OnboardingPage> {
            return listOf(
                OnboardingPage(
                    title = context.getString(R.string.wizard_title_1),
                    description = context.getString(R.string.wizard_desc_1),
                    image = R.drawable.img_wizard_1
                ),
                OnboardingPage(
                    title = context.getString(R.string.wizard_title_2),
                    description = context.getString(R.string.wizard_desc_2),
                    image = R.drawable.img_wizard_2
                ),
                OnboardingPage(
                    title = context.getString(R.string.wizard_title_3),
                    description = context.getString(R.string.wizard_desc_3),
                    image = R.drawable.img_wizard_3
                ),
            )
        }
    }
}