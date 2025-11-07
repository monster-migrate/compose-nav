package com.dev.composenav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.dev.composenav.components.screens.Landing
import com.dev.composenav.components.ui.SplashScreen

@Composable
fun ComposeNavApp() {
    var isSplashinTime by remember { mutableStateOf(true) }
    if (isSplashinTime) {
        SplashScreen(onSplashEnd = { isSplashinTime = false })
    } else {
        Landing()
    }
}
