package com.example.mobilne

import android.app.ActionBar
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.GridLayout
import android.widget.GridView
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginBottom
import androidx.room.Room
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class LocalHistory : AppCompatActivity() {

    private lateinit var database : SimpleXOXODatabase
    private lateinit var list : List<SimpleXOXOEnt>
    var TAG = "2021"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_history)

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


        val firebase = Firebase.database
        val myRef = firebase.getReference("xoxoCount")
        //myRef.setValue(1)

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<String>()
                //Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })


        val layout = findViewById<View>(R.id.l1) as LinearLayout

        for (i in 0..list.size-1){
            var s = list.get(i).board.toString()

            var newGrid = GridLayout(this)
            println("aa")




            //val par = newGrid.layoutParams
            //par.width = layout.width / layout.columnCount
            //newGrid.layoutParams = par
            newGrid.columnCount=3;
            newGrid.rowCount=3;


            for(j in 0..8)
            {
                var iv = ImageView(this);
                when (s[j].toString())
                {
                    "X" -> iv.setImageResource(R.drawable.xoxo1)
                    "O" -> iv.setImageResource(R.drawable.xoxo2)
                    else -> iv.setImageResource(R.drawable.xoxo3)
                }
                newGrid.addView(iv)
            }
            val params = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            params.bottomMargin=120;
            newGrid.layoutParams=params;

            layout.addView(newGrid)

        }



    }
}


