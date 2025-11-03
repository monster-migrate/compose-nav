package com.dev.composenav.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dev.composenav.ComposeNavApp
import com.dev.composenav.ui.theme.ComposeNavTheme

@Preview
@Composable
fun Staging() {
    ComposeNavTheme {
        ComposeNavApp()
    }
}