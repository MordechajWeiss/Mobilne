package com.example.mobilne

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class CustomAdapter(private var data: Vector<GameItem>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){


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
                data[layoutPosition].desc="Cezar"
                notifyDataSetChanged()


                //val myintent = Intent(view.context,GameActivity1::class.java)
                //view.context.startActivity(myintent)
                openActivity(data[layoutPosition].id,view.context)

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

    public fun openActivity(id: Int, context: Context){
        when(id){
            1 -> {
                val myintent = Intent(context,GameActivity1::class.java)
                context.startActivity(myintent)
            }
            2 -> {
                val myintent = Intent(context,GameActivity2::class.java)
                context.startActivity(myintent)
            }
            3 -> {
                val myintent = Intent(context,GameActivity3::class.java)
                context.startActivity(myintent)
            }
            else -> {
                Toast.makeText(context,"position" + id, Toast.LENGTH_SHORT ).show()
            }

        }
    }
}

