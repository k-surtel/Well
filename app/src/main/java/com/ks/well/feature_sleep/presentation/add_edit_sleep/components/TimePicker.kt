package com.ks.well.feature_sleep.presentation.add_edit_sleep.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.marosseleng.compose.material3.datetimepickers.time.ui.dialog.TimePickerDialog
import java.time.LocalTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePicker(
    initialTime: LocalTime,
    onDismissRequest: () -> Unit,
    onTimeChange: (time: LocalTime) -> Unit
) {
    TimePickerDialog(
        is24HourFormat = true,
        initialTime = initialTime,
        onDismissRequest = { onDismissRequest() },
        onTimeChange = {
            onTimeChange(it)
        })
}