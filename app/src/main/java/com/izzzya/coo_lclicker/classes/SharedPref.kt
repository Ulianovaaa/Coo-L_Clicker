package com.izzzya.coo_lclicker.classes

import android.content.Context
import android.content.SharedPreferences

class SharedPref(context: Context) {
    init {
        sharedPref = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)

    }

    companion object{
        private var sharedPref: SharedPreferences? = null
        const val PREFERENCES = "prefs"
        const val PLAY_MUSIC = false
        const val SEEDS = 0
        const val LOCATION = 0
        const val LOCATIONS_OPEN = 1 //12345 - число которое по разрядам показывает какие локации открыты


        fun setMusic(m: Boolean){
            sharedPref?.edit()
                ?.putBoolean("PLAY_MUSIC", m)
                ?.apply()
        }

        fun getMusic(): Boolean{
            return sharedPref!!.getBoolean("PLAY_MUSIC", false)
        }

        fun setSeeds(s: Int){
            sharedPref?.edit()
                ?.putInt("SEEDS", s)
                ?.apply()
        }

        fun getSeeds(): Int{
            return sharedPref!!.getInt("SEEDS", 0)
        }

        fun setLocation(l: Int){
            sharedPref?.edit()
                ?.putInt("LOCATION", l)
                ?.apply()
        }

        fun getLocation(): Int{
            return sharedPref!!.getInt("LOCATION", 1)
        }

        fun setLocationS(ls: Int){
            sharedPref?.edit()
                ?.putInt("LOCATIONS_OPEN", ls)
                ?.apply()
        }

        fun getLocationS(): Int{
            return sharedPref!!.getInt("LOCATIONS_OPEN", 1)
        }


    }
}