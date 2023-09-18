package com.ks.well.feature_sleep.presentation.add_edit_sleep

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.ks.well.feature_sleep.presentation.add_edit_sleep.components.TimePickerDialog

@Composable
fun AddEditSleepScreen(
    navController: NavController
) {
    val openTimePickerDialog = remember { mutableStateOf(false) }
    
    Button(onClick = {
        openTimePickerDialog.value = true
    }) {
        Text(text = "Start")
    }
    
    if(openTimePickerDialog.value) {
        TimePickerDialog(onCancel = { /*TODO*/ }, onConfirm = { /*TODO*/ }) {
            
        }
    }
}