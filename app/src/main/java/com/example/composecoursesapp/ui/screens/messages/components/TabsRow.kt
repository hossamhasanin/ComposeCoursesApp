package com.example.composecoursesapp.ui.screens.messages.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.ui.isDarkTheme
import com.example.composecoursesapp.ui.theme.Black
import com.example.composecoursesapp.ui.theme.Blue
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme
import com.example.composecoursesapp.ui.theme.Gray
import com.example.composecoursesapp.ui.toPx
import kotlin.math.roundToInt

@Composable
fun TabsRow(
    modifier: Modifier = Modifier,
    tabs: List<TabData>,
    onTabSelected: (Int) -> Unit,
    customTabWidth: Dp? = null,
    isScrollable: Boolean = false,
    indicationBarWidth: Dp = 42.dp,
    indicationBarColor: Color = Blue,
) {

    var selectedTab by rememberSaveable {
        mutableStateOf(0)
    }

    var tabWidth by remember(customTabWidth) {
        mutableStateOf(customTabWidth?.toPx() ?: 0f)
    }

    val animatedBarOffset by animateFloatAsState(
        targetValue = (selectedTab * tabWidth) + (tabWidth / 2) - (indicationBarWidth.toPx() / 2)
    )

    val scrollState = rememberScrollState()

    val tabModifier: RowScope.() -> Modifier = remember(customTabWidth) {
        {
           if (customTabWidth != null)
                Modifier.width(customTabWidth)
            else
                Modifier
                    .weight(1f)
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState , enabled = isScrollable)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            for ((index, tab) in tabs.withIndex()){
                Box(
                    modifier = tabModifier()
                        .onSizeChanged {
                            if (tabWidth == 0f) {
                                tabWidth = it.width.toFloat()
                            }
                        }
                        .clickable(
                            indication = null,
                            interactionSource = remember {
                                MutableInteractionSource()
                            }
                        ) {
                            selectedTab = index
                            onTabSelected(index)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Box {
                        Text(
                            text = tab.title,
                            style = if (selectedTab == index) MaterialTheme.typography.titleMedium.copy(
                                fontSize = 16.sp
                            ) else MaterialTheme.typography.titleSmall.copy(
                                fontSize = 16.sp
                            ),
                            color = if (isDarkTheme()) if (selectedTab == index) MaterialTheme.colorScheme.onBackground else Gray
                            else Black,
                            textAlign = TextAlign.Center
                        )

                        if (tab.showNotificationDot){
                            Box(
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .offset(x = 8.dp)
                                    .size(6.dp)
                                    .clip(RoundedCornerShape(50))
                                    .background(
                                        color = Color(0xFFFF6905),
                                        shape = RoundedCornerShape(50)
                                    )
                            )
                        }
                    }
                }
            }
        }
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 6.dp)
        ) {
            Box(
                modifier = modifier
                    .align(Alignment.CenterStart)
                    .offset {
                        IntOffset(animatedBarOffset.roundToInt(), 0)
                    }
                    .width(indicationBarWidth)
                    .height(2.dp)
                    .background(indicationBarColor)
            )
        }
    }
}

data class TabData(
    val title: String,
    val showNotificationDot: Boolean = false
)

@Preview(showBackground = true)
@Composable
fun TabsRowPreview() {
    ComposeCoursesAppTheme(dynamicColor = false) {
        TabsRow(
            tabs = listOf(
                TabData(
                    title = "message"
                ),
                TabData(
                    title = "notification",
                    showNotificationDot = true
                )
            ),
            onTabSelected = {}
        )
    }
}