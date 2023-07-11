package com.example.composecoursesapp.ui.screens.main.components

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.ui.coloredShadow

@Composable
fun LearnedTodayProgress(
    modifier: Modifier = Modifier,
    learnedMinutes: Int,
    totalMinutes: Int,
    animationsDuration: Int = 2000
) {

    var isNumberAnimated by remember {
        mutableStateOf(false)
    }

    val animateMinutesNumber = animateIntAsState(
        targetValue = if (isNumberAnimated) learnedMinutes else 0,
        animationSpec = tween(
            durationMillis = animationsDuration
        )
    )

    LaunchedEffect(true){
        isNumberAnimated = true
    }

    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, end = 14.83.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Learned today",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 12.sp
                    ),
                    color = Color(0xFF858597)
                )

                Text(
                    text = "My courses",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 12.sp
                    ),
                    color = Color(0xFF3D5CFF)
                )
            }

            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF1F1F39),
                            fontSize = 20.sp,
                            fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(animateMinutesNumber.value.toString())
                        append("min")
                    }

                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF858597),
                            fontSize = 10.sp,
                            fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
                            fontWeight = FontWeight.Normal
                        )
                    ) {
                        append("/ ${totalMinutes}min")
                    }
                },
                modifier = Modifier
                    .padding(top = 2.dp),
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 3.dp, bottom = 16.dp, end = 16.dp)
            ) {
                AnimatedBarIndicator(
                    value = learnedMinutes / totalMinutes.toFloat(),
                    modifier = Modifier
                        .height(8.dp)
                        .fillMaxWidth(),
                    animDuration = animationsDuration
                )
            }
        }
    }
}

@Preview
@Composable
fun LearnedTodayProgressPreview() {
    LearnedTodayProgress(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 19.dp)
            .coloredShadow(
                color = Color(0x33B8B8D2),
                offsetY = 8.dp,
                blurRadius = 12.dp,
                borderRadius = 16.dp
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            ),
        learnedMinutes = 30,
        totalMinutes = 60
    )
}