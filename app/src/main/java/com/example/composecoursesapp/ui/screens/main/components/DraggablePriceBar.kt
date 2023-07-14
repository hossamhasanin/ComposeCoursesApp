package com.example.composecoursesapp.ui.screens.main.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
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
    circleStroke: Dp = 1.dp,
    padding: PaddingValues = PaddingValues(20.dp),
    maxNum: Int = 7000,
    prices: List<Int> = listOf(0, 1000, 2000, 3000, 4000, 5000, 6000, 7000),
    currency: String = "L.E",
    onPricesChanged: (Int, Int) -> Unit,
) {

    var size by remember {
        mutableStateOf(IntSize.Zero)
    }

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

    var maxSlidePercent by remember {
        mutableStateOf(0f)
    }

    var minPercent by remember {
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
            size = it
            maximumBarWidth = it.width - padding
                .calculateEndPadding(LayoutDirection.Ltr)
                .toPx() - ((circleSize + (circleStroke * 2) * 2)).toPx()
            maxSlidePercent = maximumBarWidth / it.width
            currentBarWidth = maximumBarWidth * highSlidePercent
            Log.d("DraggablePriceBar", "maxSlidePercent: $maxSlidePercent")
        }) {
        Column {
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
                        //                    .padding(start = (maximumBarWidth * lowSlidePercent).toDp())
                        .size(circleSize, circleSize)
                        .border(circleStroke, Color(0xFF3D5CFF), shape = RoundedCornerShape(50))
                        .padding(circleStroke)
                        .background(Color.White, shape = RoundedCornerShape(50))
                        //                    .offset{ IntOffset((200f).roundToInt() , 0) }
                        .draggable(
                            orientation = Orientation.Horizontal,
                            state = rememberDraggableState { delta ->
                                Log.d("DraggablePriceBar", "delta: $delta")
                                val offset = maximumBarWidth * lowSlidePercent
                                if (((offset + delta) / maximumBarWidth) < 0) {
                                    return@rememberDraggableState
                                }
                                val newPercent = ((offset + delta) / maximumBarWidth)
                                if ((highSlidePercent - newPercent) <= minPercent) {
                                    return@rememberDraggableState
                                }
                                lowSlidePercent = newPercent
                                currentBarWidth -= delta
                                Log.d("DraggablePriceBar", "lowSlidePercent: $lowSlidePercent")
                                Log.d("DraggablePriceBar", "highSlidePercent: $highSlidePercent")
                                currentLowPrice = prices.firstOrNull {
                                    val price = (maxNum * lowSlidePercent).roundToInt()
                                    (it - price).absoluteValue <= 100
                                } ?: return@rememberDraggableState
                                onPricesChanged(currentLowPrice, currentHighPrice)
                            }
                        )
                )

                Box(
                    modifier = Modifier
                        .width(currentBarWidth.toDp())
                        .height(2.dp)
                        .background(Color(0xFF3D5CFF))
                        .onSizeChanged {
                            currentBarSize = it
                            currentBarWidth = it.width.toFloat()
                        }
                )
                Box(
                    modifier = Modifier
                        .size(circleSize, circleSize)
                        .border(circleStroke, Color(0xFF3D5CFF), shape = RoundedCornerShape(50))
                        .padding(circleStroke)
                        .background(Color.White, shape = RoundedCornerShape(50))
                        //                    .offset{ IntOffset((highSlidePercent).roundToInt() , 0) }
                        .draggable(
                            orientation = Orientation.Horizontal,
                            state = rememberDraggableState { delta ->
                                Log.d(
                                    "DraggablePriceBar",
                                    "delta: ${maximumBarWidth * lowSlidePercent}"
                                )
                                if (((currentBarWidth + delta) + (maximumBarWidth * lowSlidePercent)) >= maximumBarWidth) {
                                    return@rememberDraggableState
                                }
                                val newPercent =
                                    ((currentBarWidth + delta) + (maximumBarWidth * lowSlidePercent)) / maximumBarWidth
                                if ((newPercent - lowSlidePercent) <= minPercent) {
                                    return@rememberDraggableState
                                }
                                currentBarWidth += delta
                                highSlidePercent = newPercent
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
                        .offset(x = ((maximumBarWidth * lowSlidePercent) + ((circleSize.toPx() / 2) - 55)).toDp())
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