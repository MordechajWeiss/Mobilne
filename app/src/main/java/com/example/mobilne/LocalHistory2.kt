package com.example.mobilne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LocalHistory2 : AppCompatActivity() {
    private lateinit var database : NumberDatabase
    private lateinit var list : List<NumberEnt>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_history2)


        GlobalScope.launch {
            try {
                database = Room.databaseBuilder(
                    applicationContext,
                    NumberDatabase::class.java,
                    "NumberTable.db"
                ).build()
            }catch (e: Exception){
                Log.d("am2021","base")
                finish()
            }
            list = database.NumberDAO().getAll()




            //for(i in 0..list.size-1){
                //textView.text = textView.text.toString() + "\n aa"
            //}
        }
        Thread.sleep(1000)

        var textView = findViewById<TextView>(R.id.LH2_TV_TMP)

        if(list.isNotEmpty()){
                textView.text = textView.text.toString() + "\nMystery number: " + list.get(0).move.toString()
            for(i in 1..list.size-1){
                textView.text = textView.text.toString() + "\nMove: " + list.get(i).move.toString()
            }
        }


    }
}