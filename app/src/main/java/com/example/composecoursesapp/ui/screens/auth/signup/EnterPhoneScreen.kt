package com.example.composecoursesapp.ui.screens.auth.signup

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
fun EnterPhoneScreen(
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

    var phoneNumber by rememberSaveable { mutableStateOf("") }

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
                text = "Continue with Phone",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 18.sp
                ),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(36.dp))
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.phone_illustration),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
                )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Enter Your  Phone Number",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 14.sp
                    ),
                    color = if (isDarkTheme) Gray else DarkGray,
                    modifier = Modifier
                        .padding(top = 25.dp)
                )
                Spacer(modifier = Modifier.height(23.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .background(
                            if (isDarkTheme) BlueishGrey else Gray,
                            shape = MaterialTheme.shapes.medium
                        )
                        .padding(0.5.dp)
                        .background(
                            if (isDarkTheme) BlueishGrey else Color.White,
                            shape = MaterialTheme.shapes.medium
                        )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        Text(
                            text = phoneNumber,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontSize = 18.sp
                            ),
                            color = MaterialTheme.colorScheme.onSecondary,
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 20.dp, end = 27.dp),
                            maxLines = 1,
                            onTextLayout = {
                                // add space after each 3 characters to format phone number like 123 456 7890
                                val space = ' '
                                val builder = StringBuilder(phoneNumber)
                                if (phoneNumber.length >= 4 && phoneNumber[3] != space) {
                                    builder.insert(3, space)
                                }
                                if (phoneNumber.length >= 8 && phoneNumber[7] != space) {
                                    builder.insert(7, space)
                                }
                                phoneNumber = builder.toString()
                            }
                        )

                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Blue,
                            ),
                            modifier = Modifier
                                .height(50.dp),
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Text(
                                text = "Continue",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontSize = 16.sp
                                ),
                                color = Color.White
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(35.dp))

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
                                  if (it == 11){
                                      if (phoneNumber.isNotEmpty()){
                                          phoneNumber = deleteNum(phoneNumber)
                                      }
                                  } else {
                                      if (phoneNumber.length < 13){
                                          phoneNumber += num
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
    }
}

fun deleteNum(phoneNumber: String): String {
    return if (phoneNumber[phoneNumber.length - 1] == ' ') {
        phoneNumber.dropLast(2)
    } else {
        phoneNumber.dropLast(1)
    }
}