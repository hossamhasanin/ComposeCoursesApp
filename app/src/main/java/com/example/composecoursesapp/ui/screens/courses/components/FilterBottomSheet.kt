package com.example.composecoursesapp.ui.screens.courses.components

import android.os.Build
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ChipBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecoursesapp.ui.theme.Black
import com.example.composecoursesapp.ui.theme.Blue
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme
import com.example.composecoursesapp.ui.theme.DarkGray

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilterBottomSheet(
    modifier: Modifier = Modifier,
    onCloseClick: () -> Unit,
    categoryFilterItems: List<FilterItem>,
    onCategoryFilterItemClick: (FilterItem) -> Unit,
    durationFilterItems: List<FilterItem>,
    onDurationFilterItemClick: (FilterItem) -> Unit,
    onApplyClick: () -> Unit,
    onClearClick: () -> Unit,
) {

    val circleStrokeColor = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        if (LocalConfiguration.current.isNightModeActive) Color.White else Blue
    } else Blue

    val circleColor = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        if (LocalConfiguration.current.isNightModeActive) Blue else Color.White
    } else Color.White

    val clearButtonSecondary = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        if (LocalConfiguration.current.isNightModeActive) DarkGray else Color.White
    } else Color.White

    val clearTextColor = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        if (LocalConfiguration.current.isNightModeActive) Color.White else Blue
    } else Blue


    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            IconButton(onClick = onCloseClick) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            }
            Text(
                text = "Search Filter", style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 18.sp
                ), color = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(18.dp))
        Text(
            text = "Categories", style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 16.sp
            ), color = MaterialTheme.colorScheme.onSecondary,
        )
        Spacer(modifier = Modifier.height(12.dp))
        FlowRow {
            for (categoryFilterItem in categoryFilterItems) {
                SuggestionChip(onClick = { onCategoryFilterItemClick(categoryFilterItem) }, label = {
                    Text(text = categoryFilterItem.name, style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 12.sp
                    ), color = if (categoryFilterItem.isSelected) MaterialTheme.colorScheme.onPrimary
                    else MaterialTheme.colorScheme.onTertiaryContainer)
                }, colors = SuggestionChipDefaults.suggestionChipColors(
                    containerColor = if (categoryFilterItem.isSelected) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.tertiaryContainer,
                ), border = null)
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Price", style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 16.sp
            ), color = MaterialTheme.colorScheme.onSecondary,
        )
        Spacer(modifier = Modifier.height(12.dp))
        DraggablePriceBar(
            onPricesChanged = { lowPrice, highPrice ->

            },
            circleColor = circleColor,
            circleStrokeColor = circleStrokeColor,
            barColor = Blue,
            textColor = MaterialTheme.colorScheme.onSecondary,
            endStopPaddingValue = 20.dp
        )
        Spacer(modifier = Modifier.height(31.dp))
        Text(
            text = "Duration", style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 16.sp
            ), color = MaterialTheme.colorScheme.onSecondary,
        )
        Spacer(modifier = Modifier.height(15.dp))
        FlowRow {
            for (durationFilterItem in durationFilterItems) {
                SuggestionChip(onClick = { onDurationFilterItemClick(durationFilterItem) }, label = {
                    Text(text = durationFilterItem.name, style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 12.sp
                    ), color = if (durationFilterItem.isSelected) MaterialTheme.colorScheme.onPrimary
                    else MaterialTheme.colorScheme.onTertiaryContainer)
                }, colors = SuggestionChipDefaults.suggestionChipColors(
                    containerColor = if (durationFilterItem.isSelected) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.tertiaryContainer,
                ), border = null)
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            OutlinedButton(onClick = onClearClick, colors = ButtonDefaults.outlinedButtonColors(
                containerColor = clearButtonSecondary,
            ), border = ButtonDefaults.outlinedButtonBorder.copy(
                brush = SolidColor(Blue),
                width = 0.5.dp
            ), shape = MaterialTheme.shapes.medium) {
                Text(text = "Clear", style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 16.sp
                ), color = clearTextColor)
            }
            Spacer(modifier = Modifier.width(9.dp))
            Button(onClick = onApplyClick, colors = ButtonDefaults.buttonColors(
                containerColor = Blue
            ), modifier = Modifier.weight(1f), shape = MaterialTheme.shapes.medium) {
                Text(text = "Apply Filter", style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 16.sp
                ), color = Color.White)
            }
        }
    }
}

data class FilterItem(
    val name: String,
    val id: Int,
    val isSelected: Boolean
)

@Preview(showBackground = true)
@Composable
fun FilterBottomSheetPreview() {
    ComposeCoursesAppTheme(
        dynamicColor = false
    ) {
        FilterBottomSheet(
            onCloseClick = {},
            onApplyClick = {},
            onClearClick = {},
            onCategoryFilterItemClick = {},
            onDurationFilterItemClick = {},
            categoryFilterItems = listOf(
                FilterItem("All", 0, true),
                FilterItem("Design", 1, false),
                FilterItem("Development", 2, false),
                FilterItem("Marketing", 3, false),
            ),
            durationFilterItems = listOf(
                FilterItem("All", 0, true),
                FilterItem("0-2 hours", 1, false),
                FilterItem("2-5 hours", 2, false),
                FilterItem("5-10 hours", 3, false),
                FilterItem("10-20 hours", 4, false),
                FilterItem("20+ hours", 5, false),
            )
        )
    }
}