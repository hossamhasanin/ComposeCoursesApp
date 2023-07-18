package com.example.composecoursesapp.ui.screens.courses.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterSearchTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = "Find Course",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.surfaceTint
            )
        },
        trailingIcon = {
           Icon(
               imageVector = ImageVector.vectorResource(id = R.drawable.ic_filter),
               contentDescription = "filter",
               tint = MaterialTheme.colorScheme.surfaceTint
           )
        },
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.search),
                contentDescription = "filter",
                tint = MaterialTheme.colorScheme.surfaceTint
            )
        },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,

        ),
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun FilterSearchTextFieldPreview() {
    ComposeCoursesAppTheme(dynamicColor = false) {
        FilterSearchTextField(
            value = "",
            onValueChange = {}
        )
    }
}