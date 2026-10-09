package com.example.liver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.liver.navigation.AppNavigation
import com.example.liver.ui.theme.LiverTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LiverTheme {
                AppNavigation()
            }
        }
    }
}