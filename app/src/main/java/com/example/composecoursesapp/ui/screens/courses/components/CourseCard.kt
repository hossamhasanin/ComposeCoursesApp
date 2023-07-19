package com.example.composecoursesapp.ui.screens.courses.components

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.coloredShadow
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme
import com.example.composecoursesapp.ui.theme.Gray

@Composable
fun CourseCard(
    modifier: Modifier = Modifier,
    title: String,
    ownerName: String,
    imageUrl: String,
    price: String,
    hours: String,
    currency: String,
) {
    val shadowModifier =  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        if (LocalConfiguration.current.isNightModeActive)
            modifier
        else modifier.coloredShadow(
            color = Color(0x4DB8B8D2),
            borderRadius = 12.dp,
            blurRadius = 8.dp,
            offsetY = 4.dp
        )
    } else {
        modifier
    }
    Card(
        modifier = shadowModifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary,
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .padding(14.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.orange_woman_illustration),
                contentDescription = null,
                modifier = Modifier
                    .size(68.dp)
            )
            Spacer(modifier = Modifier.width(35.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 14.sp
                    ),
                    color = MaterialTheme.colorScheme.onSecondary,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(2.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier
                            .size(10.dp),
                        tint = Gray
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = ownerName,
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontSize = 12.sp
                        ),
                        color = Gray
                    )
                }
                Spacer(modifier = Modifier.height(2.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "$price $currency",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontSize = 16.sp
                        ),
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.width(14.dp))
                    Text(
                        text = "$hours hours",
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontSize = 10.sp
                        ),
                        color = Color(0xFFFF6905)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CourseCardPreview() {
    ComposeCoursesAppTheme(dynamicColor = false) {
        CourseCard(
            title = "Learn to Draw",
            ownerName = "John Doe",
            imageUrl = "",
            price = "150",
            hours = "10",
            currency = "LE"
        )
    }
}