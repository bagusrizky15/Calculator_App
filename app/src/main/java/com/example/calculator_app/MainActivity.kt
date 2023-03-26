package com.example.calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculator_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClear.setOnClickListener {
            binding.tvInput.text = "0"
            binding.tvOutput.text = "0"
        }


    }
}