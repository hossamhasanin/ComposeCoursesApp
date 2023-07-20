package com.example.composecoursesapp.ui.screens.courseDetails.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.theme.Blue

@Composable
fun BottomButtonsSection(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFEBF0)
            ),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .height(50.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_star_otline),
                contentDescription = null,
                tint = Color(0xFFFF6905),
            )
        }
        Spacer(modifier = Modifier.width(14.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue
            ),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .weight(1f)
                .height(50.dp)
        ) {
            Text(
                text = "Buy Now", style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 16.sp
                ), color = Color.White
            )
        }
    }
}