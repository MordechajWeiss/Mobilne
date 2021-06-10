package com.example.mobilne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class OnlineXOXOGame : AppCompatActivity() {
    private lateinit var firebase: DatabaseReference
    lateinit var playerChar: String
    lateinit var enemyChar: String
    lateinit var flag: String
    lateinit var gameID: String
    lateinit var board: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_online_x_o_x_o_game)

        gameID = intent.getStringExtra("gameid").toString()
        playerChar  = intent.getStringExtra("playerChar").toString()
        if(playerChar == "X"){
            enemyChar = "O"
        }else{
            enemyChar = "X"
        }
        val textview1 = findViewById<TextView>(R.id.xoOnT1)
        val textview2 = findViewById<TextView>(R.id.xoOnT2)
        val textview3 = findViewById<TextView>(R.id.xoOnT3)
        val btn = findViewById<TextView>(R.id.btnxoOnlRest)

        textview1.text = "Game ID: $gameID"
        textview2.text = "YourChar: $playerChar"


        firebase = Firebase.database.reference
        /*
        firebase.child("xoxoOnline").child(gameID.toString()).child("Flag").get().addOnSuccessListener{
            flag = it.value as String
            textview3.text = "Move: " + flag
        }

        firebase.child("xoxoOnline").child(gameID.toString()).child("1").get().addOnSuccessListener{
            board = it.value as String
            btn.text =  board
        }
        */
        val flagRef = Firebase.database.getReference("xoxoOnline").child(gameID).child("Flag")
        val boardRef = Firebase.database.getReference("xoxoOnline").child(gameID).child("1")

        flagRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                flag = dataSnapshot.value.toString()
                textview3.text = "Move: " + flag
                //findViewById<TextView>(R.id.firebaseXOXOCount).text = value.toString()
                //Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

        boardRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                board = dataSnapshot.value.toString()
                btn.text = board
                //findViewById<TextView>(R.id.firebaseXOXOCount).text = value.toString()
                //Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

        /*for (i in 0..10){
            firebase.child("xoxoOnline").child(gameID.toString()).child(i.toString()).get().addOnSuccessListener{
                if(it.value!=null){
                    textview.text = textview.text.toString() + "\n" + it.value
                }

            }.addOnFailureListener{
                Log.e("klawiatur", "Error getting data", it)
            }
        }*/







    }

    fun click3_1(view: View) {
        if(playerChar == flag){
            board = board.replaceRange(0,1,playerChar)
            Log.e("klawiatur", board)
            firebase.child("xoxoOnline").child(gameID).child("1").setValue(board)
            firebase.child("xoxoOnline").child(gameID).child("Flag").setValue(enemyChar)
        }
    }
    fun click3_2(view: View) {
        if(playerChar == flag){
            board = board.replaceRange(1,2,playerChar)
            Log.e("klawiatur", board)
            firebase.child("xoxoOnline").child(gameID).child("1").setValue(board)
            firebase.child("xoxoOnline").child(gameID).child("Flag").setValue(enemyChar)
        }
    }
    fun click3_3(view: View) {
        if(playerChar == flag){
            board = board.replaceRange(2,3,playerChar)
            Log.e("klawiatur", board)
            firebase.child("xoxoOnline").child(gameID).child("1").setValue(board)
            firebase.child("xoxoOnline").child(gameID).child("Flag").setValue(enemyChar)
        }
    }
    fun click3_4(view: View) {
        if(playerChar == flag){
            board = board.replaceRange(3,4,playerChar)
            Log.e("klawiatur", board)
            firebase.child("xoxoOnline").child(gameID).child("1").setValue(board)
            firebase.child("xoxoOnline").child(gameID).child("Flag").setValue(enemyChar)
        }
    }
    fun click3_5(view: View) {

    }
    fun click3_6(view: View) {

    }
    fun click3_7(view: View) {

    }
    fun click3_8(view: View) {

    }
    fun click3_9(view: View) {

    }
    fun resetClick(view: View) {
        Log.e("klawiatur", "reset clicked")
    }
}




