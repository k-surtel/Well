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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    val date = viewModel.displayState.value.selectedDate

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 500.dp)
            .fillMaxHeight(0.7f)
            .padding(16.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(16.dp)
    ) {
        //val datePattern = "dd.MM.yyyy"
        val datePattern = "EEEE, dd MMM yyyy"
        Column(Modifier.fillMaxWidth()) {
            Text(
                text = date.format(DateTimeFormatter.ofPattern(datePattern)),
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Spacer(modifier = Modifier.height(16.dp))
            SleepView(sleep = viewModel.displayState.value.sleep)
            Spacer(modifier = Modifier.weight(1f))

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Box(
                    Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.primary)
                        .clickable {
                            openDialog.value = true
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Add",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }

    if (openDialog.value) {
        AddMenuDialog(
            onDismissRequest = { openDialog.value = false },
            viewModel = viewModel,
            navController = navController
        )
    }
}