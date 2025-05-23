package com.example.democomposeapplication.ui.effecthandler

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember

@SuppressLint("RememberReturnType")
@Composable
fun EffectLaunchedAnimation(
    counter: Int,
) {
    val animatable = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = counter) {
        animatable.animateTo(counter.toFloat())
    }
}