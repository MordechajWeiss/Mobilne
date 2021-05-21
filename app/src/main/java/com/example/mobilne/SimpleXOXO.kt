package com.example.mobilne

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SimpleXOXO : AppCompatActivity() {
    private var board = arrayOf(2,2,2,2,2,2,2,2,2)
    private var current_player = "X"
    private var won = false
    private var winner = "Z"
    private lateinit var database : SimpleXOXODatabase
    private var move = 0
    private lateinit var list : List<SimpleXOXOEnt>
    private lateinit var savedGame : SimpleXOXOEnt
    var flag = true
    private lateinit var firebase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_x_o_x_o)

        firebase = Firebase.database.reference

        GlobalScope.launch {
            try {
                database = Room.databaseBuilder(
                    applicationContext,
                    SimpleXOXODatabase::class.java,
                    "SimpleXOXOtable.db"
                ).build()
            }catch (e: Exception){
                Log.d("am2021","base")
                finish()
            }
            list = database.SimpleXOXOEntDAO().getAll()
            if(list.isNotEmpty()){
                savedGame = database.SimpleXOXOEntDAO().getLast()
            }
            flag=false;
        }

        //while(flag){
         //   Log.d("am2021","wait")

        //}
        Thread.sleep(1000)

        if(list.isNotEmpty()){
            var x=0;
            var y=0;
            var s = savedGame.board.toString()
            Log.d("am2021", "savedGame: $s")



            if(s[0] != '_'){
                move++

                if(s[0] == 'X'){
                    board.set(0,1)
                    x++
                    findViewById<ImageButton>(R.id.imageButton).setImageResource(R.drawable.xoxo1)
                }
                else{
                    board.set(0,0)
                    y++
                    findViewById<ImageButton>(R.id.imageButton).setImageResource(R.drawable.xoxo2)
                }
            }

            if(s[1] != '_'){
                move++

                if(s[1] == 'X'){
                    board.set(1,1)
                    x++
                    findViewById<ImageButton>(R.id.imageButton2).setImageResource(R.drawable.xoxo1)
                }
                else{
                    board.set(1,0)
                    y++
                    findViewById<ImageButton>(R.id.imageButton2).setImageResource(R.drawable.xoxo2)
                }
            }

            if(s[2] != '_'){
                move++
                if(s[2] == 'X'){
                    board.set(2,1)
                    x++
                    findViewById<ImageButton>(R.id.imageButton3).setImageResource(R.drawable.xoxo1)
                }
                else{
                    board.set(2,0)
                    y++
                    findViewById<ImageButton>(R.id.imageButton3).setImageResource(R.drawable.xoxo2)
                }
            }

            if(s[3] != '_'){
                move++
                if(s[3] == 'X'){
                    findViewById<ImageButton>(R.id.imageButton4).setImageResource(R.drawable.xoxo1)
                    board.set(3,1)
                    x++
                }
                else{
                    findViewById<ImageButton>(R.id.imageButton4).setImageResource(R.drawable.xoxo2)
                    board.set(3,0)
                    y++
                }
            }

            if(s[4] != '_'){
                move++
                if(s[4] == 'X'){
                    findViewById<ImageButton>(R.id.imageButton5).setImageResource(R.drawable.xoxo1)
                    board.set(4,1)
                    x++
                }
                else{
                    findViewById<ImageButton>(R.id.imageButton5).setImageResource(R.drawable.xoxo2)
                    board.set(4,0)
                    y++
                }
            }

            if(s[5] != '_'){
                move++
                if(s[5] == 'X'){
                    findViewById<ImageButton>(R.id.imageButton6).setImageResource(R.drawable.xoxo1)
                    board.set(5,1)
                    x++
                }
                else{
                    findViewById<ImageButton>(R.id.imageButton6).setImageResource(R.drawable.xoxo2)
                    board.set(5,0)
                    y++
                }
            }

            if(s[6] != '_'){
                move++
                if(s[6] == 'X'){
                    findViewById<ImageButton>(R.id.imageButton7).setImageResource(R.drawable.xoxo1)
                    board.set(6,1)
                    x++
                }
                else{
                    findViewById<ImageButton>(R.id.imageButton7).setImageResource(R.drawable.xoxo2)
                    board.set(6,0)
                    y++
                }
            }

            if(s[7] != '_'){
                move++
                if(s[7] == 'X'){
                    findViewById<ImageButton>(R.id.imageButton8).setImageResource(R.drawable.xoxo1)
                    board.set(7,1)
                    x++
                }
                else{
                    findViewById<ImageButton>(R.id.imageButton8).setImageResource(R.drawable.xoxo2)
                    board.set(7,0)
                    y++
                }
            }

            if(s[8] != '_'){
                move++
                if(s[8] == 'X'){
                    findViewById<ImageButton>(R.id.imageButton9).setImageResource(R.drawable.xoxo1)
                    board.set(8,1)
                    x++
                }
                else{
                    findViewById<ImageButton>(R.id.imageButton9).setImageResource(R.drawable.xoxo2)
                    board.set(8,0)
                    y++
                }
            }


            if(x>y){
                current_player="O"
            }
        }


        var a1 : String
        firebase.child("xoxoCount").get().addOnSuccessListener{
            Log.i("klawiatur", "Got value ${it.value}")
            a1 = "${it.value}"
            //a1= it.value as String
            //findViewById<TextView>(com.google.firebase.database.R.id.textViewZ).text = (a1.toInt()+1).toString()
            //increaseNOP(a1.toInt())
            //postPost(findViewById<TextView>(com.google.firebase.database.R.id.inputText).text.toString(),a1.toInt())
            //findViewById<TextView>(com.google.firebase.database.R.id.inputText).text = ""
            a1 = (a1.toInt() + 1).toString()

            firebase.child("xoxoCount").setValue(a1.toString())

        }.addOnFailureListener{
            Log.e("klawiatur", "Error getting data", it)
        }




    }

    fun click3_1(view: View) {
        if(board.get(0) == 2){
            val bnt: ImageButton = findViewById(R.id.imageButton)
            if(current_player == "X"){
                bnt.setImageResource(R.drawable.xoxo1)
                board.set(0,1)
            }
            else{
                bnt.setImageResource(R.drawable.xoxo2)
                board.set(0,0)
            }
            changePlayer()


        }
    }


    fun click3_2(view: View) {
        if(board.get(1) == 2){
            val bnt: ImageButton = findViewById(R.id.imageButton2)
            if(current_player == "X"){
                bnt.setImageResource(R.drawable.xoxo1)
                board.set(1,1)
            }
            else{
                bnt.setImageResource(R.drawable.xoxo2)
                board.set(1,0)
            }
            changePlayer()


        }

    }


    fun click3_3(view: View) {
        if(board.get(2) == 2){
            val bnt: ImageButton = findViewById(R.id.imageButton3)
            if(current_player == "X"){
                bnt.setImageResource(R.drawable.xoxo1)
                board.set(2,1)
            }
            else{
                bnt.setImageResource(R.drawable.xoxo2)
                board.set(2,0)
            }
            changePlayer()


        }
    }


    fun click3_4(view: View) {
        if(board.get(3) == 2){
            val bnt: ImageButton = findViewById(R.id.imageButton4)
            if(current_player == "X"){
                bnt.setImageResource(R.drawable.xoxo1)
                board.set(3,1)
            }
            else{
                bnt.setImageResource(R.drawable.xoxo2)
                board.set(3,0)
            }
            changePlayer()


        }
    }


    fun click3_5(view: View) {
        if(board.get(4) == 2){
            val bnt: ImageButton = findViewById(R.id.imageButton5)
            if(current_player == "X"){
                bnt.setImageResource(R.drawable.xoxo1)
                board.set(4,1)
            }
            else{
                bnt.setImageResource(R.drawable.xoxo2)
                board.set(4,0)
            }
            changePlayer()


        }
    }


    fun click3_6(view: View) {
        if(board.get(5) == 2){
            val bnt: ImageButton = findViewById(R.id.imageButton6)
            if(current_player == "X"){
                bnt.setImageResource(R.drawable.xoxo1)
                board.set(5,1)
            }
            else{
                bnt.setImageResource(R.drawable.xoxo2)
                board.set(5,0)
            }
            changePlayer()


        }
    }


    fun click3_7(view: View) {
        if(board.get(6) == 2){
            val bnt: ImageButton = findViewById(R.id.imageButton7)
            if(current_player == "X"){
                bnt.setImageResource(R.drawable.xoxo1)
                board.set(6,1)
            }
            else{
                bnt.setImageResource(R.drawable.xoxo2)
                board.set(6,0)
            }
            changePlayer()


        }
    }


    fun click3_8(view: View) {
        if(board.get(7) == 2){
            val bnt: ImageButton = findViewById(R.id.imageButton8)
            if(current_player == "X"){
                bnt.setImageResource(R.drawable.xoxo1)
                board.set(7,1)
            }
            else{
                bnt.setImageResource(R.drawable.xoxo2)
                board.set(7,0)
            }
            changePlayer()


        }
    }


    fun click3_9(view: View) {
        if(board.get(8) == 2){
            val bnt: ImageButton = findViewById(R.id.imageButton9)
            if(current_player == "X"){
                bnt.setImageResource(R.drawable.xoxo1)
                board.set(8,1)
            }
            else{
                bnt.setImageResource(R.drawable.xoxo2)
                board.set(8,0)
            }
            changePlayer()


        }
    }




    fun sendWinner(view: View) {


        GlobalScope.launch {
            try {
                database = Room.databaseBuilder(
                    applicationContext,
                    SimpleXOXODatabase::class.java,
                    "SimpleXOXOtable.db"
                ).build()
            }catch (e: Exception){
                Log.d("am2021","base")
                finish()
            }

            database.SimpleXOXOEntDAO().delete()
            move=0;

            for (i in 0..8){
                board[i] = 2
            }
            findViewById<ImageButton>(R.id.imageButton).setImageResource(R.drawable.xoxo3)
            findViewById<ImageButton>(R.id.imageButton2).setImageResource(R.drawable.xoxo3)
            findViewById<ImageButton>(R.id.imageButton3).setImageResource(R.drawable.xoxo3)
            findViewById<ImageButton>(R.id.imageButton4).setImageResource(R.drawable.xoxo3)
            findViewById<ImageButton>(R.id.imageButton5).setImageResource(R.drawable.xoxo3)
            findViewById<ImageButton>(R.id.imageButton6).setImageResource(R.drawable.xoxo3)
            findViewById<ImageButton>(R.id.imageButton7).setImageResource(R.drawable.xoxo3)
            findViewById<ImageButton>(R.id.imageButton8).setImageResource(R.drawable.xoxo3)
            findViewById<ImageButton>(R.id.imageButton9).setImageResource(R.drawable.xoxo3)



        }
    }

    fun checkWinner(){
        if(won){
            return
        }

        for(i in 0..2){

            if(board.get(0+i*3) != 2 && board.get(0+i*3) == board.get(1+i*3) && board.get(1+i*3) == board.get(2+i*3)){
                setWinner()
                return
            }
            if(board.get(0+i) != 2 && board.get(0+i) == board.get(3+i) && board.get(3+i) == board.get(6+i)){
                setWinner()
                return
            }
        }


        if(board.get(4) == 2){
            return;
        }
        if(board.get(0) == board.get(4) && board.get(4) == board.get(8)){
            setWinner()
            return
        }
        if(board.get(2) == board.get(4) && board.get(4) == board.get(6)){
            setWinner()
            return
        }

    }

    fun setWinner(){
        winner=current_player
        won = true
        Toast.makeText(this,"!!!WIN!!!", Toast.LENGTH_SHORT).show()
    }


    fun changePlayer(){

        if(current_player == "X"){
            checkWinner()
            current_player = "O"
        }
        else{
            checkWinner()
            current_player = "X"
        }

        GlobalScope.launch {
            try {
                database = Room.databaseBuilder(
                    applicationContext,
                    SimpleXOXODatabase::class.java,
                    "SimpleXOXOtable.db"
                ).build()
            }catch (e: Exception){
                Log.d("am2021","base")
                finish()
            }
            var s = ""

            for (i in 0..8){
                if(board.get(i)==2)
                    s += "_"
                if(board.get(i)==1)
                    s += "X"
                if(board.get(i)==0)
                    s += "O"
            }

            database.SimpleXOXOEntDAO().insertAll(SimpleXOXOEnt(move.toLong(),s))
            move++

        }
        //database.SimpleXOXOEntDAO().insertAll(SimpleXOXOEnt(move.toLong(),"XXXOOO"))


    }
}