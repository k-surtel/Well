package com.ks.well.presentation.main.components.features

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ks.well.domain.model.Sleep
import com.ks.well.presentation.main.Screen

@Composable
fun SleepView(
    navController: NavController,
    sleep: List<Sleep>
) {
    LazyColumn {
        items(sleep) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column {
                    if (sleep.indexOf(it) == 0) {
                        Text(
                            text = "Sleep",
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
                    var lengthString =
                        if (lengthH > 0) "Length: ${lengthH.toInt()}h " else "Length: "
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
                IconButton(onClick = {
                    navController.navigate(
                        Screen.AddEditSleepScreen.route
                                + "?sleepId=${it.id}")
                }) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit",
                        tint = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
        }
    }
}