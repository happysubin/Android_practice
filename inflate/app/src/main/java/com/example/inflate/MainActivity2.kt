package com.example.inflate2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import com.example.inflate.R
import com.example.inflate.databinding.ActivityMainBinding
import com.example.inflate.databinding.ActivityPartBinding

class MainActivity2 : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val partBinding by lazy{
        ActivityPartBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.btnShow.setOnClickListener{
            val parent = partBinding.root.parent as ViewGroup?

            parent?.removeAllViews()

            binding.addContainer.addView(partBinding.root)
        }
    }
}