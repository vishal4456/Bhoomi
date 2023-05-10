package com.bhoomi.Activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.bhoomi.Navigation.StartNavigation
import com.bhoomi.ui.theme.BhoomiTheme

class LoginActivity :ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BhoomiTheme() {
                Surface {
                    StartNavigation()
                }
            }
        }
    }
}