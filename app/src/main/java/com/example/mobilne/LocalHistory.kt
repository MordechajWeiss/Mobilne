package com.example.mobilne

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LocalHistory : AppCompatActivity() {

    private lateinit var database : SimpleXOXODatabase
    private lateinit var list : List<SimpleXOXOEnt>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_history)
        val textView = findViewById<TextView>(R.id.localHistoryText)

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
        }

        Thread.sleep(1000)
        for (i in 0..list.size-1){
            var s = list.get(i).board.toString()


            textView.text = textView.text.toString() + "\n\n"
            textView.text = textView.text.toString() + s[0] + " | " + s[1] + " | " + s[2] + "\n"
            //textView.text = textView.text.toString() + "---------\n"
            textView.text = textView.text.toString() + s[3] + " | " + s[4] + " | " + s[5] + "\n"
            //textView.text = textView.text.toString() + "---------\n"
            textView.text = textView.text.toString() + s[6] + " | " + s[7] + " | " + s[8] + "\n"



        }



    }
}


