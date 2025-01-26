package com.mikeh.littlelemon.ui.screens.navigation


/**
 * Created by Maycon Henrique on 26/01/2025.
 * maycon255@hotmail.com
 */
private enum class Destinations {
    ONBOARDING,
    HOME,
    PROFILE,
}

sealed class NavigationItem(val route: String) {
    data object Onboarding : NavigationItem(Destinations.ONBOARDING.name)
    data object Home : NavigationItem(Destinations.HOME.name)
    data object Profile : NavigationItem(Destinations.PROFILE.name)
}
