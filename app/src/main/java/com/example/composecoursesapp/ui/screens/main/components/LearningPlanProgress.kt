package com.example.composecoursesapp.ui.screens.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme

@Composable
fun LearningPlanProgress(
    modifier: Modifier = Modifier,
    title: String,
    spent: Int,
    total: Int,
    progressStroke: Dp = 3.dp,
    progressColor: Color = Color(0xFF1F1F39)
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            CircularProgressIndicator(
                progress = spent/total.toFloat(),
                color = progressColor,
                modifier = Modifier
                    .size(18.dp),
                strokeWidth = progressStroke
            )

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 14.sp
                ),
                modifier = Modifier
                    .padding(start = 13.dp),
                color = Color(0xFF1F1F39)
            )
        }

        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = Color(0xFF1F1F39)
                    )
                ) {
                    append("$spent")
                }

                withStyle(
                    style = SpanStyle(
                        fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = Color(0xFFB8B8D2)
                    )
                ) {
                    append("/$total")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LearningPlanProgressPreview() {
    ComposeCoursesAppTheme {
        LearningPlanProgress(
            title = "Packaging Design",
            spent = 40,
            total = 48
        )
    }
}