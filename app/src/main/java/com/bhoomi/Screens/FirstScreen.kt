package com.bhoomi.Screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.bhoomi.Utils.RouteScreen

@Composable
fun FirstScreen(navHostController: NavHostController) {
    Button(onClick = {
        navHostController.navigate(RouteScreen.SecondScreen.route) })
    {
        Text(text = "First Screen")
    }


}