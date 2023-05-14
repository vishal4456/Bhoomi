package com.bhoomi.Data
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavData( val name: String,
                          val route: String,
                          val icon: ImageVector
)
val bottomNavItems = listOf(
    BottomNavData(
        name = "Home",
        route = "Home",
        icon = Icons.Filled.Home,
    ),
    BottomNavData(
        name = "All Services",
        route = "Home",
        icon = Icons.Rounded.Add,
    ),
    BottomNavData(
        name = "History",
        route = "Home",
        icon = Icons.Rounded.Settings,
    )
    ,
    BottomNavData(
        name = "Offers",
        route = "Home",
        icon = Icons.Rounded.Settings,
    )
)
