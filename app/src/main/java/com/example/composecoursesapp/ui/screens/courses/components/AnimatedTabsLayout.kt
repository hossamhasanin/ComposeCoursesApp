package com.example.composecoursesapp.ui.screens.courses.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme
import com.example.composecoursesapp.ui.toPx
import kotlin.math.roundToInt

@Composable
fun AnimatedTabsLayout(
    modifier: Modifier = Modifier,
    tabsSpacing: Dp = 17.dp,
    tabsWidth: Dp = 73.dp,
    tabsHeight: Dp = 28.dp,
    textStyle: TextStyle = MaterialTheme.typography.titleSmall.copy(
        fontSize = 14.sp
    ),
    activeColor: Color = Color(0xFF3D5CFF),
    inactiveColor: Color = Color(0xFFA1A8B3),
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = Color(0xFFFFFFFF),
    tabs: List<String>,
    onTabSelected: (Int) -> Unit,
) {
    var selectedTab by remember {
        mutableStateOf(0)
    }
    val animatedActiveBgOffset by animateFloatAsState(targetValue = selectedTab * (tabsWidth.toPx() + tabsSpacing.toPx()))

    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Box(modifier = Modifier
            .offset { IntOffset(animatedActiveBgOffset.roundToInt(), 0) }
            .height(tabsHeight)
            .width(tabsWidth)
            .background(
                color = activeColor,
                shape = RoundedCornerShape(16.dp)
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ){
            tabs.forEachIndexed { index, tab ->
                Box(
                    modifier = Modifier
                        .height(tabsHeight)
                        .width(tabsWidth)
                        .drawBehind {
                            drawRoundRect(
                                color = if (index != selectedTab) inactiveColor else Color.Transparent,
                                topLeft = Offset(0f, 0f),
                                size = Size(size.width, size.height),
                                cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
                            )
                        }
                        .clip(RoundedCornerShape(16.dp))
                        .clickable {
                            selectedTab = index
                            onTabSelected(index)
                        },
                    contentAlignment = Alignment.Center
                ){
                    Text(text = tab,
                        style = textStyle,
                        color = if (index == selectedTab) activeTextColor else inactiveTextColor
                    )
                }
                Spacer(modifier = Modifier.width(tabsSpacing))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatedTabsLayoutPreview() {
    ComposeCoursesAppTheme(dynamicColor = false) {
        AnimatedTabsLayout(
            modifier = Modifier,
            tabs = listOf("All", "Popular", "New"),
            onTabSelected = {}
        )
    }
}