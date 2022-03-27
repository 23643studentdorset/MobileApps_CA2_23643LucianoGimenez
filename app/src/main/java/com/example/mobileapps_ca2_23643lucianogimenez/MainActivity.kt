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

        nameInfo = arrayOf("The Batman", "Sonic 2", "The Secrets of Dumbledore", "Maze", "Uncharted")
        imageInfo = arrayOf(R.drawable.batman, R.drawable.sonic2, R.drawable.dumbledor, R.drawable.maze, R.drawable.uncharted)
        certificationInfo = arrayOf(R.drawable.a15, R.drawable.pg, R.drawable.a12, R.drawable.a15, R.drawable.a12)
        descriptionInfo = arrayOf(
            "From Warner Bros. Pictures comes \"The Batman,\" with director Matt Reeves (the \"Planet of the Apes\" films) at the helm and with Robert Pattinson (\"Tenet,\" \"The Lighthouse,\" \"Good Time\") starring as Gotham City's vigilante detective, Batman.",
            "After settling in Green Hills, Sonic is eager to prove he has what it takes to be a true hero. His test comes when Dr. Robotnik returns, this time with a new partner, Knuckles, in search for an emerald that has the power to destroy civilizations.",
            "Unable to stop the powerful Dark wizard Gellert Grindelwald alone, Professor Albus Dumbledore entrusts Magizoologist Newt Scamander to lead an intrepid team of wizards, witches and one brave Muggle baker on a dangerous mission.",
            "Inspired by the true events of the infamous 1983 prison breakout of 38 IRA prisoners from HMP, which was to become the biggest prison escape in Europe since World War II.",
            "Street-smart Nathan Drake (Tom Holland) is recruited by seasoned treasure hunter Victor \"Sully\" Sullivan (Mark Wahlberg) to recover a fortune amassed by Ferdinand Magellan and lost 500 years ago by the House of Moncada."
        )
        starringInfo = arrayOf(
            "Robert Pattinson, Zoe Kravitz, Paul Dano, Colin Farrell",
            "James Marsden, Ben Schwartz",
            "Eddie Redmayne, Jude Law, Ezra Miller, Alison Sudol, Dan Fogler, Mads Mikkelsen",
            "Tom Vaughan-Lawlor, Barry Ward, Martin McCann, Eileen Walsh",
            "Tom Holland, Mark Wahlberg, Antonio Banderas",
        )
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
            val movie = Movie (nameInfo[i], imageInfo[i], certificationInfo[i], descriptionInfo[i], starringInfo[i],
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