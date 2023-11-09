package com.ks.well.core.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ks.well.feature_sleep.domain.model.Sleep

@Composable
fun SleepView(sleep: List<Sleep>) {
    LazyColumn {
        items(sleep) {
            Column {
                if (sleep.indexOf(it) == 0) {
                    Text(
                        text= "Sleep",
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    text = "${it.startDateTime.hour}:${it.startDateTime.minute} - ${it.endDateTime.hour}:${it.endDateTime.minute}",
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )

                val lengthH = kotlin.math.floor(it.duration / 60.0)
                val lengthM = it.duration - (lengthH * 60)
                var lengthString = if(lengthH > 0) "Length: ${lengthH.toInt()}h " else "Length: "
                lengthString += "${lengthM.toInt()}min"
                Text(
                    text = lengthString,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Text(
                    text = "Quality: ${it.quality}",
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}