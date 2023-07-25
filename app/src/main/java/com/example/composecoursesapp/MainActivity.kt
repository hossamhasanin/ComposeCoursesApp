package com.example.composecoursesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.composecoursesapp.ui.screens.account.AccountScreen
import com.example.composecoursesapp.ui.screens.auth.login.LoginScreen
import com.example.composecoursesapp.ui.screens.auth.signup.EnterPhoneScreen
import com.example.composecoursesapp.ui.screens.auth.signup.SignUpScreen
import com.example.composecoursesapp.ui.screens.auth.signup.VerifyPhoneScreen
import com.example.composecoursesapp.ui.screens.courseDetails.CourseDetailsScreen
import com.example.composecoursesapp.ui.screens.courses.CoursesScreen
import com.example.composecoursesapp.ui.screens.main.MainScreen
import com.example.composecoursesapp.ui.screens.main.components.CustomBottomNav
import com.example.composecoursesapp.ui.screens.main.components.NavBarItem
import com.example.composecoursesapp.ui.screens.onBoarding.OnBoardingScreen
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
                                                if (route == homeScreenDest) {
                                                    return@NavBarItem
                                                }
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
                                                if (route == coursesScreenDest) {
                                                    return@NavBarItem
                                                }
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
                    NavHost(navController = navController , startDestination = verifyPhoneScreen) {
                        composable(onBoardingScreenDest){
                            OnBoardingScreen(
                                padding = padding,
                            )
                        }
                        composable(loginScreenDest){
                            LoginScreen(
                                padding = padding,
                            )
                        }
                        composable(signUpScreenDest){
                            SignUpScreen(
                                padding = padding,
                            )
                        }
                        composable(enterPhoneScreen){
                            EnterPhoneScreen(
                                padding = padding,
                            )
                        }
                        composable(verifyPhoneScreen){
                            VerifyPhoneScreen(
                                padding = padding,
                            )
                        }
                        navigation(route = mainScreenNavDest, startDestination = homeScreenDest){
                            composable(homeScreenDest){
                                MainScreen(
                                    navController = navController,
                                    padding = padding
                                )
                            }
                            composable(coursesScreenDest){
                                CoursesScreen(
                                    padding = padding,
                                    navController = navController
                                )
                            }
                            composable(accountScreenDest){
                                AccountScreen(
                                    padding = padding,
                                )
                            }
                        }
                        composable(courseDetailScreenDest){
                            CourseDetailsScreen(
                                padding = padding
                            )
                        }
                    }
                }
            }
        }
    }
}
