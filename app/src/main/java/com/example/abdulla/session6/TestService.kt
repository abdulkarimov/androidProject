package com.example.abdulla.session6
import android.app.Service
import android.content.Intent
import android.os.*

class TestService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    private var serciveLooper: Looper? = null
    private var serviceHandler: ServiceHelper? = null

    override fun onCreate() {
        super.onCreate()
        HandlerThread("Arguments").apply {
            start()
            serciveLooper = looper
            serviceHandler = ServiceHelper(looper)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("#ss service start")

        serviceHandler?.obtainMessage()?.also { msg ->
            msg.arg1 = startId
            serviceHandler?.sendMessage(msg)
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        println("#ss service Destroyed")
    }


    private inner class ServiceHelper(looper: Looper) : Handler(looper) {

        override fun handleMessage(msg: Message) {
            try {
                Thread.sleep(5000)
            } catch (e: Exception) {
                Thread.currentThread().interrupt()
            }
            stopSelf(msg.arg1)
        }
    }
}