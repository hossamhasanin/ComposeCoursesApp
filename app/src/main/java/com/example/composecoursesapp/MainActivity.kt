package com.example.composecoursesapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecoursesapp.ui.screens.main.MainScreen
import com.example.composecoursesapp.ui.screens.main.components.DraggablePriceBar
import com.example.composecoursesapp.ui.theme.ComposeCoursesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCoursesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Box(modifier = Modifier
                            .align(Alignment.Center)){
                            DraggablePriceBar(
                                padding = PaddingValues(start = 20.dp , end = 20.dp),
                                onPricesChanged = { low, high ->
                                    Log.d("DraggablePriceBarRes", "low: $low")
                                    Log.d("DraggablePriceBarRes", "high: $high")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
