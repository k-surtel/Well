package com.ks.well.feature_sleep.presentation.add_edit_sleep

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ks.well.feature_sleep.presentation.add_edit_sleep.components.DatePicker
import com.ks.well.feature_sleep.presentation.add_edit_sleep.components.TimePicker
import org.koin.androidx.compose.getViewModel
import java.time.format.DateTimeFormatter

@Composable
fun AddEditSleepScreen(
    navController: NavController
) {
    val viewModel = getViewModel<AddEditSleepViewModel>()
    val scope = rememberCoroutineScope()

    val timePattern = "HH:mm"

    var startDateTime by remember { mutableStateOf(viewModel.endDateTime.value.minusHours(8)) }
    var endDateTime by remember { mutableStateOf(viewModel.endDateTime.value) }

    val openStartTimePickerDialog = remember { mutableStateOf(false) }
    if(openStartTimePickerDialog.value) {
        TimePicker(
            initialTime = startDateTime.toLocalTime(),
            onDismissRequest = { openStartTimePickerDialog.value = false },
            onTimeChange = {
            startDateTime = startDateTime.withHour(it.hour).withMinute(it.minute)
            openStartTimePickerDialog.value = false
        })
    }

    val openStartDatePickerDialog = remember { mutableStateOf(false) }
    if(openStartDatePickerDialog.value) {
        DatePicker(
            initialDate = startDateTime.toLocalDate(),
            onDismissRequest = { openStartDatePickerDialog.value = false },
            onDateChange = {
                startDateTime = startDateTime.withYear(it.year).withMonth(it.monthValue).withDayOfMonth(it.dayOfMonth)
                openStartDatePickerDialog.value = false
            })
    }

    val openEndTimePickerDialog = remember { mutableStateOf(false) }
    if(openEndTimePickerDialog.value) {
        TimePicker(
            initialTime = endDateTime.toLocalTime(),
            onDismissRequest = { openEndTimePickerDialog.value = false },
            onTimeChange = {
                endDateTime = endDateTime.withHour(it.hour).withMinute(it.minute)
                openEndTimePickerDialog.value = false
            })
    }

    val openEndDatePickerDialog = remember { mutableStateOf(false) }
    if(openEndDatePickerDialog.value) {
        DatePicker(
            initialDate = endDateTime.toLocalDate(),
            onDismissRequest = { openEndDatePickerDialog.value = false },
            onDateChange = {
                endDateTime = endDateTime.withYear(it.year).withMonth(it.monthValue).withDayOfMonth(it.dayOfMonth)
                openEndDatePickerDialog.value = false
            })
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {},
                floatingActionButton = {
                    FloatingActionButton(onClick = {
                        viewModel.onEvent(AddEditSleepEvent.SaveSleep(startDateTime, endDateTime))
                        navController.navigateUp()
                    }) {
                        Icon(Icons.Default.Add, contentDescription = "Add")
                    }
                },
            )
        }
    ) {
        Column(Modifier.fillMaxSize().padding(it).padding(16.dp)) {
            Row { Text(text = "Fell asleep", fontSize = 40.sp) }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = { openStartTimePickerDialog.value = true }) {
                    Text(text = startDateTime.format(DateTimeFormatter.ofPattern(timePattern)), fontSize = 20.sp)
                }
                Text(modifier = Modifier.padding(horizontal = 16.dp), text = "on")
                Button(onClick = { openStartDatePickerDialog.value = true }) {
                    Text(text = "${startDateTime.dayOfWeek.name}, ${startDateTime.dayOfMonth}.${startDateTime.monthValue}", fontSize = 20.sp)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row { Text(text = "Woke up", fontSize = 40.sp) }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = { openEndTimePickerDialog.value = true }) {
                    Text(text = endDateTime.format(DateTimeFormatter.ofPattern(timePattern)), fontSize = 20.sp)
                }
                Text(modifier = Modifier.padding(horizontal = 16.dp), text = "on")
                Button(onClick = { openEndDatePickerDialog.value = true }) {
                    Text(text = "${endDateTime.dayOfWeek.name}, ${endDateTime.dayOfMonth}.${endDateTime.monthValue}", fontSize = 20.sp)
                }
            }
        }
    }
}