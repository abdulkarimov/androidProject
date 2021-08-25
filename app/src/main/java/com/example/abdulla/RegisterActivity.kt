package com.example.abdulla

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.io.File

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)



//        var button = findViewById<Button>(R.id.button2);
//
//        button.setOnClickListener()
//        {
//
//            startActivity(intent)
//        }

       // val marginTop = resources.getDimension(R.dimen.margin_title)






        println("academy on create")
    }
   override fun onStart()
    {
        super.onStart()
        println("academy on start")
    }
    override fun onResume()
    {
        super.onResume()
        println("academy on resume")
    }

    override fun onPause()
    {
        super.onPause()
        println("academy on pause")
    }

    override fun onStop()
    {
        super.onStop()
        println("academy on stop")
    }

    override fun onDestroy()
    {
        super.onDestroy()
        println("academy on destroy")
    }




}