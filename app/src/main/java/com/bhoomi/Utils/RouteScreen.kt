package com.bhoomi.Utils

sealed class RouteScreen(val route :String)
{
    object FirstScreen : RouteScreen("FirstScrren")
    object SecondScreen : RouteScreen("SecondScrren")

}
