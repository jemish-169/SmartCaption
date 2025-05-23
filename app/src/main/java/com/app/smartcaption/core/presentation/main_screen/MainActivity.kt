package com.app.smartcaption.core.presentation.main_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.app.smartcaption.core.presentation.navigation.RootNavGraph
import com.app.smartcaption.theme.SmartCaptionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartCaptionTheme {
                RootNavGraph()
            }
        }
    }
}