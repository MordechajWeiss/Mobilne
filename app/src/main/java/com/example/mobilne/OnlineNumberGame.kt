package com.example.mobilne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
    lateinit var currentPlayer: String
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
        findViewById<TextView>(R.id.numberOnlineGameData).text = "Game id: $gameID\nYour sign: $playerChar"
        firebase = Firebase.database.reference

        val flagRef = Firebase.database.getReference("numberOnline").child(gameID).child("Flag")
        val boardRef = Firebase.database.getReference("numberOnline").child(gameID).child("1")
        val mysteryRef = Firebase.database.getReference("numberOnline").child(gameID).child("Mystery")

        var textView = findViewById<TextView>(R.id.textTMPON)
        textView.text = "Game id=$gameID\nPlayerid=$playerChar\nEnenemyid=$enemyChar\nMystery=$mystery"

        mysteryRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                mystery = dataSnapshot.value.toString()
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })

        flagRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                currentPlayer = dataSnapshot.value.toString()
                if(currentPlayer == playerChar){
                    findViewById<TextView>(R.id.textTMPON).text = "Your move"
                }else{
                    findViewById<TextView>(R.id.textTMPON).text = "Wait for your move"
                }
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })

        boardRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                findViewById<TextView>(R.id.onlineNumberinfoText).text = dataSnapshot.value.toString()
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })




    }

    fun resetClicked(view: View) {
        if(currentPlayer == playerChar){
            firebase.child("numberOnline").child(gameID).child("1").setValue("Player $playerChar clicked reset")
            firebase.child("numberOnline").child(gameID).child("Flag").setValue(enemyChar)
        }
    }
    fun buttonClicked(view: View) {
        if(currentPlayer == playerChar){
            var n = findViewById<TextView>(R.id.onlineNumbertextInput).text.toString()

            if(n.toInt() > mystery.toInt()){
                firebase.child("numberOnline").child(gameID).child("1").setValue("Less than $n")
            }else if(n.toInt() < mystery.toInt()){
                firebase.child("numberOnline").child(gameID).child("1").setValue("More than $n")
            }else{
                firebase.child("numberOnline").child(gameID).child("1").setValue("Player $playerChar is right, number is equal $mystery")
            }
            firebase.child("numberOnline").child(gameID).child("Flag").setValue(enemyChar)

        }
    }
}