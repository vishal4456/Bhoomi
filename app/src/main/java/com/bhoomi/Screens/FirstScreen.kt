package com.bhoomi.Screens

import android.annotation.SuppressLint
import android.content.Intent
import android.widget.Toast
import android.widget.Toolbar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import com.bhoomi.Activities.ListActivity
import com.bhoomi.Activities.LoginActivity
import com.bhoomi.Navigation.StartNavigation
import com.bhoomi.R
import com.bhoomi.Utils.RouteScreen

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FirstScreen(navHostController: NavHostController) {


    Surface() {
Column(Modifier.background(Color(0xFFFFFFFF))) {
    RecyclerView(Data = BoxData())
    CardSpinWheel()

}
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    // val context = LocalContext.current
    TopAppBar(modifier = Modifier.background(color = Color(0xFFFFFFFF)),
        /*backgroundColor = Color.White*/        title = {
            Text("Welcome Bhoomi", color = Color.Black, fontWeight = FontWeight.Bold)
        },
        actions = {
            IconButton(onClick = { }, enabled = false) {
                Image(
                    painterResource(R.drawable.rewards),
                    modifier = Modifier.size(25.dp),
                    contentDescription = "Test"
                )
            }
            IconButton(onClick = { }, enabled = false) {
                Icon(
                    Icons.Filled.Person,
                    modifier = Modifier.size(29.dp),
                    tint = Color.Black,
                    contentDescription = "Test"
                )
            }


        }

    )

}

@Composable
fun RecyclerView(Data: List<MainpageData>) {
    Column(
        Modifier
            .padding(bottom = 10.dp)
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFFFFFFFF),
                        Color(0x2233A5FF),
                        Color(0x8A33A5FF)
                    )
                )
            )
            .padding(top = 60.dp),
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3), modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            items(Data) { box ->
                EachRow(box = box)
            }

        }
        Box() {
            Image(painter = painterResource(id = R.drawable.wave55), contentDescription = "wave")

        }

    }
}

@Composable
fun EachRow(box: MainpageData) {
    val context = LocalContext.current
    val intent = Intent(context, ListActivity::class.java)
    Column(
        Modifier
            .padding(top = 20.dp, bottom = 20.dp)
    ) {
        FloatingActionButton(
            onClick = {
                when (box.name) {

                    "Members" -> {
                        intent.putExtra("name", box.name)
                       //  context.startActivity(Intent(context,ListActivity::class.java))
                    }

                    "Socity Bank" -> {
                        intent.putExtra("name", box.name)
                    }

                    "Family" -> {
                        intent.putExtra("name", box.name)
                    }

                    "Achievement" -> {
                        intent.putExtra("name", box.name)
                    }

                    "Historical Place" -> {
                        intent.putExtra("name", box.name)

                    }

                    "Staff" -> {
                        intent.putExtra("name", box.name)
                    }

                    "Water Tax" -> {
                        intent.putExtra("name", box.name)
                    }

                    "Home Tax" -> {
                        intent.putExtra("name", box.name)
                    }

                    "Inventry" -> {
                        intent.putExtra("name", box.name)
                    }

                }
                context.startActivity(intent)

            }, modifier = Modifier
                .padding(bottom = 5.dp)
                .align(Alignment.CenterHorizontally), shape = RoundedCornerShape(22.dp),
            containerColor = Color.White,
            contentColor = Color.Black,
            elevation = FloatingActionButtonDefaults.elevation(1.dp, 2.dp)
        ) {
            Icon(
                painter = painterResource(box.src),
                contentDescription = "Home"
            )
            /* IconButton(onClick = { *//*TODO*//* }) {
                Icon(painter = painterResource(id = box.src), contentDescription = box.name)
            }*/
        }
        Text(
            text = box.name,
            fontSize = 13.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

    }
    /*
        Row(modifier = Modifier) {
            Text(text = box.name)
        }
    */
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardSpinWheel() {
    Box() {
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .graphicsLayer {
                shape = RoundedCornerShape(20.dp)
                clip = true
            }, colors =  CardDefaults.cardColors(
        ),) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)) {
                Column(modifier = Modifier.padding(2.dp)) {
                    Text(text = "Spin The Wheel", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 20.sp)
                    Text(text = "Win Everyday", fontSize = 15.sp)

                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Bottom)) {
                    Button(onClick = { /*TODO*/ },Modifier.align(Alignment.BottomEnd)) {
                        Text(text = "SPIN NOW", fontWeight = FontWeight.Bold, color = Color.White )

                    }
                }

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
CardSpinWheel()
}
