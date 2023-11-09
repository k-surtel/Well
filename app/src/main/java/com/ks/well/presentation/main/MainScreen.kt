package com.ks.well.presentation.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ks.well.presentation.main.components.DatesList
import com.ks.well.presentation.main.components.DayView
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen(
    navController: NavController,
    //viewModel: MainViewModel
) {
    val viewModel = getViewModel<MainViewModel>()
    //val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
    ) {
        DayView(viewModel = viewModel, navController = navController)
        DatesList(viewModel)
        Spacer(modifier = Modifier.height(64.dp))
    }

}