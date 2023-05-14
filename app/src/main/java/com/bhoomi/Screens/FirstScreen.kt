package com.bhoomi.Screens

import android.annotation.SuppressLint
import android.widget.Toolbar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bhoomi.R
import com.bhoomi.Utils.RouteScreen

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FirstScreen(navHostController: NavHostController) {

Surface {
    Scaffold(){

    }
    Button(onClick = { navHostController.navigate(RouteScreen.SecondScreen.route) }, modifier = Modifier.padding(top = 200.dp)) {
        Text(text = "HiiBro")
    }
  //  RecyclerView(Data = BoxData())
}
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    // val context = LocalContext.current
    TopAppBar(modifier = Modifier.background(color = Color.White),
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
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFFFFFFFF),
                        Color(0x8A33A5FF)
                    )
                )
            )
            .padding(top = 50.dp),
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3), modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            items(Data){ box->
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

    Column(
        Modifier
            .padding(top = 20.dp, bottom = 20.dp)
    ) {
        FloatingActionButton(
            onClick = { }, modifier = Modifier
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
   // RecyclerView(Data = BoxData())
}
