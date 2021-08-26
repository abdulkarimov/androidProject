package com.example.abdulla.session6

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import java.lang.StringBuilder

class TestBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        StringBuilder().apply {
            append("#ss Action: ${intent?.action}\n")
            append("#ss Data: ${intent?.data}\n")
            append("#ss Extras: ${intent?.extras}\n")
            toString().also { data -> println(data) }
        }
    }


}