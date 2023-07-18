package com.example.composecoursesapp.ui.screens.courses

import android.app.Activity
import android.os.Build
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.coloredShadow
import com.example.composecoursesapp.ui.screens.courses.components.AnimatedTabsLayout
import com.example.composecoursesapp.ui.screens.courses.components.CourseCard
import com.example.composecoursesapp.ui.screens.courses.components.CoursesCategoriesSection
import com.example.composecoursesapp.ui.screens.courses.components.FilterSearchTextField
import com.example.composecoursesapp.ui.theme.Blue
import com.example.composecoursesapp.ui.theme.BlueishGrey
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme
import com.example.composecoursesapp.ui.theme.DarkWhite
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CoursesScreen(
    modifier: Modifier = Modifier
) {

    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    val view = LocalView.current
    SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = Color.White.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true

    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.background
            )
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Courses",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 24.sp
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )

                Image(
                    painter = painterResource(R.drawable.avatar),
                    contentDescription = "avatar"
                )
            }

            FilterSearchTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            )

            CoursesCategoriesSection(
                modifier = Modifier.padding(top = 27.dp , start = 20.dp , end = 20.dp)
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
                var modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp)
                modifier =  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    if (LocalConfiguration.current.isNightModeActive)
                        modifier
                    else modifier.coloredShadow(
                        color = Color(0x4DB8B8D2),
                        borderRadius = 12.dp,
                        blurRadius = 8.dp,
                        offsetY = 4.dp
                    )
                } else {
                    modifier
                }
                LazyColumn{
                    items(1){
                        CourseCard(
                            title = "Learn to Draw",
                            ownerName = "John Doe",
                            imageUrl = "",
                            price = "150",
                            hours = "10",
                            currency = "LE",
                            modifier = modifier
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CoursesScreenPreview() {
    ComposeCoursesAppTheme(dynamicColor = false) {
        CoursesScreen()
    }
}