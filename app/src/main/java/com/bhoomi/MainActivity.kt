package com.bhoomi

import android.annotation.SuppressLint

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem

import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp

import com.bhoomi.Navigation.StartNavigation
import com.bhoomi.Screens.DashbordIcons

import com.bhoomi.Screens.Toolbar
import com.bhoomi.ui.theme.BhoomiTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BhoomiTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.background(color = Color(0xFFFFFFFF))) {
                    Scaffold(
                        topBar = { Toolbar() }, bottomBar = { BottomNav() },
                        contentColor = Color(0xFFFFFFFF),
                        containerColor = Color(0xFFFFFFFF),

/*                        floatingActionButton = {
                            FloatingActionButton(
                                onClick = {},
                                modifier = Modifier.padding(bottom = 10.dp),
                                contentColor = Color.White,
                                elevation = FloatingActionButtonDefaults.elevation(2.dp, 3.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_home),
                                    contentDescription = "Home"
                                )
                            }

                           // floatingActionButtonPosition = FabPosition.Center
                        }*/ //floatingActionButtonPosition = FabPosition.Center
                        // floatingActionButtonPosition = FabPosition.Center
                    ) {
                        Column(modifier = Modifier.fillMaxSize()) {
                            StartNavigation()
                        }

                    }
                }
            }
        }
    }

}
@Composable
fun BottomNav() {
    var currentSelectedScrrenId by rememberSaveable() { mutableStateOf(0) }
    //val items = listOf(Screen.Contact, Screen.Scan, Screen.Per, Screen.Menu)

    BottomAppBar(
        containerColor = Color.White, contentColor = Color.LightGray,
        tonalElevation = 5.dp,
        modifier = Modifier.fillMaxWidth()

    ) {
        NavigationBarItem(selected = currentSelectedScrrenId == 1,

            onClick = { currentSelectedScrrenId = DashbordIcons.Contact.id }, icon = {
                Icon(
                    painter = painterResource(id = DashbordIcons.Contact.selectedIconId),
                    contentDescription = DashbordIcons.Contact.title

                )
            })
        NavigationBarItem(selected = currentSelectedScrrenId == 2,
            onClick = { currentSelectedScrrenId = DashbordIcons.Menu.id }, icon = {
                Icon(
                    painter = painterResource(id = DashbordIcons.Menu.selectedIconId),
                    contentDescription = DashbordIcons.Menu.title

                )
            })
        // Spacer(modifier = Modifier.padding(start = 10.dp))
        NavigationBarItem(selected = currentSelectedScrrenId == 3,
            onClick = { currentSelectedScrrenId = DashbordIcons.Scan.id }, icon = {
                Icon(
                    painter = painterResource(id = DashbordIcons.Scan.selectedIconId),
                    contentDescription = DashbordIcons.Scan.title

                )
            })
        NavigationBarItem(selected = currentSelectedScrrenId == 4,
            onClick = { currentSelectedScrrenId = DashbordIcons.Per.id }, icon = {
                Icon(
                    painter = painterResource(id = DashbordIcons.Per.selectedIconId),
                    contentDescription = DashbordIcons.Per.title


                )
            })

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BhoomiTheme {

    }
}
