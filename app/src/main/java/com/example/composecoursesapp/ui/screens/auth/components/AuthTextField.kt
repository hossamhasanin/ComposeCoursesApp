package com.example.composecoursesapp.ui.screens.auth.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.isDarkTheme
import com.example.composecoursesapp.ui.theme.Black
import com.example.composecoursesapp.ui.theme.BlueishGrey
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme
import com.example.composecoursesapp.ui.theme.DarkGray
import com.example.composecoursesapp.ui.theme.Gray

@Composable
fun AuthTextField(
    modifier: Modifier = Modifier,
    label: String,
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false,
    labelColor: Color = DarkGray,
) {

    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleSmall.copy(
                fontSize = 14.sp
            ),
            color = labelColor
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 14.sp
                    ),
                    color = DarkGray
                )
            },
            visualTransformation = if (isPassword && !isPasswordVisible) {
                VisualTransformation {
                    PasswordVisualTransformation('*').filter(it)
                }
            } else {
                VisualTransformation{ VisualTransformation.None.filter(it) }
            },
            trailingIcon = {
               if (isPassword){
                    Icon(
                        imageVector = ImageVector.vectorResource(id = if (isPasswordVisible) R.drawable.ic_opened_eye else R.drawable.ic_closed_eye),
                        contentDescription = null,
                        tint = if (isDarkTheme()) Color.White else Black,
                        modifier = Modifier
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                isPasswordVisible = !isPasswordVisible
                            }
                    )
               }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = if (isDarkTheme()) Color.Transparent else Gray,
                unfocusedBorderColor = if (isDarkTheme()) Color.Transparent else Gray,
                focusedContainerColor = if (isDarkTheme()) BlueishGrey else Color.White,
                unfocusedContainerColor = if (isDarkTheme()) BlueishGrey else Color.White,
                focusedTextColor = if (isDarkTheme()) Color.White else Black,
                unfocusedTextColor = if (isDarkTheme()) Color.White else Black,
            ),
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.titleSmall.copy(
                fontSize = 14.sp
            ),
            shape = MaterialTheme.shapes.medium,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AuthTextFieldPreview() {
    ComposeCoursesAppTheme(dynamicColor = false) {
        Column {
            AuthTextField(
                label = "Email",
                hint = "Enter your email",
                value = "",
                onValueChange = {},
            )
            Spacer(modifier = Modifier.height(16.dp))
            AuthTextField(
                label = "Password",
                hint = "Enter your password",
                value = "",
                onValueChange = {},
                isPassword = true
            )
        }
    }
}