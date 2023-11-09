package com.ks.well.presentation.add_edit_sleep.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.marosseleng.compose.material3.datetimepickers.date.ui.dialog.DatePickerDialog
import java.time.LocalDate

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DatePicker(
    initialDate: LocalDate,
    onDismissRequest: () -> Unit,
    onDateChange: (date: LocalDate) -> Unit
) {
    DatePickerDialog(
        initialDate = initialDate,
        onDismissRequest = { onDismissRequest() },
        onDateChange = {
            onDateChange(it)
        }
    )
}