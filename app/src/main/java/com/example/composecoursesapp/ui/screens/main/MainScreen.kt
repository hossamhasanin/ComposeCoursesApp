package com.example.composecoursesapp.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.coloredShadow
import com.example.composecoursesapp.ui.screens.main.components.AnimatedBarIndicator
import com.example.composecoursesapp.ui.screens.main.components.CustomBottomNav
import com.example.composecoursesapp.ui.screens.main.components.LearnedTodayProgress
import com.example.composecoursesapp.ui.screens.main.components.LearningPlanSection
import com.example.composecoursesapp.ui.screens.main.components.MeetUpCard
import com.example.composecoursesapp.ui.screens.main.components.SuggestionsSection
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        bottomBar = {
            CustomBottomNav()
        },
        containerColor = Color.White
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = it.calculateBottomPadding() - 8.dp)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.25f)
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFF3D5CFF)
                    )
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 20.dp, end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 9.dp)
                    ) {
                        Text(
                            text = "Hi, Hossam",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.White
                        )
                        Text(
                            text = "Let’s start learning",
                            style = MaterialTheme.typography.titleSmall,
                            color = Color.White
                        )
                    }

                    Image(
                        painter = painterResource(R.drawable.avatar),
                        contentDescription = "avatar"
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    LearnedTodayProgress(
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp, top = 19.dp)
                            .fillMaxWidth()
                            .coloredShadow(
                                color = Color(0x4DB8B8D2),
                                offsetY = 8.dp,
                                blurRadius = 12.dp,
                                borderRadius = 16.dp
                            )
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(16.dp)
                            ),
                        learnedMinutes = 46,
                        totalMinutes = 60
                    )

                    SuggestionsSection(
                        modifier = Modifier
                            .padding(top = 16.dp, start = 12.dp)
                    )

                    LearningPlanSection(
                        modifier = Modifier
                            .padding(top = 25.dp, start = 20.dp , end = 20.dp)
                    )

                    MeetUpCard(
                        modifier = Modifier
                            .padding(top = 14.dp, start = 20.dp, end = 20.dp)
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun MainScreenPreview() {
    ComposeCoursesAppTheme {
        MainScreen()
    }
}