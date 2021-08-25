package com.example.abdulla.session4

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import com.example.abdulla.R

class CustomDialog(context: Context) : Dialog(context), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.custom_curve)
        val yesButton = findViewById<Button>(R.id.btn_yes)
        val noButton = findViewById<Button>(R.id.btn_no)
        yesButton.setOnClickListener(this)
        noButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_yes -> dismiss()
            R.id.btn_no -> dismiss()
            else -> {
            }

        }
        dismiss()
    }


}