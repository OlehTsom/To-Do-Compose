package com.example.to_docompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import kotlin.random.Random

val md_theme_light_primary = Color(0xFF6750A4)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFEADDFF)
val md_theme_light_onPrimaryContainer = Color(0xFF21005D)
val md_theme_light_secondary = Color(0xFF625B71)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFF1C1B1F)
val md_theme_light_onSecondaryContainer = Color(0xFF1C1B1F)
val md_theme_light_tertiary = Color(0xFF7D5260)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFFFD8E4)
val md_theme_light_onTertiaryContainer = Color(0xFF31111D)
val md_theme_light_error = Color(0xFFB3261E)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_errorContainer = Color(0xFFF9DEDC)
val md_theme_light_onErrorContainer = Color(0xFF410E0B)
val md_theme_light_outline = Color(0xFF79747E)
val md_theme_light_background = Color(0xFFF4EFF4)
val md_theme_light_onBackground = Color(0xFF1C1B1F)
val md_theme_light_surface = Color(0xFFF4EFF4)
val md_theme_light_onSurface = Color(0xFFFFFFFF)
val md_theme_light_surfaceVariant = Color(0xFFE7E0EC)
val md_theme_light_onSurfaceVariant = Color(0xFF49454F)
val md_theme_light_inverseSurface = Color(0xFF313033)
val md_theme_light_inverseOnSurface = Color(0xFFF4EFF4)
val md_theme_light_inversePrimary = Color(0xFF6750A4)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFF6750A4)
val md_theme_light_outlineVariant = Color(0xFFCAC4D0)
val md_theme_light_scrim = Color(0xFF000000)

val md_theme_dark_primary = Color(0xFF000000)
val md_theme_dark_onPrimary = Color(0xFF381E72)
val md_theme_dark_primaryContainer = Color(0xFF4F378B)
val md_theme_dark_onPrimaryContainer = Color(0xFFEADDFF)
val md_theme_dark_secondary = Color(0xFFCCC2DC)
val md_theme_dark_onSecondary = Color(0xFF332D41)
val md_theme_dark_secondaryContainer = Color(0xFF4A4458)
val md_theme_dark_onSecondaryContainer = Color(0xFFFFFFFF)
val md_theme_dark_tertiary = Color(0xFFEFB8C8)
val md_theme_dark_onTertiary = Color(0xFF492532)
val md_theme_dark_tertiaryContainer = Color(0xFF633B48)
val md_theme_dark_onTertiaryContainer = Color(0xFFFFD8E4)
val md_theme_dark_error = Color(0xFFF2B8B5)
val md_theme_dark_onError = Color(0xFF601410)
val md_theme_dark_errorContainer = Color(0xFF8C1D18)
val md_theme_dark_onErrorContainer = Color(0xFFF9DEDC)
val md_theme_dark_outline = Color(0xFF938F99)
val md_theme_dark_background = Color(0xFF1C1B1F)
val md_theme_dark_onBackground = Color(0xFFE6E1E5)
val md_theme_dark_surface = Color(0xFF1C1B1F)
val md_theme_dark_onSurface = Color(0xFFFFFFFF)
val md_theme_dark_surfaceVariant = Color(0xFF49454F)
val md_theme_dark_onSurfaceVariant = Color(0xFFCAC4D0)
val md_theme_dark_inverseSurface = Color(0xFFE6E1E5)
val md_theme_dark_inverseOnSurface = Color(0xFF313033)
val md_theme_dark_inversePrimary = Color(0xFF1C1B1F)
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_surfaceTint = Color(0xFFD0BCFF)
val md_theme_dark_outlineVariant = Color(0xFF49454F)
val md_theme_dark_scrim = Color(0xFF000000)


val seed = Color(0xFF6750A4)

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val HellBeige = Color(0xfff2f0df)
val Beige = Color(0xffe5e4bf)

val LowPriorityColor = Color(0xFF00C980)
val MediumPriorityColor = Color(0xFFFFC114)
val HighPriorityColor = Color(0xFFFF4646)
val NonePriorityColor = Color(0xFFFFFFFF)

val LightGray = Color(0xFFC2C2C2)

