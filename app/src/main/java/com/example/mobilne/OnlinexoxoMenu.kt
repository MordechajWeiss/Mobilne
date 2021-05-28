package com.example.mobilne

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlin.concurrent.thread

class OnlinexoxoMenu : AppCompatActivity() {
    private lateinit var firebase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onlinexoxo_menu)
    }

    fun clickCreate(view: View) {
        firebase = Firebase.database.reference

        var a1 = "a"
        Log.i("klawiatur", "Before $a1")
        firebase.child("xoxoOnline").child("counter").get().addOnSuccessListener{

            a1 = it.value as String
            Log.i("klawiatur", "Inside $a1")
            a1 = (a1.toInt()+1).toString()
            firebase.child("xoxoOnline").child("counter").setValue(a1)
            firebase.child("xoxoOnline").child(a1).child("1").setValue("Start")
            firebase.child("xoxoOnline").child(a1).child("Flag").setValue("X")
            Log.i("klawiatur", "After $a1")
            val myintent = Intent(this,OnlineXOXOGame::class.java)
            myintent.putExtra("gameid",a1)
            startActivity(myintent)

        }.addOnFailureListener{
            Log.e("klawiatur", "Error getting data", it)
        }



    }
    fun clickConnect(view: View) {
        val idInput = findViewById<TextView>(R.id.inputIdxoxo).text.toString()



        val myintent = Intent(this,OnlineXOXOGame::class.java)
        myintent.putExtra("gameid",idInput)
        startActivity(myintent)
    }
}