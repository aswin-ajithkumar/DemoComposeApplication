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
import kotlinx.coroutines.delay

@Composable
fun EffectHandler() {
    val text by remember { mutableStateOf("") }
    Scaffold {
        Column(modifier = Modifier.padding()) {
            LaunchedEffect(key1 = true) {
                delay(1000L)
                println("The text is $text")
            }
        }
    }
}