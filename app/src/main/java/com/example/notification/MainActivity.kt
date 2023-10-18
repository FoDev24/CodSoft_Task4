package com.example.notification

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.media.audiofx.BassBoost
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat.getSystemService
import com.example.notification.ui.presentation.main_screen.MainScreen
import com.example.notification.ui.presentation.main_screen.NotificationService
import com.example.notification.ui.presentation.theme.NotificationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotificationTheme {
                MainScreen(context = this@MainActivity)
            }
        }
    }
}





