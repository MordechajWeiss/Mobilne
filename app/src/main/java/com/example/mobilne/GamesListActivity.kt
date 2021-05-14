package com.example.mobilne

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class GamesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games_list)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerGames)

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = CustomAdapter(generateData(),this)

        recyclerview.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerview.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerview.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerview.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerview.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerview.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerview.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerview.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
    }

    fun generateData() : Vector<GameItem>{
        var data : Vector<GameItem> = Vector();
        for (i in 0..100){
            data.addElement(GameItem(i, "name - $i", "Gallia est omnis divisa in partes tres, quarum unam incolunt Belgae, aliam Aquitani, tertiam qui ipsorum lingua Celtae, nostra Galli appellantur. $i"),)
        }
        return data
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val name = data?.getStringExtra("returnGame1")
        Toast.makeText(this,"Dostałem $name",Toast.LENGTH_SHORT).show()
    }


    fun a() {
        //val myintent = Intent(this,GameActivity1::class.java)
        //myintent.putExtra("name1",data[id].desc)
        //mContext.startActivity(myintent)
        //mContext.startActivityForResult(myintent,"12")
        //context.startAc
        //ActivityCompat.startActivityForResult(this, myintent, 123)
    }
}