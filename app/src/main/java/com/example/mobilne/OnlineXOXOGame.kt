package com.example.mobilne

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class OnlineXOXOGame : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_online_x_o_x_o_game)

        var extra : String? = intent.getStringExtra("gameid")
        val textview = findViewById<TextView>(R.id.textxoxoOnline)

        textview.text = "Extra: $extra"

    }
}


