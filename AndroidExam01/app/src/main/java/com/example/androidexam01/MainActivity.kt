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
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private val binding by lazy { //속성으로 선언
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val CALL_REQUEST = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
    }

    fun callAction(){
        if(android.os.Build.VERSION.SDK_INT >= 23 &&
            ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CALL_PHONE)
            != PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(this, "CALL_PHONE 권한이 필요하다",Toast.LENGTH_LONG).show()
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CALL_PHONE),
                CALL_REQUEST
            )
            return
        }

        val phoneNumber = Uri.parse("tel : " + binding.phoneNo.text.toString())

        val phoneIntent = Intent(Intent.ACTION_CALL,phoneNumber)

        if(phoneIntent.resolveActivity(packageManager) != null){
            startActivity(phoneIntent)
        }
    }

    fun init(){
        with(binding){
            callBtn.setOnClickListener{
                callAction()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            CALL_REQUEST -> {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"권한 승인", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this,"권한 거절", Toast.LENGTH_LONG).show()
              }
            }
        }
    }

}