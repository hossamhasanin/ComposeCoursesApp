package com.example.composecoursesapp.ui.screens.courseDetails.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.theme.Blue
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme
import com.example.composecoursesapp.ui.theme.Gray

@Composable
fun CourseContentCard(
    modifier: Modifier = Modifier,
    isPlayable: Boolean,
    onPlayClick: () -> Unit,
    isWatched: Boolean,
    orderId: String,
    title: String,
    time: String,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = orderId,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 24.sp
                ),
                color = Gray,
            )
            Spacer(modifier = Modifier.width(26.dp))
            Column{
                Text(text = title, style = MaterialTheme.typography.titleSmall.copy(
                    fontSize = 14.sp
                ), color = MaterialTheme.colorScheme.onSecondary,
                    maxLines = 2 , overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth(0.7f))
                Spacer(modifier = Modifier.height(6.dp))
                Row {
                    Text(
                        text = time, style = MaterialTheme.typography.titleSmall.copy(
                            fontSize = 12.sp
                        ), color = if (isWatched) Color(0xFFFF6905) else Gray
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    if (isWatched)
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_done),
                            contentDescription = null
                        )
                }
            }
        }

        Box(
            modifier = Modifier
                .size(44.dp)
                .background(
                    if (isPlayable) Blue else Blue.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(50)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = if(isPlayable) R.drawable.ic_play else R.drawable.ic_lock),
                contentDescription = null,
                tint = if (isPlayable) Color.White else Color.White.copy(alpha = 0.4f),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseContentCardPreview() {
    ComposeCoursesAppTheme(dynamicColor = false) {
        CourseContentCard(
            isPlayable = true,
            onPlayClick = {},
            isWatched = false,
            orderId = "01",
            title = "Introduction",
            time = "3:30 mins"
        )
    }
}