package com.example.composecoursesapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.composecoursesapp.ui.screens.courses.CoursesScreen
import com.example.composecoursesapp.ui.screens.main.MainScreen
import com.example.composecoursesapp.ui.screens.main.components.CustomBottomNav
import com.example.composecoursesapp.ui.screens.main.components.DraggablePriceBar
import com.example.composecoursesapp.ui.screens.main.components.NavBarItem
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCoursesAppTheme(
                dynamicColor = false
            ) {
                val navController = rememberNavController()
                val currentBackStack by navController.currentBackStackEntryAsState()
                Scaffold(
                    bottomBar = {
                        val route = if (currentBackStack?.destination == null) {
                            homeScreenDest
                        } else {
                            currentBackStack!!.destination.route
                        }
                        route?.let {
                            if (it.contains(mainScreenNavDest)){
                                CustomBottomNav(
                                    items = listOf(
                                        NavBarItem(
                                            icon = R.drawable.home,
                                            title = "Home",
                                            route = homeScreenDest,
                                            onClick = {
                                                navController.navigate(homeScreenDest){
                                                    popUpTo(mainScreenNavDest){
                                                        inclusive = true
                                                    }
                                                }
                                            }
                                        ),
                                        NavBarItem(
                                            icon = R.drawable.ic_courses,
                                            title = "Courses",
                                            route = coursesScreenDest,
                                            onClick = {
                                                navController.navigate(coursesScreenDest){
                                                    popUpTo(mainScreenNavDest){
                                                        inclusive = true
                                                    }
                                                }
                                            }
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
                                    navController = navController
                                )
                            }
                        }
                    },
                    containerColor = MaterialTheme.colorScheme.background
                ) { padding ->
                    NavHost(navController = navController , startDestination = mainScreenNavDest){
                        navigation(route = mainScreenNavDest, startDestination = homeScreenDest){
                            composable(homeScreenDest){
                                MainScreen(
                                    navController = navController,
                                    padding = padding
                                )
                            }
                            composable(coursesScreenDest){
                                CoursesScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}
