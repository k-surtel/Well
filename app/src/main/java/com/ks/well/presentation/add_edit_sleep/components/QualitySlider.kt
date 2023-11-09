package com.ks.well.presentation.add_edit_sleep.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import kotlin.math.roundToInt

@Composable
fun QualitySlider(
    sliderPosition: MutableState<Float>
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(
            value = sliderPosition.value,
            onValueChange = { sliderPosition.value = it },
            steps = 9,
            valueRange = 0f..10f
        )
        Text(text = when(sliderPosition.value.roundToInt()) {
            0 -> "Absolutely horrible (0)"
            1 -> "Horrible (1)"
            2 -> "Awful (2)"
            3 -> "Bad (3)"
            4 -> "Not good (4)"
            5 -> "Meh (5)"
            6 -> "So so (6)"
            7 -> "Okay (7)"
            8 -> "Good (8)"
            9 -> "Really good (9)"
            10 -> "Amazing (10)"
            else -> ""
        })
    }
}