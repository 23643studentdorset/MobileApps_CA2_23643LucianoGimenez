package com.example.mobileapps_ca2_23643lucianogimenez

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class Adapter (private val movieList : ArrayList<Movie>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType : Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView, mListener)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onBindViewHolder(holder : MyViewHolder, position: Int) {
        val currentItem = movieList[position]
        holder.image.setImageResource(currentItem.image)
        holder.name.text = currentItem.name
        holder.certification.setImageResource(currentItem.certification.toInt())
        holder.starring.text = currentItem.starring
        holder.runningTimeMins.text = currentItem.running_time_mins.toString()
        holder.seatsRemaining.text = currentItem.seats_remaining.toString()

    }

    override fun getItemCount() : Int {
        return movieList.size

    }

    class MyViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.name)
        val image : ShapeableImageView = itemView.findViewById(R.id.image)
        val certification : ShapeableImageView = itemView.findViewById(R.id.certification)
        val starring : TextView = itemView.findViewById(R.id.starring)
        val runningTimeMins : TextView = itemView.findViewById(R.id.running_time_mins)
        val seatsRemaining : TextView = itemView.findViewById(R.id.seats_remaining)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

}