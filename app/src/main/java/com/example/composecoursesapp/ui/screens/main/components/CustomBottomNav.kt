package com.example.composecoursesapp.ui.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme


@Composable
fun CustomBottomNav() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStart = 25.dp,
                        topEnd = 25.dp
                    )
                )
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 31.dp , bottom = 31.dp)
                    .height(65.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 26.dp, height = 2.dp)
                            .background(
                                color = Color(0xFF3D5CFF),
                                shape = CircleShape
                            )
                    )
                    Icon(
                        painterResource(id = R.drawable.home),
                        contentDescription = "Search",
                        modifier = Modifier.
                        padding(top = 13.dp),
                        tint = Color(0xFF3D5CFF)
                    )

                    Text(
                        text = "Home",
                        modifier = Modifier
                            .padding(top = 11.dp),
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFF3D5CFF)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 28.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 26.dp, height = 2.dp)
                            .background(
                                color = Color.White,
                                shape = CircleShape
                            )
                    )
                    Icon(
                        painterResource(id = R.drawable.ic_courses),
                        contentDescription = "Search",
                        modifier = Modifier.
                        padding(top = 13.dp),
                        tint = Color(0xFFF4F3FD)
                    )

                    Text(
                        text = "Courses",
                        modifier = Modifier
                            .padding(top = 11.dp),
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFFB8B8D2)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .padding(end = 24.dp)
                    .height(65.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 26.dp, height = 2.dp)
                            .background(
                                color = Color.White,
                                shape = CircleShape
                            )
                    )
                    Icon(
                        painterResource(id = R.drawable.ic_messages),
                        contentDescription = "Messages",
                        modifier = Modifier.
                        padding(top = 13.dp),
                        tint = Color(0xFFF4F3FD)
                    )

                    Text(
                        text = "Messages",
                        modifier = Modifier
                            .padding(top = 11.dp),
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFFB8B8D2)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 17.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 26.dp, height = 2.dp)
                            .background(
                                color = Color.White,
                                shape = CircleShape
                            )
                    )
                    Icon(
                        painterResource(id = R.drawable.ic_user),
                        contentDescription = "Account",
                        modifier = Modifier.
                        padding(top = 13.dp),
                        tint = Color(0xFFF4F3FD)
                    )

                    Text(
                        text = "Account",
                        modifier = Modifier
                            .padding(top = 14.dp),
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFFB8B8D2)
                    )
                }
            }
        }

        SearchButton()

    }
}

@Composable
fun BoxScope.SearchButton() {
    Column(
        modifier = Modifier
            .align(Alignment.TopCenter)
            .padding(bottom = 20.dp, end = 9.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = CircleShape
                )
                .size(58.dp)
        ) {
            Box(modifier = Modifier
                .background(
                    color = Color(0xFFF4F3FD),
                    shape = CircleShape
                )
                .size(52.dp)
                .align(Alignment.Center)
            ) {
                Icon(
                    painterResource(id = R.drawable.search) ,
                    contentDescription = "search",
                    modifier = Modifier
                        .align(Alignment.Center),
                    tint = Color(0xFF3D5CFF)
                )
            }
        }

        Text(
            text = "Search",
            modifier = Modifier
                .padding(top = 7.dp),
            style = MaterialTheme.typography.labelSmall,
            color = Color(0xFFB8B8D2)
        )
    }
}

@Preview
@Composable
fun CustomBottomNavPreview() {
    ComposeCoursesAppTheme {
        CustomBottomNav()
    }
}