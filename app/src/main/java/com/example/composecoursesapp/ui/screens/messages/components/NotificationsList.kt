package com.example.composecoursesapp.ui.screens.messages.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NotificationsList(
    modifier: Modifier = Modifier,
    notifications: List<NotificationItem>,
) {

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        items(notifications.size) {
            NotificationCard(
                notificationType = notifications[it].notificationType,
                title = notifications[it].title,
                time = notifications[it].time,
                onClick = { }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

data class NotificationItem(
    val notificationType: NotificationType,
    val title: String,
    val time: String
)