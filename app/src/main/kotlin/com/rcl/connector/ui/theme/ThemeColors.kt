package com.rcl.connector.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

object ThemeColors {
    val LightColorScheme = lightColorScheme(
        primary = Color(0xff355f97),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffd3e3ff),
        onPrimaryContainer = Color(0xff001c3b),
        inversePrimary = Color(0xffa4c9ff),
        secondary = Color(0xff545f70),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffd8e3f8),
        onSecondaryContainer = Color(0xff121c2b),
        tertiary = Color(0xff6e5676),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xfff7d9ff),
        onTertiaryContainer = Color(0xff271430),
        error = Color(0xffb3261e),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfff9dedc),
        onErrorContainer = Color(0xff410e0b),
        background = Color(0xfff9f9f9),
        onBackground = Color(0xff1b1b1b),
        surface = Color(0xfff9f9f9),
        onSurface = Color(0xff1b1b1b),
        inverseSurface = Color(0xff303030),
        inverseOnSurface = Color(0xfff1f1f1),
        surfaceVariant = Color(0xffe2e2e2),
        onSurfaceVariant = Color(0xff474747),
        outline = Color(0xff767676)
    )
    val DarkColorScheme = darkColorScheme(
        primary = Color(0xffa4c9ff),
        onPrimary = Color(0xff003060),
        primaryContainer = Color(0xff17487d),
        onPrimaryContainer = Color(0xffd3e3ff),
        inversePrimary = Color(0xff355f97),
        secondary = Color(0xffbcc7db),
        onSecondary = Color(0xff263141),
        secondaryContainer = Color(0xff3d4758),
        onSecondaryContainer = Color(0xffd8e3f8),
        tertiary = Color(0xffdabce2),
        onTertiary = Color(0xff3d2846),
        tertiaryContainer = Color(0xff553f5d),
        onTertiaryContainer = Color(0xfff7d9ff),
        error = Color(0xfff2b8b5),
        onError = Color(0xff601410),
        errorContainer = Color(0xff8c1d18),
        onErrorContainer = Color(0xfff9dedc),
        background = Color(0xff131313),
        onBackground = Color(0xffe2e2e2),
        surface = Color(0xff131313),
        onSurface = Color(0xffe2e2e2),
        inverseSurface = Color(0xffe2e2e2),
        inverseOnSurface = Color(0xff303030),
        surfaceVariant = Color(0xff474747),
        onSurfaceVariant = Color(0xffc6c6c6),
        outline = Color(0xff919191)
    )
}