val listColorLightTheme = listOf(
    Color(0xFFE6E6FA),  // Лаванда
    Color(0xFFFFB6C1),  // Світло-рожевий
    Color(0xFFFFFF99),  // Пастельно-жовтий
    Color(0xFFFFE5B4),  // Блідо-персиковий
    Color(0xFFF5FFFA),  // М'ята
    Color(0xFFF08080),  // Блідий кораловий
    Color(0xFFD3D3D3),  // Світло-сірий
    Color(0xFFADD8E6),  // Блідий синій
    Color(0xFF90EE90),  // Світло-зелений
    Color(0xFFFAFAFA),  // Перлинний
    Color(0xFFD8BFD8),  // Туманна фіолетова
    Color(0xFFFAEBD7),  // Античний білий
    Color(0xFFF0F8FF),  // Блідо-блакитний
    Color(0xFFFDF5E6),  // Блідо-помаранчевий
    Color(0xFFF0FFFF),  // Світло-блакитний
    Color(0xFFF5F5DC),  // Блідо-бежевий
    Color(0xFFB0E0E6),  // Блідий турецький синій
    Color(0xFFF0F8FF),  // Алісовий
    Color(0xFFFAF0E6),  // Лляний
    Color(0xFFF5DEB3),  // Помаранчево-блідий
    Color(0xFFF5F5F5),  // Чистий білий
    Color(0xFFFAFAD2),  // Блідий жовтий
    Color(0xFFE0FFFF),  // Блідо-блакитний
    Color(0xFFDCDCDC),  // Лайт-сірий
    Color(0xFFF8F8FF),  // Світло-фіолетовий
    Color(0xFFF0FFF0),  // М'ята-кремовий
    Color(0xFFE6E6FA),  // Рожево-блакитний
    Color(0xFFF0E68C),  // Хромо-блідий
    Color(0xFFF8F8FF),  // Івово-блідий
    Color(0xFFFAF0E6),  // Лляний
    Color(0xFFFAFAD2),  // Світло-жовтий
    Color(0xFFF5DEB3),  // Блідо-персиковий
    Color(0xFFE6E6FA),  // Лаванда
    Color(0xFFFFB6C1),  // Світло-рожевий
    Color(0xFFFFFF99),  // Пастельно-жовтий
    Color(0xFFFFE5B4),  // Блідо-персиковий
    Color(0xFFF5FFFA),  // М'ята
    Color(0xFFF08080),  // Блідий кораловий
    Color(0xFFD3D3D3),  // Світло-сірий
    Color(0xFFADD8E6),  // Блідий синій
    Color(0xFF90EE90),  // Світло-зелений
    Color(0xFFFAFAFA),  // Перлинний
    Color(0xFFD8BFD8),  // Туманна фіолетова
    Color(0xFFFAEBD7),  // Античний білий
    Color(0xFFF0F8FF),  // Блідо-блакитний
    Color(0xFFFDF5E6),  // Блідо-помаранчевий
    Color(0xFFF0FFFF),  // Світло-блакитний
    Color(0xFFF5F5DC),  // Блідо-бежевий
    Color(0xFFB0E0E6),  // Блідий турецький синій
    Color(0xFFF0F8FF),  // Алісовий
    Color(0xFFFAF0E6),  // Лляний
    Color(0xFFF5DEB3),  // Помаранчево-блідий
    Color(0xFFF5F5F5),  // Чистий білий
    Color(0xFFFAFAD2),  // Блідий жовтий
    Color(0xFFE0FFFF),  // Блідо-блакитний
    Color(0xFFDCDCDC),  // Лайт-сірий
    Color(0xFFF8F8FF),  // Світло-фіолетовий
    Color(0xFFF0FFF0),  // М'ята-кремовий
    Color(0xFFE6E6FA),  // Рожево-блакитний
    Color(0xFFF0E68C),  // Хромо-блідий
    Color(0xFFF8F8FF),  // Івово-блідий
    Color(0xFFFAF0E6),  // Лляний
    Color(0xFFFAFAD2),  // Світло-жовтий
    Color(0xFFF5DEB3)   // Блідо-персиковий
    )

