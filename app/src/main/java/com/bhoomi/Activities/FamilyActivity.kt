package com.bhoomi.Activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.bhoomi.ui.theme.BG
import com.bhoomi.ui.theme.BGLite
import com.bhoomi.ui.theme.BhoomiTheme
import com.bhoomi.ui.theme.Brown

class FamilyActivity:ComponentActivity() {

    lateinit var name: String
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BhoomiTheme() {
                Surface() {
                    Scaffold(containerColor = BG,topBar = { Toolbar() }) {

                    }
                }

            }
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Toolbar() {
        // val context = LocalContext.current
        TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(BG),
            navigationIcon = { Icon( Icons.Filled.ArrowBack,
                modifier = Modifier.size(30.dp),
                tint = Color.White,
                contentDescription = "Test"
            )
            },
            modifier = Modifier.background(color = Color(0xFFFFFFFF)),
            /*backgroundColor = Color.White*/        title = {
                Text(name, color = Color.White, fontWeight = FontWeight.Bold)
            }
        )

    }

    @Composable
    fun FamilyData(){
        Card(elevation = CardDefaults.cardElevation(pressedElevation = 20.dp),
            shape = CardDefaults.elevatedShape, colors = CardDefaults.cardColors(Color.White), modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 70.dp, start = 5.dp, end = 5.dp)) {
            Column() {
                Card(elevation = CardDefaults.cardElevation(pressedElevation = 20.dp),
                    shape = CardDefaults.elevatedShape, colors = CardDefaults.cardColors(BGLite), modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .padding(top = 40.dp, start = 15.dp, end = 15.dp, bottom = 20.dp)) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()) {
                        Column() {
                            Row(
                                modifier = Modifier.padding(10.dp)
                            ) {
                                Text(text = "CODE -:", fontWeight = FontWeight.Bold,color = Color.Black)
                                Text(text = "124",color = Color.Black)
                            }
                            Row(modifier = Modifier.padding(10.dp)){
                                Text(text = "WARD NO -:", fontWeight = FontWeight.Bold,color = Color.Black)
                                Text(text = "10",color = Color.Black)
                            }

                        }
                        Column() {
                            Row(modifier = Modifier.padding(10.dp))
                            {
                                Text(text = "Ration Card-:", fontWeight = FontWeight.Bold,color = Color.Black)
                                Text(text = "10",color = Color.Black)
                            }
                            Row(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                                Text(text = "Inventery",
                                    textDecoration = TextDecoration.Underline,
                                    color = Brown
                                )

                            }

                        }
                    }
                }
                Card(elevation = CardDefaults.cardElevation(pressedElevation = 20.dp),
                    shape = CardDefaults.elevatedShape, colors = CardDefaults.cardColors(BGLite), modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .padding(start = 10.dp, end = 10.dp)) {

                    Row {
                        FamilyList()
                    }
                }

            }

        }

    }


}