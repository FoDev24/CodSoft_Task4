package com.example.notification.ui.presentation.main_screen

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.notification.R

@Composable
fun MainScreen(
    context : Context
) {



    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottie))
    var isPlaying by remember { mutableStateOf(false) }



    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isPlaying)

    LaunchedEffect(key1 = progress ){
        if(progress == 0f){
            isPlaying = true
        }
        if(progress == 1f){
            isPlaying = false
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

            LottieAnimation(
                modifier = Modifier.size(300.dp)
                    .clickable {
                        val createNotification = NotificationService(context =context, title = "CodSoft",msg ="CodSoft internship BATCH P5")
                        createNotification.showNotification()
                        isPlaying = true },
                composition = composition,
                progress = {progress}
            )



    }
}