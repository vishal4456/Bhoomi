package com.bhoomi.Activities.MainPageTogelActivitys

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toolbar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bhoomi.ui.theme.BG

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListActivityUi(name:String,context:Context) {
    Scaffold(containerColor = BG,topBar = { Toolbar(name) }) {
        when (name) {
            "Members" -> {
                Member(it)
            }

            "Socity Bank" -> {
                UserList()
            }

            "Family" -> {
                FamilyData()
            }

            "Achievement" -> {
                FamilyData()
            }

            "Historical Place" -> {
                UserList()
            }

            "Staff" -> {
                UserList()
            }

            "Water Tax" -> {
                UserList()
            }

            "Home Tax" -> {
                UserList()
            }

            "Inventry" -> {
                UserList()
            }

        }
    }

}





