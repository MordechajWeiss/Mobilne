package com.example.mobilne

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlin.random.Random

class OnlineNumberMenu : AppCompatActivity() {
    private lateinit var firebase: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_online_number_menu)
    }

    fun clickCreate(view: View) {
        firebase = Firebase.database.reference

        var a1 = "a"
        Log.i("klawiatur", "Before $a1")
        firebase.child("numberOnline").child("counter").get().addOnSuccessListener{

            a1 = it.value as String
            Log.i("klawiatur", "Inside $a1")
            a1 = (a1.toInt()+1).toString()
            firebase.child("numberOnline").child("counter").setValue(a1)
            firebase.child("numberOnline").child(a1).child("1").setValue("NewGame")
            firebase.child("numberOnline").child(a1).child("Flag").setValue("X")
            var number = Random.nextInt(101);
            firebase.child("numberOnline").child(a1).child("Mystery").setValue(number.toString())
            Log.i("klawiatur", "After $a1")
            val myintent = Intent(this,OnlineNumberGame::class.java)
            myintent.putExtra("gameid",a1)
            myintent.putExtra("playerChar","X")
            startActivity(myintent)

        }.addOnFailureListener{
            Log.e("klawiatur", "Error getting data", it)
        }
    }
    fun clickConnect(view: View) {
        val idInput = findViewById<TextView>(R.id.inputIdNumber).text.toString()

        val myintent = Intent(this,OnlineNumberGame::class.java)
        myintent.putExtra("gameid",idInput)
        myintent.putExtra("playerChar","O")
        startActivity(myintent)
    }
}