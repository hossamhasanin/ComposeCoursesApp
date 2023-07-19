package com.example.composecoursesapp.ui.screens.courses.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchResultsSection(
    modifier: Modifier = Modifier,
    topSearches: List<String>,
) {
    Column(
        modifier = modifier
    ) {
        LazyRow(
            modifier = Modifier
                .padding(horizontal = 20.dp)
        ){
            items(topSearches){
                SuggestionChip(onClick = {}, label = {
                    Text(text = it, style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 12.sp
                    ))
                }, colors = SuggestionChipDefaults.suggestionChipColors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    labelColor = MaterialTheme.colorScheme.onTertiaryContainer,
                ))
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
        Spacer(modifier = Modifier.height(28.dp))
        Text(
            text = "Results",
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 18.sp
            ),
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        LazyColumn (
            modifier = Modifier.padding(horizontal = 20.dp)
                ){
            items(5){
                CourseCard(
                    title = "Learn to Draw",
                    ownerName = "John Doe",
                    imageUrl = "",
                    price = "150",
                    hours = "10",
                    currency = "LE",
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}