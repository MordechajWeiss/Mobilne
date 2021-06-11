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
    var boardFlags = arrayOf(0,0,0,0,0,0,0,0,0)


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

        val flagRef = Firebase.database.getReference("xoxoOnline").child(gameID).child("Flag")
        val boardRef = Firebase.database.getReference("xoxoOnline").child(gameID).child("1")

        flagRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                flag = dataSnapshot.value.toString()
                textview3.text = "Move: " + flag
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

        boardRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                board = dataSnapshot.value.toString()
                for (i in 0..8){
                    if(board[i] != '_' && boardFlags[0] == 0){
                        boardFlags[i] = 1;
                    }
                }
                btn.text = board
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })



    }

    fun click3_1(view: View) {
        if(playerChar == flag && boardFlags[0] == 0){
            board = board.replaceRange(0,1,playerChar)
            firebase.child("xoxoOnline").child(gameID).child("1").setValue(board)
            firebase.child("xoxoOnline").child(gameID).child("Flag").setValue(enemyChar)
        }
    }
    fun click3_2(view: View) {
        if(playerChar == flag && boardFlags[1] == 0){
            board = board.replaceRange(1,2,playerChar)
            firebase.child("xoxoOnline").child(gameID).child("1").setValue(board)
            firebase.child("xoxoOnline").child(gameID).child("Flag").setValue(enemyChar)
        }
    }
    fun click3_3(view: View) {
        if(playerChar == flag && boardFlags[2] == 0){
            board = board.replaceRange(2,3,playerChar)
            firebase.child("xoxoOnline").child(gameID).child("1").setValue(board)
            firebase.child("xoxoOnline").child(gameID).child("Flag").setValue(enemyChar)
        }
    }
    fun click3_4(view: View) {
        if(playerChar == flag && boardFlags[3] == 0){
            board = board.replaceRange(3,4,playerChar)
            firebase.child("xoxoOnline").child(gameID).child("1").setValue(board)
            firebase.child("xoxoOnline").child(gameID).child("Flag").setValue(enemyChar)
        }
    }
    fun click3_5(view: View) {
        if(playerChar == flag && boardFlags[4] == 0){
            board = board.replaceRange(4,5,playerChar)
            firebase.child("xoxoOnline").child(gameID).child("1").setValue(board)
            firebase.child("xoxoOnline").child(gameID).child("Flag").setValue(enemyChar)
        }
    }
    fun click3_6(view: View) {
        if(playerChar == flag && boardFlags[5] == 0){
            board = board.replaceRange(3,4,playerChar)
            firebase.child("xoxoOnline").child(gameID).child("1").setValue(board)
            firebase.child("xoxoOnline").child(gameID).child("Flag").setValue(enemyChar)
        }
    }
    fun click3_7(view: View) {
        if(playerChar == flag && boardFlags[6] == 0){
            board = board.replaceRange(5,6,playerChar)
            firebase.child("xoxoOnline").child(gameID).child("1").setValue(board)
            firebase.child("xoxoOnline").child(gameID).child("Flag").setValue(enemyChar)
        }
    }
    fun click3_8(view: View) {
        if(playerChar == flag && boardFlags[7] == 0){
            board = board.replaceRange(6,7,playerChar)
            firebase.child("xoxoOnline").child(gameID).child("1").setValue(board)
            firebase.child("xoxoOnline").child(gameID).child("Flag").setValue(enemyChar)
        }
    }
    fun click3_9(view: View) {
        if(playerChar == flag && boardFlags[8] == 0){
            board = board.replaceRange(7,8,playerChar)
            firebase.child("xoxoOnline").child(gameID).child("1").setValue(board)
            firebase.child("xoxoOnline").child(gameID).child("Flag").setValue(enemyChar)
        }
    }
    fun resetClick(view: View) {
        Log.e("klawiatur", "reset clicked")
    }
}