val listColorDarkTheme = listOf(
    Color(0xFF9E9FB7),  // Лаванда
    Color(0xFFB26673),  // Світло-рожевий
    Color(0xFFB2B279),  // Пастельно-жовтий
    Color(0xFFB28E7B),  // Блідо-персиковий
    Color(0xFFB2BEB2),  // М'ята
    Color(0xFFB25D5D),  // Блідий кораловий
    Color(0xFF737373),  // Світло-сірий
    Color(0xFF607D95),  // Блідий синій
    Color(0xFF5B7C5B),  // Світло-зелений
    Color(0xFFBEBEBE),  // Перлинний
    Color(0xFF8A6E8A),  // Туманна фіолетова
    Color(0xFFA3958F),  // Античний білий
    Color(0xFFA7B4BD),  // Блідо-блакитний
    Color(0xFFABA8A0),  // Блідо-помаранчевий
    Color(0xFFA7A7B7),  // Світло-блакитний
    Color(0xFFB1B1A7),  // Блідо-бежевий
    Color(0xFF778E9E),  // Блідий турецький синій
    Color(0xFFA7A7B7),  // Алісовий
    Color(0xFFA68F82),  // Лляний
    Color(0xFFA6957B),  // Помаранчево-блідий
    Color(0xFFA7A7A7),  // Чистий білий
    Color(0xFFAFADA2),  // Блідий жовтий
    Color(0xFF759F9F),  // Блідо-блакитний
    Color(0xFF7F7F7F),  // Лайт-сірий
    Color(0xFF9FAFB7),  // Світло-фіолетовий
    Color(0xFFA6B6A6),  // М'ята-кремовий
    Color(0xFF9E9EAF),  // Рожево-блакитний
    Color(0xFFA68F77),  // Хромо-блідий
    Color(0xFF9F9FB7),  // Івово-блідий
    Color(0xFFA68F82),  // Лляний
    Color(0xFFAFADA2),  // Світло-жовтий
    Color(0xFFA68F77),  // Блідий персиковий
    Color(0xFF9E9FB7),  // Лаванда
    Color(0xFFB26673),  // Світло-рожевий
    Color(0xFFB2B279),  // Пастельно-жовтий
    Color(0xFFB28E7B),  // Блідо-персиковий
    Color(0xFFB2BEB2),  // М'ята
    Color(0xFFB25D5D),  // Блідий кораловий
    Color(0xFF737373),  // Світло-сірий
    Color(0xFF607D95),  // Блідий синій
    Color(0xFF5B7C5B),  // Світло-зелений
    Color(0xFFBEBEBE),  // Перлинний
    Color(0xFF8A6E8A),  // Туманна фіолетова
    Color(0xFFA3958F),  // Античний білий
    Color(0xFFA7B4BD),  // Блідо-блакитний
    Color(0xFFABA8A0),  // Блідо-помаранчевий
    Color(0xFFA7A7B7),  // Світло-блакитний
    Color(0xFFB1B1A7),  // Блідо-бежевий
    Color(0xFF778E9E),  // Блідий турецький синій
    Color(0xFFA7A7B7),  // Алісовий
    Color(0xFFA68F82),  // Лляний
    Color(0xFFA6957B),  // Помаранчево-блідий
    Color(0xFFA7A7A7),  // Чистий білий
    Color(0xFFAFADA2),  // Блідий жовтий
    Color(0xFF759F9F),  // Блідо-блакитний
    Color(0xFF7F7F7F),  // Лайт-сірий
    Color(0xFF9FAFB7),  // Світло-фіолетовий
    Color(0xFFA6B6A6),  // М'ята-кремовий
    Color(0xFF9E9EAF),  // Рожево-блакитний
    Color(0xFFA68F77),  // Хромо-блідий
    Color(0xFF9F9FB7),  // Івово-блідий
    Color(0xFFA68F82),  // Лляний
    Color(0xFFAFADA2),   // Світло-жовтий
    Color(0xFFC4AB7E)
)

fun getRandomsColorForTheme(): Map<Int, Int> {
    val colorIndex = (listColorLightTheme.indices).random()
    return mapOf(
            listColorDarkTheme[colorIndex].toArgb()
                    to
            listColorLightTheme[colorIndex].toArgb()
    )
}