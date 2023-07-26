package com.example.composecoursesapp.ui.screens.messages

import android.app.Activity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.composecoursesapp.ui.isDarkTheme
import com.example.composecoursesapp.ui.screens.messages.components.MessageItem
import com.example.composecoursesapp.ui.screens.messages.components.MessagesList
import com.example.composecoursesapp.ui.screens.messages.components.NotificationItem
import com.example.composecoursesapp.ui.screens.messages.components.NotificationType
import com.example.composecoursesapp.ui.screens.messages.components.NotificationsList
import com.example.composecoursesapp.ui.screens.messages.components.TabData
import com.example.composecoursesapp.ui.screens.messages.components.TabsRow
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MessagesScreen(
    padding: PaddingValues = PaddingValues(0.dp),
) {
    val isDarkTheme = isDarkTheme()
    val backgroundColor = if (isDarkTheme) MaterialTheme.colorScheme.background else Color(0xFFF0F0F2)

    val view = LocalView.current
    SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = backgroundColor.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !isDarkTheme

    }

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = "Notifications",
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 24.sp
            ),
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(start = 20.dp, top = 17.dp , end = 20.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))

        TabsRow(
            tabs = listOf(
                TabData(
                    title = "message"
                ),
                TabData(
                    title = "notification",
                    showNotificationDot = true
                )
            ),
            onTabSelected = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(it)
                }
            },
            currentSelectedTab = pagerState.currentPage
        )
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalPager(
            pageCount = 2,
            state = pagerState,
            modifier = Modifier
                .weight(1f)
        ) {
            if (it == 0) {
                MessagesList(
                    modifier = Modifier
                        .padding(horizontal = 20.dp),
                    messages = listOf(
                        MessageItem(
                            userName = "John Doe",
                            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                            time = "10:00 AM",
                            isOnLine = true,
                        ),
                        MessageItem(
                            userName = "John Doe",
                            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                            time = "10:00 AM",
                            isOnLine = true,
                        ),
                        MessageItem(
                            userName = "John Doe",
                            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                            time = "10:00 AM",
                            isOnLine = true,
                        ),
                        MessageItem(
                            userName = "John Doe",
                            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                            time = "10:00 AM",
                            isOnLine = true,
                        ),
                    )
                )
            } else {
                NotificationsList(
                    modifier = Modifier
                        .padding(horizontal = 20.dp),
                    notifications = listOf(
                        NotificationItem(
                            notificationType = NotificationType.Transaction,
                            title = "Successful purchase!",
                            time = "Just now"
                        ),
                        NotificationItem(
                            notificationType = NotificationType.Text,
                            title = "Congratulations on completing the wonderful course!",
                            time = "Just now"
                        ),
                        NotificationItem(
                            notificationType = NotificationType.Text,
                            title = "Congratulations on completing the wonderful course!",
                            time = "Just now"
                        ),
                        NotificationItem(
                            notificationType = NotificationType.Text,
                            title = "Congratulations on completing the wonderful course!",
                            time = "Just now"
                        ),
                    )
                )
            }
        }
    }
}