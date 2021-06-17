package com.example.mobilne

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
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

        val layout = findViewById<View>(R.id.l2) as LinearLayout

        if(list.isNotEmpty())
        {
            var param = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
            param.bottomMargin=18;
            var newTV = TextView(this);
            newTV.layoutParams = param;
            newTV.text = "Mystery number: " + list.get(0).move.toString();
            newTV.setTextColor(Color.WHITE);
            newTV.textSize= 36F;
            layout.addView(newTV)

            for(i in (1 until list.size))
            {
                var param = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
                param.bottomMargin=10;

                newTV = TextView(this);
                newTV.layoutParams = param;
                newTV.text = "Guess no."+ i +" : " + list.get(i).move.toString();
                newTV.setTextColor(Color.WHITE);
                newTV.textSize= 32F;
                layout.addView(newTV);
            }
        }


    }
}