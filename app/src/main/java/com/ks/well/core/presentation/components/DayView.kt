package com.ks.well.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DayView(dayLabel: String) {

    val openDialog = remember { mutableStateOf(false) }

    Box(
        Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 500.dp)
            .fillMaxHeight(0.7f)
            .padding(16.dp)
            .background(Color.Green)
    ) {
        Column(Modifier.fillMaxWidth()) {
            Text(text = dayLabel, fontSize = 24.sp)
            Spacer(modifier = Modifier.weight(1f))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(onClick = {
                    openDialog.value = true
                }) {
                    Text("Add")
                }
            }
        }
    }

    if (openDialog.value) {
        AddMenuDialog(onDismissRequest = { openDialog.value = false })
    }
}