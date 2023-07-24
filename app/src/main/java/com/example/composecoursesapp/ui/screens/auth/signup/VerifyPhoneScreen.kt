package com.example.composecoursesapp.ui.screens.auth.signup


import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.isDarkTheme
import com.example.composecoursesapp.ui.theme.Blue
import com.example.composecoursesapp.ui.theme.BlueishGrey
import com.example.composecoursesapp.ui.theme.DarkGray
import com.example.composecoursesapp.ui.theme.Gray

@Composable
fun VerifyPhoneScreen(
    padding: PaddingValues = PaddingValues(),
) {
    val isDarkTheme = isDarkTheme()
    val backgroundColor = MaterialTheme.colorScheme.secondary

    val view = LocalView.current
    SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = backgroundColor.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !isDarkTheme

    }

    var confirmCode by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }

            Text(
                text = "Verify Phone",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 18.sp
                ),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(68.dp))
        Text(
            text = "Code is sent to 283 835 2999 ",
            style = MaterialTheme.typography.titleSmall.copy(
                fontSize = 18.sp
            ),
            color = if (isDarkTheme) Gray else DarkGray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(17.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            for (i in 0..3){
                Box(
                    modifier = Modifier
                        .width(50.dp)
                        .height(58.dp)
                        .background(
                            if (isDarkTheme) BlueishGrey else Gray,
                            shape = MaterialTheme.shapes.medium
                        )
                        .padding(0.5.dp)
                        .background(
                            if (isDarkTheme) BlueishGrey else Color.White,
                            shape = MaterialTheme.shapes.medium
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = confirmCode.getOrNull(i)?.toString() ?: "",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontSize = 22.sp
                        ),
                        color = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                if (i != 3){
                    Spacer(modifier = Modifier.width(19.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(86.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 45.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = "Verify and Create Account",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 15.sp
                ),
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(68.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            userScrollEnabled = false,
            contentPadding = PaddingValues(0.dp)
        ){
            items(12) {
                val num = if (it == 10) "0" else (it+1).toString()
                Box(
                    modifier = Modifier
                        .height(80.dp)
                        .clickable(
                            enabled = it != 9
                        ) {
                            if (it == 11) {
                                if (confirmCode.isNotEmpty()) {
                                    confirmCode = confirmCode.dropLast(1)
                                }
                            } else {
                                if (confirmCode.length < 4) {
                                    confirmCode += num
                                }
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    when (it) {
                        9 -> {
                            Box {}
                        }
                        11 -> {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete_char),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSecondary
                            )
                        }
                        else -> {
                            Text(
                                text = num,
                                style = MaterialTheme.typography.titleLarge.copy(
                                    fontSize = 24.sp
                                ),
                                color = MaterialTheme.colorScheme.onSecondary
                            )
                        }
                    }
                }
            }
        }
    }
}