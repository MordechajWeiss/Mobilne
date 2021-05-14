package com.example.mobilne

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun click1(view: View) {
        //Toast.makeText(this, "Games clicked", Toast.LENGTH_SHORT).show()
        val myintent = Intent(this,GamesListActivity::class.java)
        startActivity(myintent)
    }
    fun click2(view: View) {
        Toast.makeText(this, "History clicked", Toast.LENGTH_SHORT).show()
    }
    fun click3(view: View) {
        Toast.makeText(this, "Online clicked", Toast.LENGTH_SHORT).show()
    }

}