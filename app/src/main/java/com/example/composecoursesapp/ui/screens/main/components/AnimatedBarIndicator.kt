package com.example.composecoursesapp.ui.screens.main.components

import android.content.res.Resources
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.composecoursesapp.ui.toDp

@Composable
fun AnimatedBarIndicator(
    modifier: Modifier = Modifier,
    value: Float,
    progressGradientBackground: Brush = Brush.horizontalGradient(
        colors = listOf(
            Color(0x00FFFFFF),
            Color(0xFFFF5106),
        )
    ),
    background: Color = Color(0xFFF3F2FF),
    cornerShape: RoundedCornerShape = RoundedCornerShape(50),
    animDuration: Int = 2000,
) {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }

    var isAnimationPlayed by remember {
        mutableStateOf(false)
    }

    val animatedValue = animateFloatAsState(
        targetValue = if (isAnimationPlayed) value else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
        )
    )

    LaunchedEffect(true) {
        isAnimationPlayed = true
    }

    Box(
        modifier = modifier
            .onSizeChanged {
                size = it
            }
    ) {

        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                color = background,
                shape = cornerShape
                )
        )

        Box(modifier = Modifier
            .fillMaxHeight()
            .width((size.width.toFloat() * animatedValue.value).toDp())
            .background(
                progressGradientBackground,
                shape = cornerShape
            )
        )
    }
}



@Preview
@Composable
fun AnimatedBarIndicatorPreview() {
    AnimatedBarIndicator(
        value = 0.9f,
        modifier = Modifier
            .height(8.dp)
            .fillMaxWidth()
    )
}