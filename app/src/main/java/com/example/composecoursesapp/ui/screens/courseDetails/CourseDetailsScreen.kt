package com.example.composecoursesapp.ui.screens.courseDetails

import android.app.Activity
import android.os.Build
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.coloredShadow
import com.example.composecoursesapp.ui.screens.courseDetails.components.CourseContentCard
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

    val isDarkTheme =  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) LocalConfiguration.current.isNightModeActive else false
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
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.tag_shape),
                    contentDescription = null
                )
                Text(text = "Beginner", style = MaterialTheme.typography.titleSmall.copy(
                    fontSize = 12.sp
                ) , color = Black)
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 35.dp),
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
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "About this course",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 16.sp
                    ),
                    color = MaterialTheme.colorScheme.onSecondary
                )
                Spacer(modifier = Modifier.height(4.dp))
                AnimatedContent(targetState = isAboutTextExpanded) {
                    Text(text = "This course is designed to help you learn about product design. It will help you learn about the basics of product design and how to get started with it. It will also help you learn about the different tools that are used in product design. You will also learn about the different types of product design and how to get started with it. You will also learn about the different types of product design and how to get started with it.",
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontSize = 12.sp
                        ),
                        color = Gray61,
                        maxLines = if (it) Int.MAX_VALUE else 2,
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() },
                        ) {
                            isAboutTextExpanded = !isAboutTextExpanded
                        }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(vertical = 12.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                if (!isAboutTextExpanded)
                    LazyColumn(
                        modifier = Modifier.weight(1f).padding(bottom = 100.dp),
                    ){
                        item {
                            CourseContentCard(
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
                Row(
                    modifier = Modifier
                        .padding(bottom = 34.dp, top = 14.dp)
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFEBF0)
                        ),
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .height(50.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_star_otline),
                            contentDescription = null,
                            tint = Color(0xFFFF6905),
                        )
                    }
                    Spacer(modifier = Modifier.width(14.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Blue
                        ),
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                    ) {
                        Text(
                            text = "Buy Now", style = MaterialTheme.typography.titleMedium.copy(
                                fontSize = 16.sp
                            ), color = Color.White
                        )
                    }
                }
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