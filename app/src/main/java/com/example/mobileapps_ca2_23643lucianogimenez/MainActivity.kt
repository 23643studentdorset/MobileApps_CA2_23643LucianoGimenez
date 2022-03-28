package com.example.mobileapps_ca2_23643lucianogimenez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        seatsSelectedInfo = arrayOf(0, 0, 0, 0, 0)

        newRecyclerView = findViewById(R.id.recycler_view)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArraylist = arrayListOf<Movie>()
        getData()
    }

    private fun getData() {
        for(i in nameInfo.indices){
            val movie = Movie (nameInfo[i], imageInfo[i], certificationInfo[i].toString(), descriptionInfo[i], starringInfo[i],
                runningTimeMinsInfo[i] ,seatsRemainingInfo[i], seatsSelectedInfo[i])
                newArraylist.add(movie)
        }
        newRecyclerView.adapter = Adapter(newArraylist)
    }

    private fun rand(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        return (Math.random() * (end - start + 1)).toInt() + start
    }
}