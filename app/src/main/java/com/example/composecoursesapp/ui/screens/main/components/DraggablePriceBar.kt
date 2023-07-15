package com.example.composecoursesapp.ui.screens.main.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.ui.toDp
import com.example.composecoursesapp.ui.toPx
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

@Composable
fun DraggablePriceBar(
    circleSize: Dp = 20.dp,
    circleStroke: Dp = 2.dp,
    padding: PaddingValues = PaddingValues(20.dp),
    maxNum: Int = 7000,
    prices: List<Int> = listOf(0, 1000, 2000, 3000, 4000, 5000, 6000, 7000),
    currency: String = "L.E",
    onPricesChanged: (Int, Int) -> Unit,
    color: Color = MaterialTheme.colorScheme.primary,
    colorContrast: Color = MaterialTheme.colorScheme.onPrimary,
) {

    // Optimize the prices values to fit the low and high price text on screen
    // If the values are a lot there is no enough room for both high/low texts indicators without collapsing on each other
    // tested with 8 values max and text font size of 12.sp

    var currentBarSize by remember {
        mutableStateOf(IntSize.Zero)
    }

    var currentBarWidth by remember {
        mutableStateOf(0f)
    }

    var highSlidePercent by remember {
        mutableStateOf(1f / prices.size)
    }

    var lowSlidePercent by remember {
        mutableStateOf(0f)
    }

    var maximumBarWidth by remember {
        mutableStateOf(0f)
    }

    // Dividing the bar into equal percent chunks
    val minPercentBeforeColliding by remember {
        mutableStateOf(1f / prices.size)
    }

    var currentHighPrice by remember {
        mutableStateOf(prices[1])
    }

    var currentLowPrice by remember {
        mutableStateOf(prices[0])
    }

    LaunchedEffect(true){
        onPricesChanged(currentLowPrice, currentHighPrice)
    }

    Box(modifier = Modifier
        .padding(paddingValues = padding)
        .fillMaxWidth()
        .onSizeChanged {
            maximumBarWidth = it.width - padding
                .calculateEndPadding(LayoutDirection.Ltr)
                .toPx() - ((circleSize + (circleStroke * 2) * 2)).toPx()
            val maxSlidePercent = maximumBarWidth / it.width
            currentBarWidth = maximumBarWidth * highSlidePercent
            Log.d("DraggablePriceBar", "maxSlidePercent: $maxSlidePercent")
        }) {
        Box(
            modifier = Modifier
                .padding((circleSize/2) + (circleStroke / 2))
                .width(maximumBarWidth.toDp())
                .height(1.dp)
                .background(Color(0xFFB8B8D2))
                .align(Alignment.TopCenter)
        )
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .width((maximumBarWidth * lowSlidePercent).toDp())
                )
                Box(
                    modifier = Modifier
                        .size(circleSize, circleSize)
                        .border(circleStroke, color, shape = RoundedCornerShape(50))
                        .padding(circleStroke)
                        .background(colorContrast, shape = RoundedCornerShape(50))
                        .draggable(
                            orientation = Orientation.Horizontal,
                            state = rememberDraggableState { delta ->
                                Log.d("DraggablePriceBar", "delta: $delta")
                                val movedLowCircleDist = maximumBarWidth * lowSlidePercent
                                val calcMoveLowCirclePercent = (movedLowCircleDist + delta) / maximumBarWidth
                                if (calcMoveLowCirclePercent < 0) {
                                    return@rememberDraggableState
                                }
                                // preventing two circles from colliding to each other
                                if ((highSlidePercent - calcMoveLowCirclePercent) <= minPercentBeforeColliding) {
                                    return@rememberDraggableState
                                }
                                lowSlidePercent = calcMoveLowCirclePercent
                                currentBarWidth -= delta
                                Log.d("DraggablePriceBar", "lowSlidePercent: $lowSlidePercent")
                                Log.d("DraggablePriceBar", "highSlidePercent: $highSlidePercent")
                                // when lowSlidePercent is lower than the minPercent before two sliders collide with each other
                                // just output the first value of the given prices
                                currentLowPrice = if (lowSlidePercent < minPercentBeforeColliding) prices[0] else prices.firstOrNull {
                                    val price = (maxNum * lowSlidePercent).roundToInt()
                                    (it - price).absoluteValue <= 100
                                } ?: return@rememberDraggableState
                                onPricesChanged(currentLowPrice, currentHighPrice)
                            }
                        )
                )

                Box(
                    modifier = Modifier
                        .padding(top = circleStroke)
                        .width(currentBarWidth.toDp())
                        .height(circleStroke)
                        .background(color)
                        .onSizeChanged {
                            currentBarSize = it
                            currentBarWidth = it.width.toFloat()
                        }
                )
                Box(
                    modifier = Modifier
                        .size(circleSize, circleSize)
                        .border(circleStroke, color, shape = RoundedCornerShape(50))
                        .padding(circleStroke)
                        .background(colorContrast, shape = RoundedCornerShape(50))
                        .draggable(
                            orientation = Orientation.Horizontal,
                            state = rememberDraggableState { delta ->
                                val movedLowCircleDist = maximumBarWidth * lowSlidePercent
                                Log.d(
                                    "DraggablePriceBar",
                                    "delta: $movedLowCircleDist"
                                )
                                val calcMoveHighCircleDist = (currentBarWidth + delta) + movedLowCircleDist
                                if (calcMoveHighCircleDist >= maximumBarWidth) {
                                    return@rememberDraggableState
                                }
                                val movePercent = calcMoveHighCircleDist / maximumBarWidth
                                if ((movePercent - lowSlidePercent) <= minPercentBeforeColliding) {
                                    return@rememberDraggableState
                                }
                                currentBarWidth += delta
                                highSlidePercent = movePercent
                                Log.d("DraggablePriceBar", "lowSlidePercent: $lowSlidePercent")
                                Log.d("DraggablePriceBar", "highSlidePercent: $highSlidePercent")
                                currentHighPrice = prices.firstOrNull {
                                    val price = (maxNum * highSlidePercent).roundToInt()
                                    (it - price).absoluteValue <= 100
                                } ?: return@rememberDraggableState
                                onPricesChanged(currentLowPrice, currentHighPrice)
                            }
                        )
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    text = "$currentLowPrice $currency",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontSize = 12.sp
                    ),
                    color = Color(0xFF1F1F39),
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .offset(x = if (currentLowPrice > 0)
                                ((maximumBarWidth * lowSlidePercent) - ((circleSize.toPx() / 2))).toDp()
                                else (maximumBarWidth * lowSlidePercent).toDp()
                        )
                )
                Text(
                    text = "$currentHighPrice $currency",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontSize = 12.sp
                    ),
                    color = Color(0xFF1F1F39),
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .offset(x = ((maximumBarWidth * highSlidePercent) + (circleSize.toPx() / 2)).toDp())
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DraggablePriceBarPreview() {
    DraggablePriceBar(
        padding = PaddingValues(16.dp),
        onPricesChanged = { low, high ->
            Log.d("DraggablePriceBar", "low: $low")
            Log.d("DraggablePriceBar", "high: $high")
        }
    )
}