package com.example.abdulla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.abdulla.databinding.ActivityBidinBinding

class BidinActivity : AppCompatActivity() {
    private var binding: ActivityBidinBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBidinBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        binding!!.textForBinding

    }


}