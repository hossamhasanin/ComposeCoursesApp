package com.example.composecoursesapp.ui.screens.main.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecoursesapp.R
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme

@Composable
fun SuggestionsSection(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        SuggestionsCard(
            modifier = Modifier
                .padding(start = 8.dp),
            title = "What do youwant to learn today ?",
            actionButtonFn = {},
            actionButtonTitle = "Get Started",
            image = painterResource(id = R.drawable.orange_woman_illustration)
        )

        SuggestionsCard(
            modifier = Modifier
                .padding(start = 8.dp),
            image = painterResource(id = R.drawable.smart_kid_illustration)
        )
    }
}

@Preview
@Composable
fun SuggestionsSectionPreview() {
    ComposeCoursesAppTheme {
        SuggestionsSection(
            modifier = Modifier
                .padding(top = 16.dp, start = 12.dp)
        )
    }
}