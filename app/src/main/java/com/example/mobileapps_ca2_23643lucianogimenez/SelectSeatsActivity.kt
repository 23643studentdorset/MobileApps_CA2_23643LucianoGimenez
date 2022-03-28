package com.example.mobileapps_ca2_23643lucianogimenez

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class SelectSeatsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_seats)

        val name : TextView = findViewById(R.id.name)
        val image : ImageView = findViewById(R.id.image)
        val certification : ImageView = findViewById(R.id.certification)
        val description : TextView = findViewById(R.id.description)
        val starring : TextView = findViewById(R.id.starring)
        val running_time_mins : TextView = findViewById(R.id.running_time_mins)
        val seats_remaining : TextView = findViewById(R.id.seats_remaining)
        val seats_selected : TextView = findViewById(R.id.selected_seats)

        val bundle : Bundle ?= intent.extras
        val nameId = bundle!!.getString("name")
        val imageId = bundle!!.getInt("image")
        val certificationId = bundle!!.getInt("certification")
        val descriptionId = bundle!!.getString("description")
        val starringId = bundle!!.getString("starring")
        val runningTimeMinsId = bundle!!.getInt("running_time_mins")
        val seatsRemainingId = bundle!!.getInt("seats_remaining")
        val seatsSelectedId = bundle!!.getInt("seats_selected")

        name.text = nameId
        image.setImageResource(imageId)
        certification.setImageResource(certificationId)
        description.text = descriptionId
        starring.text = starringId
        running_time_mins.text = runningTimeMinsId.toString()
        seats_remaining.text = seatsRemainingId.toString()
        seats_selected.text = seatsSelectedId.toString()
    }
}