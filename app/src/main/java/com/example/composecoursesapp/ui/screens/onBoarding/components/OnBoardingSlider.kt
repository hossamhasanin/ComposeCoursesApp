package com.example.composecoursesapp.ui.screens.onBoarding.components

import android.os.Build
import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.theme.Blue
import com.example.composecoursesapp.ui.theme.Gray

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingSlider(
    modifier: Modifier = Modifier,
    onBoardingItems: List<OnBoardingSliderItem>,
) {

    val pagerState = rememberPagerState()

    val animatedDotsAnimation = onBoardingItems.map {
        animateDpAsState(targetValue = if (it == onBoardingItems[pagerState.currentPage]) 28.dp else 9.dp)
    }

    val dotsInActiveColor = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        if (LocalConfiguration.current.isNightModeActive) Gray else Color(0xFFEAEAFF)
    } else Color(0xFFEAEAFF)

    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            pageCount = onBoardingItems.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(260.dp)
                ){
                    if (onBoardingItems[it].imageVector == null)
                        Image(
                            painter = onBoardingItems[it].painterImage!!,
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    else
                        Image(
                            imageVector = onBoardingItems[it].imageVector!!,
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .fillMaxSize()
                        )
                }
                Spacer(modifier = Modifier.height(38.dp))
                Text(
                    text = onBoardingItems[it].title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 22.sp
                    ),
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = onBoardingItems[it].description,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 16.sp
                    ),
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.height(26.dp))
        Row {
            for ((index, animatedDots) in animatedDotsAnimation.withIndex()) {
                Box(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .height(5.dp)
                        .width(animatedDots.value)
                        .drawBehind {
                            drawRoundRect(
                                color = if (index == pagerState.currentPage) Blue else dotsInActiveColor,
                                cornerRadius = CornerRadius(5.dp.toPx(), 5.dp.toPx())
                            )
                        }
                )
            }
        }
    }

}

data class OnBoardingSliderItem(
    val title: String,
    val description: String,
    val imageVector: ImageVector? = null,
    val painterImage: Painter? = null
)