package com.example.composecoursesapp.ui.screens.courseDetails.components

import android.os.Build
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.ui.isDarkTheme
import com.example.composecoursesapp.ui.theme.Blue
import com.example.composecoursesapp.ui.theme.DarkGray
import com.example.composecoursesapp.ui.theme.Gray

@Composable
fun CourseHeaderInfoSection(modifier: Modifier = Modifier) {
    val isDarkTheme =  isDarkTheme()

    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "Product Design v1.0",
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 20.sp
            ),
            color = MaterialTheme.colorScheme.onSecondary
        )

        Text(
            text = "$99.99", style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 20.sp
            ),
            color = Blue
        )
    }
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = "6h 14min · 24 Lessons",
        style = MaterialTheme.typography.titleSmall.copy(
            fontSize = 12.sp
        ),
        color = if (isDarkTheme) Gray else DarkGray
    )
}