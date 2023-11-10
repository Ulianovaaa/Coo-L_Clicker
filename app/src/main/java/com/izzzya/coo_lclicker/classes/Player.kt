package com.izzzya.coo_lclicker.classes

import android.content.Context
import android.media.MediaPlayer
import com.izzzya.coo_lclicker.R

class Player(context: Context) {

    init {
        player = MediaPlayer.create(context, R.raw.music)

    }

    companion object{
        var player: MediaPlayer? = null

        fun musicPlay(){
            if (SharedPref.getMusic()){
            player?.start()
            }
        }

        fun musicPause(){
            player?.pause()
        }

    }
}