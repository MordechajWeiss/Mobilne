package com.example.mobilne

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChooseHistory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_history)
    }

    fun click1(view: View) {
        val myintent = Intent(this, LocalHistory::class.java)
        startActivity(myintent)
    }

    fun click2(view: View) {

    }



}
