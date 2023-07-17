package com.example.composecoursesapp.ui.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.ui.coloredShadow
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme
import com.example.composecoursesapp.ui.theme.Gray

@Composable
fun LearningPlanSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Learning Plan",
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 18.sp
            ),

            color = MaterialTheme.colorScheme.onBackground
        )

        Box(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .coloredShadow(
                    color = Gray.copy(alpha = 0.2f),
                    offsetY = 8.dp,
                    borderRadius = 16.dp,
                    blurRadius = 12.dp
                )
                .background(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 25.dp)
                    .fillMaxWidth()
            ) {
                LearningPlanProgress(
                    title = "Packaging Design",
                    spent = 40,
                    total = 48,
                    progressColor = MaterialTheme.colorScheme.inverseSurface
                )

                LearningPlanProgress(
                    title = "Packaging Design",
                    spent = 40,
                    total = 48,
                    modifier = Modifier.padding(top = 16.dp),
                    progressColor = MaterialTheme.colorScheme.inverseSurface
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LearningPlanSectionPreview() {
    ComposeCoursesAppTheme {
        LearningPlanSection(
            modifier = Modifier
                .padding(16.dp)
        )
    }
}