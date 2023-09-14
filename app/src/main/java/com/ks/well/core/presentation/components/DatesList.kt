package com.ks.well.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.time.LocalDate

@Composable
fun DatesList() {
    val listState = rememberLazyListState()
    val today = LocalDate.now()
    val datesList = mutableListOf<LocalDate>()

    repeat(365) {
        val date = today.minusDays(it.toLong())
        datesList.add(date)
    }

    LazyRow(
        reverseLayout = true
    ) {
        items(datesList) {
            Box(
                modifier = Modifier
                    .width(70.dp)
                    .height(80.dp)
                    .padding(end = 16.dp, bottom = 16.dp)
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text(text = it.dayOfMonth.toString())
            }
        }
    }

    listState.OnBottomReached {
        // do on load more
        //viewModel.fetchMoreItems()
    }
}



@Composable
fun LazyListState.OnBottomReached(
    loadMore : () -> Unit
){
    val shouldLoadMore = remember {
        derivedStateOf {
            val lastVisibleItem = layoutInfo.visibleItemsInfo.lastOrNull() ?: return@derivedStateOf true
            lastVisibleItem.index == layoutInfo.totalItemsCount - 1
        }
    }

    // Convert the state into a cold flow and collect
    LaunchedEffect(shouldLoadMore){
        snapshotFlow { shouldLoadMore.value }
            .collect {
                // if should load more, then invoke loadMore
                if (it) loadMore()
            }
    }
}