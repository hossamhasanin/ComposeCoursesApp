package com.example.composecoursesapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Blue,
    onPrimary = Color.White,
    secondary = LightBlack,
    onSecondary = Color.White,
    secondaryContainer = LightWhite,
    background = Black,
    onBackground = Color.White,
    surface = BlueishGrey,
    onSurface = Color.White,
    surfaceTint = Gray,
    surfaceVariant = Gray,
    onSurfaceVariant = Gray,
    inverseSurface = DarkWhite,
    inverseOnSurface = Gray44,
    tertiary = DarkGray,
    onTertiary = Color.White,
    tertiaryContainer = DarkGray,
    onTertiaryContainer = Color.White,
)

private val LightColorScheme = lightColorScheme(
    primary = Blue,
    onPrimary = Color.White,
    secondary = Color.White,
    onSecondary = Black,
    secondaryContainer = DarkWhite,
    background = Color.White,
    onBackground = Black,
    surface = DarkWhite,
    onSurface = Black,
    surfaceTint = Gray,
    surfaceVariant = DarkWhite,
    onSurfaceVariant = Blue,
    inverseSurface = Gray44,
    inverseOnSurface = DarkWhite,
    tertiary = Color.Transparent,
    onTertiary = DarkGray,
    tertiaryContainer = DarkWhite,
    onTertiaryContainer = DarkGray,

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun ComposeCoursesAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
//    val view = LocalView.current
//    if (!view.isInEditMode) {
//        SideEffect {
//            val window = (view.context as Activity).window
////            window.statusBarColor = Blue.toArgb()
////            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
//            window.statusBarColor = Color.White.toArgb()
//            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
//        }
//    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}