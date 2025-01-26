package com.mikeh.littlelemon.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mikeh.littlelemon.ui.screens.Home
import com.mikeh.littlelemon.ui.screens.Onboarding
import com.mikeh.littlelemon.ui.screens.Profile


/**
 * Created by Maycon Henrique on 26/01/2025.
 * maycon255@hotmail.com
 */

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Onboarding.route) {
        composable(route = NavigationItem.Onboarding.route) {
            Onboarding()
        }
        composable(route = NavigationItem.Home.route) {
            Home()
        }
        composable(route = NavigationItem.Profile.route) {
            Profile()
        }
    }
}