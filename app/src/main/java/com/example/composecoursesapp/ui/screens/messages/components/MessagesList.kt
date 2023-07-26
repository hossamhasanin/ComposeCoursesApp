package com.example.composecoursesapp.ui.screens.messages.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MessagesList(
    modifier: Modifier = Modifier,
    messages: List<MessageItem>,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        items(messages.size) {
            MessageCard(
                userImage = messages[it].userImage,
                userName = messages[it].userName,
                time = messages[it].time,
                isOnLine = messages[it].isOnLine,
                message = messages[it].message,
                onClick = { }
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

data class MessageItem(
    val userImage: String? = null,
    val userName: String,
    val time: String,
    val isOnLine: Boolean,
    val message: String,
)