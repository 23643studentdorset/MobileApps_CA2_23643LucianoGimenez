package com.example.mobileapps_ca2_23643lucianogimenez

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.Constructor
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView : RecyclerView
    private lateinit var newArraylist : ArrayList<Movie>
    lateinit var nameInfo : Array<String>
    lateinit var imageInfo : Array<Int>
    lateinit var certificationInfo : Array<Int>
    lateinit var descriptionInfo : Array<String>
    lateinit var starringInfo : Array<String>
    lateinit var runningTimeMinsInfo : Array<Int>
    lateinit var seatsRemainingInfo : Array<Int>
    lateinit var seatsSelectedInfo : Array<Int>
    var position by Delegates.notNull<Int>()
    //var seats by Delegates.notNull<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seatsSelectedInfo = arrayOf(0, 0, 0, 0, 0)

        nameInfo = arrayOf(
            getString(R.string.name1), getString(R.string.name2), getString(R.string.name3),
            getString(R.string.name4), getString(R.string.name5))

        imageInfo = arrayOf(
            R.drawable.batman, R.drawable.sonic2, R.drawable.dumbledor,
            R.drawable.maze, R.drawable.uncharted)

        certificationInfo = arrayOf(
            R.drawable.a15, R.drawable.pg, R.drawable.a12,
            R.drawable.a15, R.drawable.a12)

        descriptionInfo = arrayOf(
            getString(R.string.description1),getString(R.string.description2),getString(R.string.description3),
            getString(R.string.description4), getString(R.string.description5))

        starringInfo = arrayOf(
            getString(R.string.starring1), getString(R.string.starring2), getString(R.string.starring3),
            getString(R.string.starring4), getString(R.string.starring5))

        runningTimeMinsInfo = arrayOf(175, 122, 144, 92, 116)
        seatsRemainingInfo = arrayOf(rand(0,15), rand(0,15), rand(0,15), rand(0,15), rand(0,15),)


        newRecyclerView = findViewById(R.id.recycler_view)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArraylist = arrayListOf<Movie>()
        getData()


    }

    private fun getData() {
        for(i in nameInfo.indices){
            val movie = Movie (
                nameInfo[i], imageInfo[i], certificationInfo[i].toString(), descriptionInfo[i],
                starringInfo[i], runningTimeMinsInfo[i] ,seatsRemainingInfo[i], seatsSelectedInfo[i])
            newArraylist.add(movie)
        }
        var adapter = Adapter(newArraylist)
        newRecyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : Adapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, SelectSeatsActivity::class.java)
                intent.putExtra("name", nameInfo[position])
                intent.putExtra("image", imageInfo[position])
                intent.putExtra("certification", certificationInfo[position])
                intent.putExtra("description", descriptionInfo[position])
                intent.putExtra("starring", starringInfo[position])
                intent.putExtra("running_time_mins", runningTimeMinsInfo[position])
                intent.putExtra("seats_remaining", seatsRemainingInfo[position])
                intent.putExtra("seats_selected", seatsSelectedInfo[position])
                this@MainActivity.position = position
                startActivity(intent)
            }
        })

    }

    override fun onRestart() {
        super.onRestart()
        val bundle : Bundle ?= intent.extras
        //bundle?.getInt("seats")
        //Log.i("lucho", "seats: $seats")
    }

    private fun rand(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        return (Math.random() * (end - start + 1)).toInt() + start
    }
    private fun runningTimeHours(runningTimeHours: Int): Int {
        return runningTimeHours / 60
    }
    private fun runningTimeMin(runningTimeMins: Int): Int{
        return runningTimeMins % 60
    }
}