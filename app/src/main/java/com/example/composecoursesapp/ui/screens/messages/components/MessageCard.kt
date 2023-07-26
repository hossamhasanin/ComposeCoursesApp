package com.example.composecoursesapp.ui.screens.messages.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.ui.coloredShadow
import com.example.composecoursesapp.ui.isDarkTheme
import com.example.composecoursesapp.ui.theme.DarkGray
import com.example.composecoursesapp.ui.theme.Gray

@Composable
fun MessageCard(
    modifier: Modifier = Modifier,
    userImage: String?,
    userName: String,
    time: String,
    isOnLine: Boolean,
    message: String,
    onClick: () -> Unit,
) {

    val shadowModifier =  if (isDarkTheme()) modifier else modifier.coloredShadow(
        color = Color(0x4DB8B8D2),
        borderRadius = 12.dp,
        blurRadius = 12.dp,
        offsetY = 8.dp
    )


    Card(
        modifier = shadowModifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
            .clickable {
                onClick()
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        ),
        shape = MaterialTheme.shapes.medium
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Row {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(MaterialTheme.shapes.medium)
                            .background(
                                Color(0xFFD8FFEF),
                                MaterialTheme.shapes.medium
                            )
                    ){
                        //TODO: implement viewing image from network
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = userName,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontSize = 12.sp
                            ),
                            color = MaterialTheme.colorScheme.onSecondary,
                            maxLines = 1,
                            modifier = Modifier
                                .padding(top = 6.dp)
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = if (isOnLine) "Online" else "Offline",
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontSize = 12.sp
                            ),
                            color = if (isDarkTheme()) Gray else DarkGray
                        )
                    }
                }

                Text(
                    text = time,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 12.sp
                    ),
                    color = if (isDarkTheme()) Gray else DarkGray
                )
            }
            Spacer(modifier = Modifier.height(13.dp))
            Text(
                text = message,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontSize = 12.sp
                ),
                color = MaterialTheme.colorScheme.onSecondary,
                maxLines = 2,
                modifier = Modifier
                    .padding(end = 11.dp)
            )
        }
    }
}