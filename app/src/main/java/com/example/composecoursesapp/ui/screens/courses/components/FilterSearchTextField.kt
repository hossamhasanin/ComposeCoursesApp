package com.example.composecoursesapp.ui.screens.courses.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterSearchTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    onFilterClick: () -> Unit,
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
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (value.isNotEmpty()){
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete_two),
                        contentDescription = "delete",
                        tint = MaterialTheme.colorScheme.surfaceTint,
                        modifier = Modifier
                            .clickable {
                                onValueChange("")
                            }
                    )
                    Spacer(modifier = Modifier.width(21.dp))
                }
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_filter),
                    contentDescription = "filter",
                    tint = MaterialTheme.colorScheme.surfaceTint,
                    modifier = Modifier
                        .clickable {
                            onFilterClick()
                        }
                )
                if (value.isNotEmpty()){
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
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
    )
}

@Preview(showBackground = true)
@Composable
fun FilterSearchTextFieldPreview() {
    ComposeCoursesAppTheme(dynamicColor = false) {
        FilterSearchTextField(
            value = "",
            onValueChange = {},
            onFilterClick = {}
        )
    }
}