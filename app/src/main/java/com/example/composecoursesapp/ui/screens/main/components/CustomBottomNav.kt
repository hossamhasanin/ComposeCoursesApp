package com.example.composecoursesapp.ui.screens.main.components

import android.os.Build
import android.util.Log
import android.view.WindowInsets.Side
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.coloredShadow
import com.example.composecoursesapp.ui.theme.Blue
import com.example.composecoursesapp.ui.theme.BlueishGrey
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme
import com.example.composecoursesapp.ui.theme.DarkGray
import com.example.composecoursesapp.ui.theme.DarkWhite
import com.example.composecoursesapp.ui.theme.Gray


@Composable
fun CustomBottomNav(
    modifier: Modifier = Modifier,
    items: List<NavBarItem>,
    navController: NavController
) {

    assert(items.size == 5)

    var selectedItem by remember { mutableStateOf(items[0].route) }

    SideEffect {
        Log.d("CustomBottomNav", "SideEffect "+selectedItem)
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.Transparent
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .coloredShadow(
                    color = Color(0x4DB8B8D2),
                    borderRadius = 25.dp,
                    blurRadius = 8.dp,
                    offsetY = 4.dp
                )
                .background(
                    color = MaterialTheme.colorScheme.background,
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
                    .padding(start = 31.dp, bottom = 31.dp)
                    .height(65.dp)
            ) {
                for (i in (0..1)){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(start = if (i == 0) 0.dp else 28.dp)
                            .fillMaxHeight()
                            .clickable {
                                items[i].onClick(navController)
                                selectedItem = items[i].route
                            }
                    ) {
                        AnimatedVisibility(visible = selectedItem == items[i].route) {
                            Box(
                                modifier = Modifier
                                    .size(width = 26.dp, height = 2.dp)
                                    .background(
                                        color = Blue,
                                        shape = CircleShape
                                    )
                            )
                        }
                        Icon(
                            painterResource(id = items[i].icon),
                            contentDescription = items[i].title,
                            modifier = Modifier.
                            padding(top = 13.dp),
                            tint = if (selectedItem == items[i].route) Blue else MaterialTheme.colorScheme.surfaceVariant
                        )

                        Text(
                            text = items[i].title,
                            modifier = Modifier
                                .padding(top = 11.dp),
                            style = MaterialTheme.typography.labelSmall,
                            color = if (selectedItem == items[i].route) Blue else Gray
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .padding(end = 24.dp)
                    .height(65.dp)
            ) {

                // loop on the last two items
                for (i in (3..4)){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(start = if (i == 3) 0.dp else 17.dp)
                            .fillMaxHeight()
                            .clickable {
                                selectedItem = items[i].route
                                items[i].onClick(navController)
                            }
                    ) {
                        AnimatedVisibility(visible = selectedItem == items[i].route) {
                            Box(
                                modifier = Modifier
                                    .size(width = 26.dp, height = 2.dp)
                                    .background(
                                        color = Blue,
                                        shape = CircleShape
                                    )
                            )
                        }
                        Icon(
                            painterResource(id = items[i].icon),
                            contentDescription = items[i].title,
                            modifier = Modifier.
                            padding(top = 13.dp),
                            tint = if (selectedItem == items[i].route) Blue else MaterialTheme.colorScheme.surfaceVariant
                        )

                        Text(
                            text = items[i].title,
                            modifier = Modifier
                                .padding(top = 11.dp),
                            style = MaterialTheme.typography.labelSmall,
                            color = if (selectedItem == items[i].route) Blue else Gray
                        )
                    }
                }
            }
        }

        SearchButton(navBarItems = items[2] , navController = navController)

    }
}

@Composable
fun BoxScope.SearchButton(navBarItems: NavBarItem , navController: NavController) {
    Column(
        modifier = Modifier
            .align(Alignment.TopCenter)
            .padding(bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.background,
                    shape = CircleShape
                )
                .size(58.dp)
                .clickable {
                    navBarItems.onClick(navController)
                },
        ) {
            Box(modifier = Modifier
                .background(
                    color = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        if (LocalConfiguration.current.isNightModeActive) BlueishGrey else DarkWhite
                    } else {
                        DarkWhite
                    },
                    shape = CircleShape
                )
                .size(52.dp)
                .align(Alignment.Center)
            ) {
                Icon(
                    painterResource(id = navBarItems.icon) ,
                    contentDescription = navBarItems.title,
                    modifier = Modifier
                        .align(Alignment.Center),
                    tint = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        if (LocalConfiguration.current.isNightModeActive) DarkGray else Blue
                    } else {
                        MaterialTheme.colorScheme.primary
                    }
                )
            }
        }

        Text(
            text = navBarItems.title,
            modifier = Modifier
                .padding(top = 7.dp),
            style = MaterialTheme.typography.labelSmall,
            color = Gray
        )
    }
}

data class NavBarItem(
    val icon: Int,
    val title: String,
    val route: String,
    val onClick: (NavController) -> Unit
)

@Preview(showBackground = true)
@Composable
fun CustomBottomNavPreview() {
    ComposeCoursesAppTheme {
        CustomBottomNav(
            items = listOf(
                NavBarItem(
                    icon = R.drawable.home,
                    title = "Home",
                    route = "home",
                    onClick = {}
                ),
                NavBarItem(
                    icon = R.drawable.ic_courses,
                    title = "Courses",
                    route = "courses",
                    onClick = {}
                ),
                NavBarItem(
                    icon = R.drawable.search,
                    title = "Search",
                    route = "search",
                    onClick = {}
                ),
                NavBarItem(
                    icon = R.drawable.ic_messages,
                    title = "Messages",
                    route = "messages",
                    onClick = {}
                ),
                NavBarItem(
                    icon = R.drawable.ic_user,
                    title = "Account",
                    route = "account",
                    onClick = {}
                ),
            ),
            navController = rememberNavController()
        )
    }
}