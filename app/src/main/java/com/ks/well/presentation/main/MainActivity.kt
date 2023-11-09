package com.ks.well.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ks.well.presentation.add_edit_sleep.AddEditSleepScreen
import com.ks.well.ui.theme.WellTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WellTheme {
                //val viewModel = getViewModel<MainViewModel>()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.MainScreen.route
                    ) {
                        composable(route = Screen.MainScreen.route) {
                            MainScreen(navController = navController)
                        }

                        composable(
                            route = Screen.AddEditSleepScreen.route +
                                "?sleepId={sleepId}&year={year}&month={month}&day={day}",
                            arguments = listOf(
                                navArgument(name = "sleepId") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(name = "year") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(name = "month") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(name = "day") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) {
                            AddEditSleepScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}