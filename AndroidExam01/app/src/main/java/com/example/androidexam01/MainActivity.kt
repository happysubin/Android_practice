package com.example.androidexam01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.androidexam01.databinding.ActivityMainBinding
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private val binding by lazy { //속성으로 선언
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            val id = binding.editId.text.toString()
            val pw = binding.editPw.text.toString()

            Toast.makeText(applicationContext, "id: $id, pw: $pw",Toast.LENGTH_LONG).show()
            println("id : $id, pw: $pw")
        }

        binding.btnConfirm.setOnClickListener{
            try{
            val num1 = binding.editNum1.text.toString().toInt()
            val num2 = binding.editNum2.text.toString().toInt()

            val result = num1 + num2
            binding.tvResult.text = result.toString()
            } catch(err: NumberFormatException){
                binding.tvResult.text = "null"
            }
        }
    }
}