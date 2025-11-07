package com.dev.composenav.components.ui

import android.content.Context
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dev.composenav.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashEnd: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val animatedSize = remember { Animatable(96f) }
    val animatedTilt = remember { Animatable(0f) }
    val animatedAlpha = remember { Animatable(1f) }
    LaunchedEffect (Unit) {
        delay(200)
        animatedSize.animateTo(
            targetValue = 192f,
            animationSpec = spring(
                stiffness = Spring.StiffnessMedium,
                dampingRatio = Spring.DampingRatioMediumBouncy
            )
        )
        animatedTilt.animateTo(
            targetValue = 15f,
            animationSpec = spring(
                stiffness = Spring.StiffnessLow,
                dampingRatio = Spring.DampingRatioNoBouncy
            )
        )
        animatedTilt.animateTo(
            targetValue = 0f,
            animationSpec = spring(
                stiffness = Spring.StiffnessMedium,
                dampingRatio = Spring.DampingRatioMediumBouncy
            )
        )
        delay(1000)
        animatedAlpha.animateTo(
            targetValue = 0f,
            animationSpec = spring(stiffness = Spring.StiffnessLow)
        )
        onSplashEnd()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer { alpha = animatedAlpha.value }
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column (horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(R.drawable.app_logo),
                contentDescription = "app logo",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(animatedSize.value.dp)
                    .graphicsLayer {
                        rotationZ = animatedTilt.value
                    }
            )
        }
    }
}

@Composable
fun isFirstTimeVisit():Boolean {
    val context = LocalContext.current
    val prefs = context.getSharedPreferences("com.dev.composenav", Context.MODE_PRIVATE)
    val isFirstVisit = prefs.getBoolean("is_first_open", true)
    if (isFirstVisit) {
        prefs.edit().putBoolean("is_first_open", false).apply()
    }
    return isFirstVisit
}