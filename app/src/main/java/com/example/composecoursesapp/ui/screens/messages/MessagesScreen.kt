package com.example.composecoursesapp.ui.screens.messages

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.composecoursesapp.ui.isDarkTheme
import com.example.composecoursesapp.ui.screens.messages.components.TabData
import com.example.composecoursesapp.ui.screens.messages.components.TabsRow

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
            onTabSelected = {}
        )
    }
}