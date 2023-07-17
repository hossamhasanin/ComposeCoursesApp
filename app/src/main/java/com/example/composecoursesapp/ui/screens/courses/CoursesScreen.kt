package com.example.composecoursesapp.ui.screens.courses

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.screens.courses.components.AnimatedTabsLayout
import com.example.composecoursesapp.ui.screens.courses.components.CoursesCategoriesSection
import com.example.composecoursesapp.ui.screens.courses.components.FilterSearchTextField
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme

@Composable
fun CoursesScreen(
    modifier: Modifier = Modifier
) {
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
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Courses",
                    style = MaterialTheme.typography.titleMedium,
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
                onTabSelected = {}
            )
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