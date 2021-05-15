package com.example.mobilne

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class CustomAdapter(private var data: Vector<GameItem>,var mContext: Context) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textViewName: TextView
        val textViewDesc: TextView
        val picView: ImageView


        init {


            textViewName = view.findViewById(R.id.gameName)
            textViewDesc = view.findViewById(R.id.gameDesc)
            picView = view.findViewById(R.id.gameIcon)



            view.setOnClickListener{
                //view.context
                //Toast.makeText(view.context,"position" + layoutPosition, Toast.LENGTH_SHORT ).show()
                //data[layoutPosition].desc="Cezar"
                //notifyDataSetChanged()


                //val myintent = Intent(view.context,GameActivity1::class.java)
                //view.context.startActivity(myintent)
                openActivity(data[layoutPosition].id)
               // startActivityForResult(mContext,"123")
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_itemgame_view,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.textView.text = data.get(position).diff.toString()

        val line = data.get(position)
        when(line.id){
            1 -> {
                holder.picView.setImageResource(R.drawable.g1)
            }
            2 -> {
                holder.picView.setImageResource(R.drawable.g2)
            }
            3 -> {
                holder.picView.setImageResource(R.drawable.g3)
            }
            else -> {
                holder.picView.setImageResource(R.drawable.g0)
            }
        }

     holder.textViewName.text = data.get(position).name
     holder.textViewDesc.text = data.get(position).desc





     }

    override fun getItemCount(): Int {
        return data.size;
    }

    public fun openActivity(id: Int){
        when(id){
            1 -> {
                val myintent = Intent(mContext, GameActivity1::class.java)  //fixed error with unrecognised reference: java
                myintent.putExtra("name1",data[id].desc)
                //mContext.startActivity(myintent)
                //mContext.startActivityForResult(myintent,"12")
                //context.startAc
                val activity = mContext as Activity
                startActivityForResult( activity,myintent,123,null)

            }
            2 -> {
                val myintent = Intent(mContext,GameActivity2::class.java)
                mContext.startActivity(myintent)
            }
            3 -> {
                val myintent = Intent(mContext,GameActivity3::class.java)
                mContext.startActivity(myintent)
            }
            else -> {
                Toast.makeText(mContext,"position" + id, Toast.LENGTH_SHORT ).show()
            }

        }
    }
}

