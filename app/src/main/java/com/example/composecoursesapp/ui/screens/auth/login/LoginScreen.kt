package com.example.composecoursesapp.ui.screens.auth.login


import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.composecoursesapp.ui.isDarkTheme
import com.example.composecoursesapp.ui.screens.auth.components.AuthTextField
import com.example.composecoursesapp.ui.theme.Blue
import com.example.composecoursesapp.ui.theme.DarkGray
import com.example.composecoursesapp.ui.theme.Gray

@Composable
fun LoginScreen(
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

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Text(
            text = "Log In",
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 32.sp
            ),
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(top = 42.dp, start = 24.dp, end = 24.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .weight(1f)
                .background(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
                )
                .padding(horizontal = 24.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                AuthTextField(
                    modifier = Modifier
                        .padding(top = 32.dp),
                    label = "Email",
                    hint = "Enter your email",
                    value = email,
                    onValueChange = {
                        email = it
                    },
                )
                Spacer(modifier = Modifier.height(24.dp))
                AuthTextField(
                    label = "Password",
                    hint = "Enter your password",
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    isPassword = true
                )
                Spacer(modifier = Modifier.height(13.dp))
                Text(
                    text = "Forgot password?",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 14.sp,
                        color = Gray
                    ),
                    modifier = Modifier
                        .align(Alignment.End)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) { /*TODO*/ }
                )
                Spacer(modifier = Modifier.height(13.dp))
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Blue,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(
                        text = "Log In",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontSize = 16.sp
                        ),
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(26.dp))
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = if (isDarkTheme) Gray else DarkGray,
                                fontSize = 12.sp,
                                fontFamily = MaterialTheme.typography.titleSmall.fontFamily,
                                fontWeight = MaterialTheme.typography.titleSmall.fontWeight
                            )
                        ){
                            append("Don’t have an account? ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Blue,
                                fontSize = 12.sp,
                                fontFamily = MaterialTheme.typography.titleSmall.fontFamily,
                                fontWeight = MaterialTheme.typography.titleSmall.fontWeight
                            )
                        ){
                            append("Sign up")
                        }
                    },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() },
                        ) { /*TODO*/ }
                )
            }
        }
    }
}