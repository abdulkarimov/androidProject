package com.example.abdulla.session6

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.session.PlaybackState.ACTION_STOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.media.session.PlaybackStateCompat.ACTION_STOP
import android.widget.Button
import android.widget.TextView
import com.example.abdulla.R
import java.lang.Exception

class ServiceActivity : AppCompatActivity() {
    // private val receiver = TestBroadcastReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.service_layout)

//        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also{
//            registerReceiver(receiver,it)
//        }

//        findViewById< Button>(R.id.intent_button).setOnClickListener{
//            val intent = Intent()
//            intent.setAction("com.example.abdulla.session6.NOTIFICATION")
//            intent.putExtra("data",  "TestData")
//            sendBroadcast(intent)
//
//        }

//        val filter = IntentFilter("com.example.abdulla.session6.NOTIFICATION")
//        registerReceiver(receiver,filter)


//findViewById<Button>(R.id.intent_button).setOnClickListener{
//    val intent = Intent(this,TestService::class.java)
//    startService(intent)
//}

        findViewById<Button>(R.id.intent_button).setOnClickListener {
            val intent = Intent(this, TestForegroundService::class.java)
            startService(intent)
            updateStatus()
        }
        findViewById<Button>(R.id.button_Stop).setOnClickListener {
            val intent = Intent(this, TestForegroundService::class.java)
            intent.action = TestForegroundService.ACTION_STOP
            startService(intent)

        }

        Handler().postDelayed({ updateStatus() }, 100)

    }

    private fun updateStatus() {
        if (isServiceRunning(TestForegroundService::class.java))
            findViewById<TextView>(R.id.service_status).setText("Service is Running")
        else
            findViewById<TextView>(R.id.service_status).setText("Service is close")

    }

    @SuppressWarnings("deprecation")
    private fun isServiceRunning(serviceClass: Class<*>): Boolean {
        try {
            val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            for (service in manager.getRunningServices(Int.MAX_VALUE))
                if (service.service.className == serviceClass.name)
                    return true

        } catch (e: Exception) {
            return false
        }
        return false
    }

    override fun onDestroy() {
        super.onDestroy()
//        unregisterReceiver(receiver)
    }

}