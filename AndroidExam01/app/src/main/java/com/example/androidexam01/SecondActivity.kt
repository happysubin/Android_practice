package com.example.androidexam01

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.androidexam01.databinding.ActivityMainBinding
import com.example.androidexam01.databinding.ActivitySecondBinding
import java.lang.NumberFormatException

class SecondActivity : AppCompatActivity() {

    private val binding by lazy { //속성으로 선언
        ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var question = intent.getStringExtra("QUESTION")

        binding.secondTvResult.text = "Questions : $question"
        Toast.makeText(this, "QUESTION = $question", Toast.LENGTH_LONG).show()

        binding.btnAnswers.setOnClickListener{
            val sIntent = Intent()
            sIntent.putExtra("DEBUT",2008)
            sIntent.putExtra("SONG","라일락")

            setResult(RESULT_OK,sIntent)

            finish()

        }
    }

}