package com.ks.well.presentation.add_edit_sleep

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ks.well.presentation.add_edit_sleep.components.DatePicker
import com.ks.well.presentation.add_edit_sleep.components.QualitySlider
import com.ks.well.presentation.add_edit_sleep.components.TimePicker
import org.koin.androidx.compose.getViewModel
import java.time.format.DateTimeFormatter

@Composable
fun AddEditSleepScreen(
    navController: NavController
) {
    val viewModel = getViewModel<AddEditSleepViewModel>()
    val scope = rememberCoroutineScope()

    val timePattern = "HH:mm"

    val openStartTimePickerDialog = remember { mutableStateOf(false) }
    if(openStartTimePickerDialog.value) {
        TimePicker(
            initialTime = viewModel.startDateTime.value.toLocalTime(),
            onDismissRequest = { openStartTimePickerDialog.value = false },
            onTimeChange = {
            viewModel.changeStartTime(it.hour, it.minute)
            openStartTimePickerDialog.value = false
        })
    }

    val openStartDatePickerDialog = remember { mutableStateOf(false) }
    if(openStartDatePickerDialog.value) {
        DatePicker(
            initialDate = viewModel.startDateTime.value.toLocalDate(),
            onDismissRequest = { openStartDatePickerDialog.value = false },
            onDateChange = {
                viewModel.changeStartDate(it.year, it.monthValue, it.dayOfMonth)
                openStartDatePickerDialog.value = false
            })
    }

    val openEndTimePickerDialog = remember { mutableStateOf(false) }
    if(openEndTimePickerDialog.value) {
        TimePicker(
            initialTime = viewModel.endDateTime.value.toLocalTime(),
            onDismissRequest = { openEndTimePickerDialog.value = false },
            onTimeChange = {
                viewModel.changeEndTime(it.hour, it.minute)
                openEndTimePickerDialog.value = false
            })
    }

    val openEndDatePickerDialog = remember { mutableStateOf(false) }
    if(openEndDatePickerDialog.value) {
        DatePicker(
            initialDate = viewModel.endDateTime.value.toLocalDate(),
            onDismissRequest = { openEndDatePickerDialog.value = false },
            onDateChange = {
                viewModel.changeEndDate(it.year, it.monthValue, it.dayOfMonth)
                openEndDatePickerDialog.value = false
            })
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                          if(viewModel.deletable.value) {
                              IconButton(onClick = {
                                  viewModel.onEvent(AddEditSleepEvent.DeleteSleep)
                                  navController.navigateUp()
                              }) {
                                  Icon(Icons.Default.Delete, "Delete")
                              }
                          }
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = {
                        viewModel.onEvent(AddEditSleepEvent.SaveSleep)
                        navController.navigateUp()
                    }) {
                        Icon(Icons.Default.Add, contentDescription = "Add")
                    }
                },
            )
        }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp)) {
            Row { Text(text = "Fell asleep", fontSize = 40.sp) }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = { openStartTimePickerDialog.value = true }) {
                    Text(text = viewModel.startDateTime.value.format(DateTimeFormatter.ofPattern(timePattern)), fontSize = 20.sp)
                }
                Text(modifier = Modifier.padding(horizontal = 16.dp), text = "on")
                Button(onClick = { openStartDatePickerDialog.value = true }) {
                    Text(text = "${viewModel.startDateTime.value.dayOfWeek.name}, " +
                            "${viewModel.startDateTime.value.dayOfMonth}.${viewModel.startDateTime.value.monthValue}", fontSize = 20.sp)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row { Text(text = "Woke up", fontSize = 40.sp) }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = { openEndTimePickerDialog.value = true }) {
                    Text(text = viewModel.endDateTime.value.format(DateTimeFormatter.ofPattern(timePattern)), fontSize = 20.sp)
                }
                Text(modifier = Modifier.padding(horizontal = 16.dp), text = "on")
                Button(onClick = { openEndDatePickerDialog.value = true }) {
                    Text(text = "${viewModel.endDateTime.value.dayOfWeek.name}, " +
                            "${viewModel.endDateTime.value.dayOfMonth}.${viewModel.endDateTime.value.monthValue}", fontSize = 20.sp)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row { Text(text = "Sleep quality", fontSize = 40.sp) }

            Row(verticalAlignment = Alignment.CenterVertically) {
                QualitySlider(viewModel.sliderPosition)
            }
        }
    }
}