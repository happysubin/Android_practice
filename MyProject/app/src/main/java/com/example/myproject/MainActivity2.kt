package com.example.myproject

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val TAG:String = "로그"

    private lateinit var tvinfo : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.button)

        tvinfo = findViewById(R.id.tv_information)

        val btn01: Button = findViewById(R.id.btn_01)
        val btn02: Button = findViewById(R.id.btn_02)
        val btn03: Button = findViewById(R.id.btn_03)
        val btn04: Button = findViewById(R.id.btn_04)
        val btn05: Button = findViewById(R.id.btn_05)

        tvinfo.text = "information..."

        var listener = BtnListener()
        btn01.setOnClickListener(listener)
        btn02.setOnClickListener(listener)

        var listener2 = View.OnClickListener {
            when (it?.id) {
                R.id.btn_03 -> {
                    tvinfo.text = "3번째 버튼"
                    Log.e(TAG, "btn-03 clicked")
                }
                R.id.btn_04 -> {
                    tvinfo.text = "4번째 버튼"
                    Log.e(TAG, "btn-04 clicked")
                }
            }
        }

        btn03.setOnClickListener(listener2)
        btn04.setOnClickListener(listener2)

        btn05.setOnClickListener{
            tvinfo.text = "5번째 버튼"
        }

    }
    inner class BtnListener : View.OnClickListener{
        override fun onClick(v: View?) {
            when(v?.id){
                R.id.btn_01 ->{
                    tvinfo.text = "1번째 버튼"
                    Log.d(TAG,"btn-01 clicked")
                }
                R.id.btn_02 ->{
                    tvinfo.text = "2번째 버튼"
                    Log.d(TAG,"btn-02 clicked")
                }
            }
        }
    }
}