package com.ks.well.presentation.main

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object AddEditSleepScreen: Screen("add_edit_sleep_screen")
}