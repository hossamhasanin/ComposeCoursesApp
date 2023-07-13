package com.example.composecoursesapp.ui.screens.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme

@Composable
fun SuggestionsCard(
    modifier: Modifier = Modifier,
    title: String? = null,
    actionButtonFn: (() -> Unit)? = null,
    actionButtonTitle: String? = null,
    image: Painter
) {
    Box(
        modifier = modifier
            .width(253.dp)
            .height(154.dp)
            .background(
                color = Color(0xFFCEECFE),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            if (title != null)
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 16.sp
                    ),
                    color = Color.Black
                )
            if (actionButtonFn != null && actionButtonTitle != null)
                ElevatedButton(
                    onClick = actionButtonFn,
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = Color(0xFFFF6905)
                    ),
                    modifier = Modifier
                        .size(85.dp , 31.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = actionButtonTitle,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontSize = 10.sp
                        ),
                        color = Color.White
                    )
                }
        }
    }
}

@Preview
@Composable
fun SuggestionsCardPreview() {
    ComposeCoursesAppTheme {
        SuggestionsCard(
            modifier = Modifier
                .padding(start = 8.dp),
            title = "What do youwant to learn today ?",
            actionButtonFn = {},
            actionButtonTitle = "Get Started",
            image = painterResource(id = R.drawable.orange_woman_illustration)
        )
    }
}