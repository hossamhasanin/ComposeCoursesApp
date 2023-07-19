package com.example.composecoursesapp.ui.screens.courses.components

import android.os.Build
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.ui.coloredShadow
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainContentSection(
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()


    Column(
        modifier = modifier
    ) {
        CoursesCategoriesSection(
            modifier = Modifier.padding(start = 20.dp , end = 20.dp)
        )

        Text(
            text = "Choose your course",
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 18.sp
            ),
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(top = 36.dp , start = 20.dp , end = 20.dp)
        )

        AnimatedTabsLayout(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 8.dp),
            tabs = listOf("All", "Popular", "New"),
            activeColor = MaterialTheme.colorScheme.primary,
            activeTextColor = MaterialTheme.colorScheme.onPrimary,
            inactiveColor = MaterialTheme.colorScheme.tertiary,
            inactiveTextColor = MaterialTheme.colorScheme.onTertiary,
            onTabSelected = {
                scope.launch {
                    pagerState.animateScrollToPage(it)
                }
            }
        )

        HorizontalPager(
            pageCount = 3,
            state = pagerState,
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
                .weight(1f),
            userScrollEnabled = false
        ) {
            LaunchedEffect(true){
                Log.d("CoursesScreen", "CoursesScreen: $it")
            }
            LazyColumn{
                items(5){
                    CourseCard(
                        title = "Learn to Draw",
                        ownerName = "John Doe",
                        imageUrl = "",
                        price = "150",
                        hours = "10",
                        currency = "LE",
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}