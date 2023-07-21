package com.example.composecoursesapp.ui.screens.onBoarding

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.screens.onBoarding.components.OnBoardingSlider
import com.example.composecoursesapp.ui.screens.onBoarding.components.OnBoardingSliderItem
import com.example.composecoursesapp.ui.theme.DarkGray
import com.example.composecoursesapp.ui.theme.Gray

@Composable
fun OnBoardingScreen(
    padding: PaddingValues = PaddingValues(),
) {

    val skipTextColor = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        if (LocalConfiguration.current.isNightModeActive) Gray else DarkGray
    } else DarkGray

    val backgroundColor = MaterialTheme.colorScheme.background
    val isDarkTheme = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        LocalConfiguration.current.isNightModeActive
    } else false

    val view = LocalView.current
    SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = backgroundColor.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !isDarkTheme

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(padding),
    ) {
        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 16.dp, end = 16.dp)
        ) {
            Text(
                text = "Skip",
                style = MaterialTheme.typography.titleSmall.copy(
                    fontSize = 14.sp
                ),
                color = skipTextColor
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        OnBoardingSlider(
            onBoardingItems = listOf(
                OnBoardingSliderItem(
                    title = "Numerous free\n" +
                            "trial courses",
                    description = "Free courses for you to \n" +
                            "find your way to learning",
                    imageVector = ImageVector.vectorResource(id = R.drawable.blue_girl_illustration),
                ),
                OnBoardingSliderItem(
                    title = "Quick and easy \n" +
                            "learning",
                    description = "Easy and fast learning at \n" +
                            "any time to help you \n" +
                            "improve various skills",
                    painterImage = painterResource(id = R.drawable.orange_boy_illustration)
                ),
                OnBoardingSliderItem(
                    title = "Create your own \n" +
                            "study plan",
                    description = "Study according to the \n" +
                            "study plan, make study \n" +
                            "more motivated",
                    imageVector = ImageVector.vectorResource(id = R.drawable.rich_girl_illustration),
                )
            )
        )
    }
}