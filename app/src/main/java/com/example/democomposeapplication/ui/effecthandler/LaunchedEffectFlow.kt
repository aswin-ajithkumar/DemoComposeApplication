package com.example.democomposeapplication.ui.effecthandler

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.wear.compose.material.Scaffold
import com.example.democomposeapplication.ui.viewmodel.LaunchedEffectViewModel
import kotlinx.coroutines.delay

@Composable
fun LaunchedEffectFlow(
    viewModel: LaunchedEffectViewModel
) {
    val text by remember { mutableStateOf("") }
    Scaffold {
        Column(modifier = Modifier.padding()) {
            LaunchedEffect(key1 = true) {
                viewModel.sharedFlow.collect() { event ->
                    when (event) {
                        is LaunchedEffectViewModel.ScreenEvents.ShowSnackBar -> {
                            delay(5000L)
                        }
                        is LaunchedEffectViewModel.ScreenEvents.Navigate -> {
                            println("The text is $text")
                        }
                    }
                }
            }
        }
    }
}