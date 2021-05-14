package com.example.mobilne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        recyclerview.adapter = CustomAdapter(generateData())

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
            data.addElement(GameItem(i, "name - $i", "Gallia est omnis divisa in partes tres, quarum unam incolunt Belgae, aliam Aquitani, tertiam qui ipsorum lingua Celtae, nostra Galli appellantur. $i"))
        }
        return data
    }
}