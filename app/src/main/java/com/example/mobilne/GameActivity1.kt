package com.example.mobilne

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class GameActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game1)

        val extra : String? = intent.getStringExtra("name1")
        findViewById<TextView>(R.id.mainTextGame1).text = findViewById<TextView>(R.id.mainTextGame1).text.toString() + extra
    }


    override fun onBackPressed(){
        val myintent = Intent()
        myintent.putExtra("returnGame1",findViewById<TextView>(R.id.mainTextGame1).text.toString())
        setResult(RESULT_OK,myintent)
        finish()
    }

}