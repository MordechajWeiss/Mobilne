package com.example.mobilne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class OnlineNumberGame : AppCompatActivity() {
    private lateinit var firebase: DatabaseReference
    lateinit var gameID: String
    lateinit var playerChar: String
    lateinit var enemyChar: String
    var mystery: String = "z"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_online_number_game)


        gameID = intent.getStringExtra("gameid").toString()
        playerChar  = intent.getStringExtra("playerChar").toString()
        if(playerChar == "X"){
            enemyChar = "O"
        }else{
            enemyChar = "X"
        }

        firebase = Firebase.database.reference

        val flagRef = Firebase.database.getReference("numberOnline").child(gameID).child("Flag")
        val boardRef = Firebase.database.getReference("numberOnline").child(gameID).child("1")
        val mysteryRef = Firebase.database.getReference("numberOnline").child(gameID).child("Mystery")

        var textView = findViewById<TextView>(R.id.textTMP)

        mysteryRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                mystery = dataSnapshot.value.toString()
                textView.text = "Game id=$gameID\nPlayerid=$playerChar\nEnenemyid=$enemyChar\nMystery=$mystery"
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })




        textView.text = "Game id=$gameID\nPlayerid=$playerChar\nEnenemyid=$enemyChar\nMystery=$mystery"

    }
}