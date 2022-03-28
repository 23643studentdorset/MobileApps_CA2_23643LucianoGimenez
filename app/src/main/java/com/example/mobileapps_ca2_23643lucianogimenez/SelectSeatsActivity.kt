package com.example.mobileapps_ca2_23643lucianogimenez

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.properties.Delegates


class SelectSeatsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_seats)

        val name : TextView = findViewById(R.id.name)
        val image : ImageView = findViewById(R.id.image)
        val certification : ImageView = findViewById(R.id.certification)
        val description : TextView = findViewById(R.id.description)
        val starring : TextView = findViewById(R.id.starring)
        val runningTimeMins : TextView = findViewById(R.id.running_time_mins)
        var seatsRemaining : TextView = findViewById(R.id.seats_remaining)
        var seatsSelected : TextView = findViewById(R.id.selected_seats)

        val bundle : Bundle ?= intent.extras
        val nameId = bundle!!.getString("name")
        val imageId = bundle.getInt("image")
        val certificationId = bundle.getInt("certification")
        val descriptionId = bundle.getString("description")
        val starringId = bundle.getString("starring")
        val runningTimeMinsId = bundle.getInt("running_time_mins")
        var seatsRemainingId = bundle.getInt("seats_remaining")
        var seatsSelectedId = bundle.getInt("seats_selected")

        name.text = nameId
        image.setImageResource(imageId)
        certification.setImageResource(certificationId)
        description.text = descriptionId
        starring.text = starringId
        runningTimeMins.text = runningTimeMinsId.toString()
        seatsRemaining.text = seatsRemainingId.toString()
        seatsSelected.text = seatsSelectedId.toString()


        findViewById<ImageView>(R.id.plus).setOnClickListener{
            if (seatsSelectedId < seatsRemainingId){
                seatsSelectedId += 1
                seatsSelected.text = seatsSelectedId.toString()
                //seats = seatsSelectedId
                //Log.i("lucho", "seats: $seats")
                findViewById<ImageView>(R.id.minus).isEnabled = true
                findViewById<ImageView>(R.id.minus).setColorFilter(resources.getColor(R.color.grey))
            }
            if(seatsSelectedId == seatsRemainingId){
                findViewById<ImageView>(R.id.plus).isEnabled = false
                findViewById<ImageView>(R.id.plus).setColorFilter(resources.getColor(R.color.red))
            }
        }
        findViewById<ImageView>(R.id.minus).setOnClickListener{
            if (seatsSelectedId > 0){
                seatsSelectedId -= 1
                //seats = seatsSelectedId
                //Log.i("lucho", "seats: $seats")
                seatsSelected.text = seatsSelectedId.toString()
                findViewById<ImageView>(R.id.plus).isEnabled = true
                findViewById<ImageView>(R.id.plus).setColorFilter(resources.getColor(R.color.grey))

            }
            if(seatsSelectedId == 0){
                findViewById<ImageView>(R.id.minus).isEnabled = false
                findViewById<ImageView>(R.id.minus).setColorFilter(resources.getColor(R.color.red))
            }
        }

    }
    //override fun onDestroy() {
      //  super.onDestroy()
      //  Log.i("lucho", "seats: $seats")
      //  val intent = Intent(this, MainActivity::class.java)
      //  intent.putExtra("seatsSelectedId", seats)
      //  Log.i("lucho", "onDestroy called")
      //  finish()
    //}
}