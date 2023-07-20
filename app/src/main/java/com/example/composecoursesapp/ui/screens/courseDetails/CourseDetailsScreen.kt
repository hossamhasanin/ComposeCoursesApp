package com.example.composecoursesapp.ui.screens.courseDetails

import android.app.Activity
import android.os.Build
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.coloredShadow
import com.example.composecoursesapp.ui.screens.courseDetails.components.AboutCourseSection
import com.example.composecoursesapp.ui.screens.courseDetails.components.BottomButtonsSection
import com.example.composecoursesapp.ui.screens.courseDetails.components.CourseContentCard
import com.example.composecoursesapp.ui.screens.courseDetails.components.CourseHeaderInfoSection
import com.example.composecoursesapp.ui.theme.Black
import com.example.composecoursesapp.ui.theme.Blue
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme
import com.example.composecoursesapp.ui.theme.DarkGray
import com.example.composecoursesapp.ui.theme.Gray
import com.example.composecoursesapp.ui.theme.Gray61

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CourseDetailsScreen(
    padding: PaddingValues = PaddingValues(),
) {

    var isAboutTextExpanded by remember { mutableStateOf(false) }


    val view = LocalView.current
    SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = Color(0xFFFFE7EE).toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true

    }

    Box(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .background(Color(0xFFFFE7EE))) {
            Image(imageVector = ImageVector.vectorResource(id = R.drawable.girl_cheering_illustration),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 23.dp)
                    .fillMaxWidth()
            )
        }

        Column {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back",
                    tint = Black,
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ){
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.tag_shape),
                    contentDescription = null,
                    modifier = Modifier
                        .matchParentSize(),
                    contentScale = ContentScale.FillBounds
                )
                Text(text = "Beginner", style = MaterialTheme.typography.titleSmall.copy(
                    fontSize = 12.sp
                ) , color = Black, modifier = Modifier.padding(start = 10.dp, end = 20.dp, top = 5.dp, bottom = 3.dp))
            }
            Spacer(modifier = Modifier.height(13.dp))
            Text(text = "Product Design v1.0", style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 20.sp
            ), color = Black, modifier = Modifier.padding(start = 20.dp, end = 40.dp))
        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.66f)
            .background(
                MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
            )
            .align(Alignment.BottomCenter)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                CourseHeaderInfoSection(
                    modifier = Modifier
                        .padding(top = 35.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                AboutCourseSection(
                    onAboutTextExpanded = { isAboutTextExpanded = it },
                )
                Spacer(modifier = Modifier.height(6.dp))
                if (!isAboutTextExpanded)
                    LazyColumn(
                        modifier = Modifier
                            .weight(1f)
                            .padding(bottom = 100.dp),
                    ){
                        item {
                            CourseContentCard(
                                modifier = Modifier.padding(bottom = 16.dp),
                                isPlayable = true,
                                onPlayClick = {},
                                isWatched = true,
                                orderId = "01",
                                title = "Introduction",
                                time = "3:30 mins"
                            )
                        }
                        items(5){
                            CourseContentCard(
                                modifier = Modifier.padding(bottom = 16.dp),
                                isPlayable = true,
                                onPlayClick = {},
                                isWatched = false,
                                orderId = "01",
                                title = "Introduction",
                                time = "3:30 mins"
                            )
                        }
                        item {
                            CourseContentCard(
                                modifier = Modifier.padding(bottom = 16.dp),
                                isPlayable = false,
                                onPlayClick = {},
                                isWatched = false,
                                orderId = "01",
                                title = "Course Overview",
                                time = "3:30 mins"
                            )
                        }
                    }
            }
            Box(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .align(Alignment.BottomCenter)
                    .background(MaterialTheme.colorScheme.secondary),
                contentAlignment = Alignment.BottomCenter
            ) {
                BottomButtonsSection(
                    modifier = Modifier
                        .padding(bottom = 34.dp, top = 14.dp)
                )
            }
        }

    }
}

@Preview
@Composable
fun CourseDetailsScreenPreview() {
    ComposeCoursesAppTheme(dynamicColor = false) {
        CourseDetailsScreen()
    }
}