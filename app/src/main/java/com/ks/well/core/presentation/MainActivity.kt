package com.ks.well.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ks.well.core.presentation.components.DatesList
import com.ks.well.core.presentation.components.DayView
import com.ks.well.feature_sleep.presentation.add_edit_sleep.AddEditSleepScreen
import com.ks.well.ui.theme.WellTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

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