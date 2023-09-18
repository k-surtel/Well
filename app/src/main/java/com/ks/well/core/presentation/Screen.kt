package com.ks.well.core.presentation

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object AddEditSleepScreen: Screen("add_edit_sleep_screen")
}