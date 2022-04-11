package com.example.androidexam01

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import com.example.androidexam01.databinding.ActivityHomeBinding
import com.example.androidexam01.databinding.ActivityMainBinding
import java.lang.NumberFormatException

class HomeActivity : AppCompatActivity() {

    private lateinit var mActivityResultLauncher : ActivityResultLauncher<Intent>

    private val binding by lazy { //속성으로 선언
        ActivityHomeBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnQuestions.setOnClickListener{
            val mIntent = Intent(this, SecondActivity::class.java)

            mIntent.putExtra("QUESTION", "아이유 데뷔년도 및 멜론 인기곡 1위는 ?")

            mActivityResultLauncher.launch(mIntent)
        }
        getResponseResult()
    }
    private fun getResponseResult(){
      mActivityResultLauncher = registerForActivityResult(
          ActivityResultContracts.StartActivityForResult()){ result->
          if(result.resultCode == RESULT_OK){
              val debut = result.data?.getIntExtra("DEBUT",0)
              val song = result.data?.getStringExtra("SONG").orEmpty()
              binding.mainTvResult.text = "Answers: 데뷔 : $debut, 인기곡 : $song"
              Toast.makeText(this,"Answers: 데뷔년도 : $debut, 인기곡 : $song",Toast.LENGTH_LONG).show()
          }else{
              binding.mainTvResult.text = "RESULT_ERROR"
              Toast.makeText(this, "RESULT_ERROR",Toast.LENGTH_LONG).show()
          }
      }
    }
}