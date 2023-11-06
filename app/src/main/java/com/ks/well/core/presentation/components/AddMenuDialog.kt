package com.ks.well.core.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.ks.well.core.presentation.MainViewModel
import com.ks.well.core.presentation.Screen

@Composable
fun AddMenuDialog(
    onDismissRequest: () -> Unit,
    viewModel: MainViewModel,
    navController: NavController
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                Modifier.fillMaxWidth()
            ) {
                Box(
                    Modifier.clickable {
                        val date = viewModel.displayState.value.selectedDate
                        navController.navigate(Screen.AddEditSleepScreen.route
                                + "?year=${date.year}&month=${date.monthValue}&day=${date.dayOfMonth}")
                    }
                        .fillMaxWidth()
                        .height(70.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Sleep")
                }
            }
        }
    }
}