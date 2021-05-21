package com.example.mobilne

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SimpleXOXO : AppCompatActivity() {
    private var board = arrayOf(2,2,2,2,2,2,2,2,2)
    private var current_player = "X"
    private var won = false
    private var winner = "Z"
    private lateinit var database : SimpleXOXODatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_x_o_x_o)




        try {
            database = Room.databaseBuilder(
                this,
                SimpleXOXODatabase::class.java,
                "SimpleXOXOtable.db"
            ).build()
        }catch (e: Exception){

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
        if(won){
            changePlayer()
            val myintent = Intent()
            myintent.putExtra("msgR",current_player)
            setResult(RESULT_OK,myintent)
        }

        finish()
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
    }
}