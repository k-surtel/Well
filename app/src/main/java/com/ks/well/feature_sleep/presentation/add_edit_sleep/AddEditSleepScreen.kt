package com.ks.well.feature_sleep.presentation.add_edit_sleep

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.getViewModel

@Composable
fun AddEditSleepScreen(
    navController: NavController
) {
    val viewModel = getViewModel<AddEditSleepViewModel>()
    //val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

//    val openTimePickerDialog = remember { mutableStateOf(false) }
//
//    Button(onClick = {
//        openTimePickerDialog.value = true
//    }) {
//        Text(text = "Start")
//    }
//
//    if(openTimePickerDialog.value) {
//        TimePickerDialog(onCancel = { /*TODO*/ }, onConfirm = { /*TODO*/ }) {
//
//        }
//    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        var startDate by remember { mutableStateOf("") }
        TextField(
            value = startDate,
            onValueChange = { startDate = it },
            label = { Text("Start date") },
            placeholder = { Text("30-5-2023") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        var startTime by remember { mutableStateOf("") }
        TextField(
            value = startTime,
            onValueChange = { startTime = it },
            label = { Text("Start time") },
            placeholder = { Text("21.13") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))
        var endDate by remember { mutableStateOf("") }
        TextField(
            value = endDate,
            onValueChange = { endDate = it },
            label = { Text("End date") },
            placeholder = { Text("31-5-2023") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        var endTime by remember { mutableStateOf("") }
        TextField(
            value = endTime,
            onValueChange = { endTime = it },
            label = { Text("End time") },
            placeholder = { Text("7.33") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            viewModel.onEvent(AddEditSleepEvent.SaveSleep(startDate, startTime, endDate, endTime))
            navController.navigateUp()
        }) {
            Text(text = "Save")
        }
    }
}