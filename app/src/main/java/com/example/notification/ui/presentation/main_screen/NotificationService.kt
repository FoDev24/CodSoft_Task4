package com.example.notification.ui.presentation.main_screen

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.notification.MainActivity
import com.example.notification.R

class NotificationService(
    val msg : String ,
    val title : String ,
    val context : Context
) {
    val channelId = "My_channel"
    val channelName= "My channel name"
    val notificationManager = context.applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var notificationBuilder: NotificationCompat.Builder

    fun showNotification(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            notificationChannel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        notificationBuilder = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(R.drawable.ic_launcher_background)
        .addAction(R.drawable.ic_launcher_background, "Open Notification", pendingIntent)
        .setContentTitle(title)
        .setContentText(msg)
        .setAutoCancel(true)
        notificationManager.notify(100, notificationBuilder.build())
    }
}