package com.bhoomi.Activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bhoomi.R
import com.bhoomi.ui.theme.BG
import com.bhoomi.ui.theme.BGLite
import com.bhoomi.ui.theme.BhoomiTheme
import com.bhoomi.ui.theme.Brown

class ListActivity : ComponentActivity() {
    lateinit var name: String

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name = intent.getStringExtra("name").toString()
        setContent {
            BhoomiTheme() {
                Surface {
                    Scaffold(containerColor = BG,topBar = { Toolbar() }) {
                        when (name) {
                            "Members" -> {
                                UserList()
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
        )},
            modifier = Modifier.background(color = Color(0xFFFFFFFF)),
            /*backgroundColor = Color.White*/        title = {
                Text(name, color = Color.White, fontWeight = Bold)
            }
        )

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Members() {

    val expended = remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (expended.value) 5.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Card(
        onClick = { expended.value = !expended.value },
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .wrapContentHeight(), elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ), colors = CardDefaults.cardColors(colorResource(R.color.white))
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(7.dp)
                .padding(5.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(35.dp)
                    .padding(start = 1.dp)
                    .clip(CircleShape)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(start = 15.dp)
            ) {
                Row() {
                    Text(text = "Full Name: ", fontWeight = Bold,color = Color.Black)
                    Text(text = "Vishal Vidhate",color = Color.Black)
                }
                if (expended.value) {

                    Column(modifier = Modifier.padding(bottom = extraPadding.coerceAtLeast(0.dp))) {

                        Row() {
                            Text(text = "First Name: ", fontWeight = Bold,color = Color.Black)
                            Text(text = "Vishal",color = Color.Black)
                        }


                        Row() {
                            Text(text = "Gender: ", fontWeight = Bold,color = Color.Black)
                            Text(text = "Male/Female",color = Color.Black)
                        }
                        Row() {
                            Text(text = "Mobile No: ", fontWeight = Bold,color = Color.Black)
                            Text(text = "9960583887",color = Color.Black)
                        }

                    }

                }


            }
        }

    }
}


data class User(val id: Int)

data class FMember(val id: Int)

val users = listOf(
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
)
val family = listOf(
    FMember(1),
    FMember(1),
    FMember(1),
    FMember(1)

)


@Composable
fun UserList() {

    Card(elevation = CardDefaults.cardElevation(pressedElevation = 20.dp),
        shape = CardDefaults.elevatedShape, colors = CardDefaults.cardColors(BGLite), modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 65.dp, start = 5.dp, end = 5.dp)){

        LazyColumn(modifier = Modifier.padding(top = 5.dp)) {
            items((users)) { User ->
                Members()


            }
        }

    }
}
@Composable
fun FamilyList()
{
    LazyColumn(modifier = Modifier
        .padding(top = 5.dp)
        .fillMaxWidth()) {
        items((family)) { User ->
            FamilyMembers()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FamilyMembers()
{
    Card(
        onClick = { },
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(), elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ), colors = CardDefaults.cardColors(colorResource(R.color.white))
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(5.dp)
                .padding(5.dp)
        ) {
            Icon(
                Icons.Filled.Person,
                modifier = Modifier.size(20.dp),
                tint = Color.Black,
                contentDescription = "Test"
            )

/*
            Image(
                painter = painterResource(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .padding(start = 10.dp)
                    .clip(CircleShape)
            )
*/
/*
            Column(
                modifier = Modifier
                    .padding(start = 5.dp)
            ) {
                Row() {
                  //  Text(text = "Full Name: ", fontWeight = Bold,color = Color.Black)
                    Text(text = "Vishal S Vidhate",color = Color.Black)
                    Text(text = "20",color = Brown)
                }

            }
*/
            Row(modifier = Modifier.padding(start = 5.dp)) {
                Column() {
                    Text(text = "Vishal S Vidhate",color = Color.Black)
                }
                Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                    Text(text = "age",color = Brown, modifier = Modifier.align(Alignment.End))
                    Text(text = "20",color = Brown, modifier = Modifier.align(Alignment.End))
                }
            }
        }

    }

}
@Composable
fun FamilyData(){
    Card(elevation = CardDefaults.cardElevation(pressedElevation = 20.dp),
        shape = CardDefaults.elevatedShape, colors = CardDefaults.cardColors(Color.White), modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 70.dp, start = 5.dp, end = 5.dp)) {
        Column() {
            Card(elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                shape = CardDefaults.elevatedShape, colors = CardDefaults.cardColors(Color.White), modifier = Modifier
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
                            Text(text = "CODE -:", fontWeight = Bold,color = Color.Black)
                            Text(text = "124",color = Color.Black)
                        }
                        Row(modifier = Modifier.padding(10.dp)){
                            Text(text = "WARD NO -:", fontWeight = Bold,color = Color.Black)
                            Text(text = "10",color = Color.Black)
                        }

                    }
                    Column() {
                        Row(modifier = Modifier.padding(10.dp))
                        {
                            Text(text = "Ration Card-:", fontWeight = Bold,color = Color.Black)
                            Text(text = "10",color = Color.Black)
                        }
/*
                        Row(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                            Text(text = "Inventery",
                                textDecoration = TextDecoration.Underline,
                                color = Brown)

                        }
*/

                    }
                }
            }
            Card(elevation = CardDefaults.cardElevation(pressedElevation = 20.dp),
                shape = CardDefaults.elevatedShape, colors =CardDefaults.cardColors(BGLite), modifier = Modifier
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


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
   FamilyData()
}