package com.example.mobilne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class OnlineData : AppCompatActivity() {
    private lateinit var firebase: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_online_data)

        firebase = Firebase.database.reference

        var t1 = findViewById<TextView>(R.id.onlineData1)
        var t2 = findViewById<TextView>(R.id.onlineData2)
        var t3 = findViewById<TextView>(R.id.onlineData3)
        var t4 = findViewById<TextView>(R.id.onlineData4)


        var a1 : String

        firebase.child("xoxoCount").get().addOnSuccessListener{
            a1 = "${it.value}"
            t1.text = "Local xoxo global:" + a1

        }.addOnFailureListener{
            Log.e("klawiatur", "Error getting data", it)
        }

        firebase.child("numberCount").get().addOnSuccessListener{
            a1 = "${it.value}"
            t2.text = "Local number global: $a1"

        }.addOnFailureListener{
            Log.e("klawiatur", "Error getting data", it)
        }

        firebase.child("xoxoOnline").child("counter").get().addOnSuccessListener{
            a1 = "${it.value}"
            t3.text = "Online xoxo global: $a1"

        }.addOnFailureListener{
            Log.e("klawiatur", "Error getting data", it)
        }

        firebase.child("numberOnline").child("counter").get().addOnSuccessListener{
            a1 = "${it.value}"
            t4.text = "Online number global: $a1"

        }.addOnFailureListener{
            Log.e("klawiatur", "Error getting data", it)
        }

        Thread.sleep(700)
    }
}