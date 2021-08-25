package com.example.abdulla.session5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.abdulla.R
import com.example.abdulla.databinding.FragmentFinishBinding


class finishFragment : Fragment() {

    val args: finishFragmentArgs by navArgs()
    private lateinit var binding : FragmentFinishBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFinishBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onStart() {
        super.onStart()
        binding.title.text = args.title
        binding.subtitle.text =args.subtitle?: "default subtitle"

    }

}