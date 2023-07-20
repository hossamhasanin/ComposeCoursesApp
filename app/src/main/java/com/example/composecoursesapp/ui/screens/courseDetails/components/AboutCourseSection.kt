package com.example.composecoursesapp.ui.screens.courseDetails.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.ui.theme.Gray61

@Composable
fun AboutCourseSection(
    modifier: Modifier = Modifier,
    onAboutTextExpanded: (Boolean) -> Unit
) {
    var isAboutTextExpanded by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {
        Text(text = "About this course",
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 16.sp
            ),
            color = MaterialTheme.colorScheme.onSecondary
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "This course is designed to help you learn about product design. It will help you learn about the basics of product design and how to get started with it. It will also help you learn about the different tools that are used in product design. You will also learn about the different types of product design and how to get started with it. You will also learn about the different types of product design and how to get started with it.",
            style = MaterialTheme.typography.titleSmall.copy(
                fontSize = 12.sp
            ),
            color = Gray61,
            maxLines = if (isAboutTextExpanded) Int.MAX_VALUE else 2,
            modifier = Modifier
                .padding(bottom = 20.dp)
                .animateContentSize()
                .clickable {
                    isAboutTextExpanded = !isAboutTextExpanded
                    onAboutTextExpanded(isAboutTextExpanded)
                }
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ) {
                    isAboutTextExpanded = !isAboutTextExpanded
                    onAboutTextExpanded(isAboutTextExpanded)
                }
        ) {
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}