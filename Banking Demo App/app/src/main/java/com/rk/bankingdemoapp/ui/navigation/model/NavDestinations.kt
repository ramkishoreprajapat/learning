package com.rk.bankingdemoapp.ui.navigation.model

sealed class NavDestinations {
    object Onboarding: NavDestinations()

    object RootGraph : NavDestinations() {
        object Home : NavDestinations()
        object TransactionHistory : NavDestinations()
        object Profile : NavDestinations()

        object AccountTopUp : NavDestinations()
        object AccountSend : NavDestinations()

        object CardList : NavDestinations()
        object AddCard : NavDestinations()
        object CardDetails : NavDestinations()

        object SavingsList : NavDestinations()
        object SavingDetails : NavDestinations()

        object Help : NavDestinations()

        object AppSettings : NavDestinations()
    }

    val route: String
        get() = this::class.java.simpleName
}