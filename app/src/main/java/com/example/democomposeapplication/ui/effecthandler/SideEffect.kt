package com.example.democomposeapplication.ui.effecthandler

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

@Composable
fun SideEffect(nonComposeCounter: Int) {
    SideEffect{
        println("Called after every recomposition")
    }
}