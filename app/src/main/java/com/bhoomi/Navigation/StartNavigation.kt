package com.bhoomi.Navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bhoomi.Screens.FirstScreen
import com.bhoomi.Screens.SecondScreen
import com.bhoomi.Utils.RouteScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartNavigation()
{
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = RouteScreen.FirstScreen.route )
    {
        composable(RouteScreen.FirstScreen.route)
        {
            FirstScreen(navController)
        }
        composable(RouteScreen.SecondScreen.route)
        {
            SecondScreen()
        }
    }
}