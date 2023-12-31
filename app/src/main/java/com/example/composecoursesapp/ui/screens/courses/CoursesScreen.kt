@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composecoursesapp.ui.screens.courses

import android.app.Activity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.isDarkTheme
import com.example.composecoursesapp.ui.screens.courses.components.FilterBottomSheet
import com.example.composecoursesapp.ui.screens.courses.components.FilterItem
import com.example.composecoursesapp.ui.screens.courses.components.FilterSearchTextField
import com.example.composecoursesapp.ui.screens.courses.components.MainContentSection
import com.example.composecoursesapp.ui.screens.courses.components.SearchResultsSection
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CoursesScreen(
    padding: PaddingValues = PaddingValues(),
    navController: NavController = rememberNavController(),
) {

    
    var searchFieldValue by remember {
        mutableStateOf("")
    }
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded  = true)
    val scope = rememberCoroutineScope()
    val backgroundColor = MaterialTheme.colorScheme.background
    val isDarkTheme = isDarkTheme()

    //TODO: Remove this when the business logic is implemented
    var categoryFilterItems by remember {
        mutableStateOf(listOf(
            FilterItem("All", 0, true),
            FilterItem("Design", 1, false),
            FilterItem("Development", 2, false),
            FilterItem("Marketing", 3, false),
        ))
    }

    var durationFilterItems by remember {
        mutableStateOf(listOf(
            FilterItem("All", 0, true),
            FilterItem("0-2 hours", 1, false),
            FilterItem("2-5 hours", 2, false),
            FilterItem("5-10 hours", 3, false),
            FilterItem("10+ hours", 4, false),
        ))
    }

    val view = LocalView.current
    SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = backgroundColor.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !isDarkTheme

    }

    val rememberedPadding by remember {
        mutableStateOf(padding)
    }
    Box(
        modifier = Modifier
            .padding(bottom = rememberedPadding.calculateBottomPadding() - 8.dp)
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.background
            )
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Courses",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 24.sp
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )

                Image(
                    painter = painterResource(R.drawable.avatar),
                    contentDescription = "avatar"
                )
            }

            FilterSearchTextField(
                value = searchFieldValue,
                onValueChange = {
                    searchFieldValue = it
                },
                onFilterClick = {
                                openBottomSheet = true
//                    scope.launch {
//                        bottomSheetState.show()
//                    }
                },
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            )

            if (searchFieldValue.isNotEmpty()){
                Spacer(modifier = Modifier.height(16.dp))
                SearchResultsSection(
                    topSearches = listOf("Android", "Kotlin", "Compose")
                )
            } else {
                Spacer(modifier = Modifier.height(27.dp))
                MainContentSection(
                    navController = navController,
                )
            }
            if (openBottomSheet) {
                ModalBottomSheet(onDismissRequest = {
                    openBottomSheet = false
                }, sheetState = bottomSheetState, containerColor = MaterialTheme.colorScheme.secondary) {
                    FilterBottomSheet(
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp, bottom = 33.dp),
                        onCloseClick = {
                            scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                                if (!bottomSheetState.isVisible) {
                                    openBottomSheet = false
                                }
                            }
                        },
                        onApplyClick = {},
                        onClearClick = {
                            scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                                if (!bottomSheetState.isVisible) {
                                    openBottomSheet = false
                                }
                            }
                        },
                        onCategoryFilterItemClick = {selectedItem ->
                            categoryFilterItems = categoryFilterItems.map {
                                it.copy(isSelected = it.id == selectedItem.id)
                            }
                        },
                        onDurationFilterItemClick = { selectedItem ->
                            durationFilterItems = durationFilterItems.map {
                                it.copy(isSelected = it.id == selectedItem.id)
                            }
                        },
                        categoryFilterItems = categoryFilterItems,
                        durationFilterItems = durationFilterItems
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CoursesScreenPreview() {
    ComposeCoursesAppTheme(dynamicColor = false) {
        CoursesScreen()
    }
}