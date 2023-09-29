package com.ks.well.core.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ks.well.feature_sleep.domain.model.Sleep

@Composable
fun SleepView(sleep: List<Sleep>) {
    LazyColumn {
        items(sleep) {
            Text(
                text = "${it.startDateTime} - ${it.endDateTime}",
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}