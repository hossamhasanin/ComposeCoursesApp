package com.example.composecoursesapp.ui.screens.account

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.isDarkTheme
import com.example.composecoursesapp.ui.screens.account.components.AccountItem
import com.example.composecoursesapp.ui.theme.Blue
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme

@Composable
fun AccountScreen(
    padding: PaddingValues = PaddingValues(),
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
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = "Account",
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 24.sp
            ),
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(start = 20.dp, top = 17.dp , end = 20.dp)
        )
        Spacer(modifier = Modifier.height(23.dp))
        Box(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ){
            Box(
                modifier = Modifier
                    .size(88.dp)
                    .clip(RoundedCornerShape(50)),
                contentAlignment = Alignment.Center
            ) {
               Image(
                   imageVector = ImageVector.vectorResource(id = R.drawable.avatar),
                   contentDescription = null,
                   contentScale = ContentScale.Crop,
                   modifier = Modifier
                       .height(88.dp)
                       .width(64.dp)
               )
            }

            Box(
                modifier = Modifier
                    .offset(x = (-5).dp)
                    .size(20.dp)
                    .clip(RoundedCornerShape(50))
                    .background(
                        color = Blue,
                        shape = RoundedCornerShape(50)
                    )
                    .align(Alignment.TopEnd),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_camera),
                    contentDescription = null,
                    modifier = Modifier.size(9.dp , 8.dp),
                    tint = Color.White
                )
            }
        }

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
        ) {
            AccountItem(
                title = "My Courses",
                onClick = { /*TODO*/ }
            )

            AccountItem(
                title = "Favourite",
                onClick = { /*TODO*/ }
            )

            AccountItem(
                title = "Edit Account",
                onClick = { /*TODO*/ }
            )

            AccountItem(
                title = "Settings and Privacy",
                onClick = { /*TODO*/ }
            )

            AccountItem(
                title = "Help",
                onClick = { /*TODO*/ }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountScreenPreview() {
    ComposeCoursesAppTheme(dynamicColor = false) {
        AccountScreen()
    }
}