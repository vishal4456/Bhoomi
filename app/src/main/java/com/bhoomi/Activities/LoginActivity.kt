package com.bhoomi.Activities

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Surface
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.style.TextOverflow.Companion.Visible
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bhoomi.Data.LogResponces
import com.bhoomi.MainActivity
import com.bhoomi.R
import com.bhoomi.retrofit.APIClient
import com.bhoomi.retrofit.ApiService
import com.bhoomi.ui.theme.BG
import com.bhoomi.ui.theme.BhoomiTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val apiService: ApiService = APIClient.getRetrofit().create(ApiService::class.java)
        super.onCreate(savedInstanceState)
        setContent {
            BhoomiTheme {
                Surface {
                    LoginScreen()
                }


            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LoginScreen() {
        val context = LocalContext.current
        val username = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.hello_rafiki),
                contentDescription = null,
                modifier = Modifier
                    .height(400.dp)
                    .width(400.dp)
            )
            Text(
                text = "Login",
                fontSize = (20.sp),
                modifier = Modifier.padding(bottom = 5.dp),
                fontWeight = FontWeight.Bold,
                color = BG
            )



            OutlinedTextField(value = username.value,
                label = { Text(text = "Email Id") },
                onValueChange = {
                    username.value = it
                },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "LoginId")
                },
                modifier = Modifier
                    .height(70.dp)
                    .padding(top = 10.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(CornerSize(10.dp))
            )



            OutlinedTextField(value = password.value,
                label = { Text(text = "Password") },
                onValueChange = {
                    password.value = it
                },
                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = "Password")
                },
                modifier = Modifier
                    .height(70.dp)
                    .padding(top = 10.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(CornerSize(10.dp))
            )


            FloatingActionButton(
                onClick = {
                    val intent = Intent(this@LoginActivity,MainActivity::class.java)
                    startActivity(intent)
                }, modifier = Modifier.width(80.dp).heightIn(75.dp)
                    .padding(bottom = 5.dp).padding(top = 20.dp)
                    .align(Alignment.CenterHorizontally), shape = RoundedCornerShape(13.dp),
                containerColor = BG,
                contentColor = Color.White,
                elevation = FloatingActionButtonDefaults.elevation(1.dp, 2.dp)
            ){
                Text(
                    text = "Login",
                    color = Color.White,
                    fontSize = 14.sp,
                    overflow = Visible)
            }
/*
            Button(shape =ButtonDefaults.outlinedShape,
                onClick = {
                   // Apicalling(username.value, password.value)
                    val intent = Intent(this@LoginActivity,MainActivity::class.java)
                    startActivity(intent)
                          },
                modifier = Modifier
                    .height(70.dp)
                    .width(85.dp)
                    .padding(top = 20.dp)
                    .align(Alignment.CenterHorizontally), colors = ButtonDefaults.buttonColors(BG)
            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    fontSize = 14.sp,
                    overflow = TextOverflow.Visible
                )
            }
*/


        }

    }

    fun Apicalling(username: String, password: String) {

        val apiService: ApiService = APIClient.getRetrofit().create(ApiService::class.java)
        // val call = apiService.loginData(username,password)
        val call = apiService.looginData("manager", "Live@098")
        call.enqueue(object : Callback<LogResponces> {
            override fun onResponse(
                call: Call<LogResponces>,
                response: Response<LogResponces>,
            ) {
                //val m = response.body()?.get(0)?.id

                if (response.isSuccessful) {
                    if (response.body()?.success == "201") {
                        val intent = Intent(this@LoginActivity,MainActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(baseContext, "sucessful", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(baseContext, "Failed to Login", Toast.LENGTH_LONG).show()

                    }
                    //   val m = response.body()?.get(0)?.id


                    /* if (m == "1")
                     {
                         val intent = Intent(this@LoginActivity,MainActivity::class.java)
                         startActivity(intent)
                       //  Toast.makeText(context,m,Toast.LENGTH_LONG).show()

                     }
                        else
                     {
                         Toast.makeText(baseContext,"error found",Toast.LENGTH_LONG).show()
                     }*/

                }
                /* else(response.body()?.get(0)==)
                 {

                 }*/

            }

            override fun onFailure(call: Call<LogResponces>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()

                Log.d("error", t.message.toString())
            }

            /*  override fun onFailure(call: Call<LoginResponces>, t: Throwable) {

              }*/

            /*  override fun onFailure(call: Call<LogResponces>, t: Throwable) {
                  Toast.makeText(baseContext,"failed", Toast.LENGTH_LONG).show()

              }*/

        })


    }


    @Preview(showBackground = true, name = "light mode", showSystemUi = true)
    @Composable
    fun DefaultPreview() {
        BhoomiTheme() {
            LoginScreen()
        }
    }
}