package com.izzzya.coo_lclicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.izzzya.coo_lclicker.classes.Player
import com.izzzya.coo_lclicker.classes.SharedPref

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SharedPref(this)
        Player(this)

        val res = when(SharedPref.getLocation()){
                1->R.drawable.street
                2->R.drawable.street2
                3->R.drawable.forest
                4->R.drawable.forest2
                5->R.drawable.beach
                else -> R.drawable.street
            }
            findViewById<ImageView>(R.id.bgIV).setImageResource(res)

    }


    override fun onPause() {
        super.onPause()
        Player.musicPause()
    }

    override fun onResume() {
        super.onResume()
        Log.i("SP MUSIC:", SharedPref.getMusic().toString())
        Player.musicPlay()
    }
}