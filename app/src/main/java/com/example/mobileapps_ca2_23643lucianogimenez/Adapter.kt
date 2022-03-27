package com.example.mobileapps_ca2_23643lucianogimenez

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class Adapter (private val movieList : ArrayList<Movie>):RecyclerView.Adapter<Adapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = movieList[position]
        holder.image.setImageResource(currentItem.image)
        holder.name.text = currentItem.name
    }

    override fun getItemCount(): Int {
        return movieList.size

    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.name)
        val image : ShapeableImageView = itemView.findViewById(R.id.image)
        val certification : TextView = itemView.findViewById(R.id.certification)
        val starring : TextView = itemView.findViewById(R.id.starring)
        val running_time_mins : TextView = itemView.findViewById(R.id.running_time_mins)
        val seats_remaining : TextView = itemView.findViewById(R.id.seats_remaining)
    }

}