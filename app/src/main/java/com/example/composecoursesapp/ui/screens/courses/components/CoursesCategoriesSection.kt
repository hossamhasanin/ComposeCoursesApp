package com.example.composecoursesapp.ui.screens.courses.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme

@Composable
fun CoursesCategoriesSection(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(86.dp)
            .fillMaxWidth()
    ){
        Box(modifier = Modifier.weight(1f)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(77.dp)
                    .align(Alignment.BottomCenter)
                    .background(
                        color = Color(0xFFCEECFE),
                        shape = RoundedCornerShape(8.dp)
                    )
            )
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.listening_lady_illustration),
                contentDescription = null
            )

            Box(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .background(
                        color = Color(0xFFF3FBFF),
                        shape = RoundedCornerShape(
                            topStart = 8.dp,
                            bottomStart = 8.dp,
                        )
                    )
                    .align(Alignment.BottomEnd),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Language",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 14.sp
                    ),
                    color = Color(0xFF3D5CFF),
                    modifier = Modifier.padding(start = 8.dp , end = 3.5.dp)
                )
            }
        }
        Spacer(modifier = Modifier.width(15.dp))
        Box(modifier = Modifier.weight(1f)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(77.dp)
                    .align(Alignment.BottomCenter)
                    .background(
                        color = Color(0xFFEFE0FF),
                        shape = RoundedCornerShape(8.dp)
                    )
            )
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.drawing_lady_illustrations),
                contentDescription = null
            )

            Box(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .background(
                        color = Color(0xFFF8F2FF),
                        shape = RoundedCornerShape(
                            topStart = 8.dp,
                            bottomStart = 8.dp,
                        )
                    )
                    .align(Alignment.BottomEnd),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Painting",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 14.sp
                    ),
                    color = Color(0xFF9065BE),
                    modifier = Modifier.padding(start = 8.dp , end = 3.5.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoursesCategoriesSectionPreview() {
    ComposeCoursesAppTheme(
        dynamicColor = false
    ) {
        CoursesCategoriesSection()
    }
}