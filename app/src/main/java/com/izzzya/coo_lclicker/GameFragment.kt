package com.izzzya.coo_lclicker

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.izzzya.coo_lclicker.classes.Player
import com.izzzya.coo_lclicker.classes.SharedPref

class GameFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val musicBtn = view.findViewById<ImageView>(R.id.musicBttn)
        val shopBtn = view.findViewById<ImageView>(R.id.storeBtn)
        val pigeon = view.findViewById<ImageView>(R.id.pigeonIV)
        val seed = view.findViewById<ImageView>(R.id.seedIV)
        val seedsTV = view.findViewById<TextView>(R.id.seedsTV)
        Log.i("SP SEEDS: ", SharedPref.getSeeds().toString())
        var seeds = SharedPref.getSeeds()

        seedsTV.text = seeds.toString()

        shopBtn.setOnClickListener {
            findNavController().navigate(R.id.action_global_shopFragment)
        }

        if (SharedPref.getMusic()){
            musicBtn.alpha = 1f
        } else musicBtn.alpha =0.5f

        musicBtn.setOnClickListener {
            if (SharedPref.getMusic()){
                Player.musicPause()
                SharedPref.setMusic(false)
                musicBtn.alpha = 0.5f
            } else {
                SharedPref.setMusic(true)
//                Log.i("SP MUSIC: ", SharedPref.getMusic().toString())
                Player.musicPlay()
                musicBtn.alpha = 1f
                }
            }

        pigeon.setOnClickListener {
            when(pigeon.scaleX){
                1f -> pigeon.scaleX = -1f
                -1f -> pigeon.scaleX = 1f
            }
            seed.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.fade_slide_up))
            seeds += 10
            seedsTV.text = seeds.toString()
            SharedPref.setSeeds(seeds)
        }


        }
    }

