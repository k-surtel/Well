package com.ks.well.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ks.well.core.presentation.MainViewModel
import java.time.format.DateTimeFormatter

@Composable
fun DayView(
    viewModel: MainViewModel,
    navController: NavController
) {
    val openDialog = remember { mutableStateOf(false) }
    val date = viewModel.selectedDate.collectAsState()

    Box(
        Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 500.dp)
            .fillMaxHeight(0.7f)
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.secondary)
    ) {
        val datePattern = "dd.MM.yyyy"
        Column(Modifier.fillMaxWidth()) {
            Text(text = date.value.format(DateTimeFormatter.ofPattern(datePattern)), fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(viewModel.sleep) {
                    Text("${it.startTime} - ${it.endTime}")
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Box(
                    Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .background(MaterialTheme.colorScheme.primary)
                        .clickable {
                            openDialog.value = true
                        }
                ) {
                    Text("Add")
                }
            }
        }
    }

    if (openDialog.value) {
        AddMenuDialog(
            onDismissRequest = { openDialog.value = false },
            navController = navController
        )
    }
}