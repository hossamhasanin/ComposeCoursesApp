package com.example.composecoursesapp.ui.screens.main

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalTextToolbar
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.coloredShadow
import com.example.composecoursesapp.ui.screens.main.components.AnimatedBarIndicator
import com.example.composecoursesapp.ui.screens.main.components.CustomBottomNav
import com.example.composecoursesapp.ui.screens.main.components.LearnedTodayProgress
import com.example.composecoursesapp.ui.screens.main.components.LearningPlanSection
import com.example.composecoursesapp.ui.screens.main.components.MeetUpCard
import com.example.composecoursesapp.ui.screens.main.components.NavBarItem
import com.example.composecoursesapp.ui.screens.main.components.SuggestionsSection
import com.example.composecoursesapp.ui.theme.Blue
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme
import com.example.composecoursesapp.ui.theme.Gray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    padding: PaddingValues = PaddingValues(),
    navController: NavController = rememberNavController(),
) {

    val view = LocalView.current
    SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = Blue.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
    }


    Box(
        modifier = Modifier
            .padding(bottom = padding.calculateBottomPadding() - 8.dp)
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.25f)
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.primary,
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
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Text(
                        text = "Let’s start learning",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onPrimary
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
                            color = Gray.copy(alpha = 0.2f),
                            offsetY = 8.dp,
                            blurRadius = 12.dp,
                            borderRadius = 16.dp
                        )
                        .background(
                            color = MaterialTheme.colorScheme.secondary,
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

@Preview
@Composable
fun MainScreenPreview() {
    ComposeCoursesAppTheme(
        dynamicColor = false
    ) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            MainScreen()
        }
    }
}