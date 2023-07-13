package com.example.composecoursesapp.ui.screens.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.coloredShadow
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme

@Composable
fun MeetUpCard(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .coloredShadow(
                color = Color(0x80B8B8D2),
                offsetY = 8.dp,
                borderRadius = 16.dp,
                blurRadius = 12.dp
            )
            .padding(1.dp)
            .background(
                color = Color(0xFFEFE0FF),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 18.dp, start = 21.dp , end = 8.dp)
            ) {
                Text(
                    text = "Meetup",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 24.sp
                    ),
                    color = Color(0xFF440687)
                )

                Text(
                    text = "Off-line exchange of learning experiences",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 12.sp
                    ),
                    color = Color(0xFF440687)
                )
            }

            Image(
                painter = painterResource(id = R.drawable.people_illustration),
                contentDescription = null,
                modifier = Modifier
                    .size(95.dp, 95.dp)
                    .padding(top = 8.dp, end = 13.dp, bottom = 15.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MeetUpCardPreview() {
    ComposeCoursesAppTheme {
        MeetUpCard(
            modifier = Modifier
                .padding(16.dp)
        )
    }
}