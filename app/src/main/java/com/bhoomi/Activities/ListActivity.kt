package com.bhoomi.Activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bhoomi.R
import com.bhoomi.ui.theme.BG
import com.bhoomi.ui.theme.BhoomiTheme

class ListActivity : ComponentActivity() {
    lateinit var name : String
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         name = intent.getStringExtra("name").toString()
        setContent {
            BhoomiTheme() {
                Surface {
                    Scaffold(topBar = { Toolbar() }) {
                        when (name) {
                            "Members" -> {
                                UserList()
                            }

                            "Socity Bank" -> {
                                UserList()
                            }

                            "Family" -> {
                                UserList()
                            }

                            "Achievement" -> {
                                UserList()
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
        TopAppBar(modifier = Modifier.background(color = Color(0xFFFFFFFF)),
            /*backgroundColor = Color.White*/        title = {
                Text(name, color = Color.Black, fontWeight = Bold)
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
        onClick = {expended.value = !expended.value},
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .wrapContentHeight(), elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ) ){

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(5.dp)
                .padding(5.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .padding(start = 10.dp)
                    .clip(CircleShape)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(start = 15.dp)
            ) {
                Row() {
                    Text(text = "Full Name: ", fontWeight = FontWeight.Bold)
                    Text(text = "Vishal Vidhate")
                }
                if (expended.value) {

                    Column(modifier = Modifier.padding(bottom = extraPadding.coerceAtLeast(0.dp))) {

                        Row() {
                            Text(text = "First Name: ", fontWeight = FontWeight.Bold)
                            Text(text = "Vishal")
                        }


                        Row() {
                            Text(text = "Gender: ", fontWeight = FontWeight.Bold)
                            Text(text = "Male/Female")
                        }
                        Row() {
                            Text(text = "Mobile No: ", fontWeight = FontWeight.Bold)
                            Text(text = "9960583887")
                        }

                    }

                }





            }
        }

    }
}

data class User(val id: Int)

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


@Composable
fun UserList() {
    /*
Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
    for (i in 1..25){
        Members()
    }

}
*/
    LazyColumn (modifier = Modifier.padding(top = 55.dp)){
        items((users)) { User ->
            Members()

        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UserList()
}