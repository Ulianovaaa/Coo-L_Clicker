package com.izzzya.coo_lclicker

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.izzzya.coo_lclicker.classes.SharedPref


class ShopFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val seedsTV = view.findViewById<TextView>(R.id.seedsQTV)
        val street1 = view.findViewById<ImageView>(R.id.street1IV)
        val street2 = view.findViewById<ImageView>(R.id.street2IV)
        val forest1 = view.findViewById<ImageView>(R.id.forest1IV)
        val forest2 = view.findViewById<ImageView>(R.id.forest2IV)
        val beach = view.findViewById<ImageView>(R.id.beachIV)
        var seeds = SharedPref.getSeeds()

        seedsTV.text = seeds.toString()

        street1.tag = 1
        street2.tag = 2
        forest1.tag = 3
        forest2.tag = 4
        beach.tag = 5


        view.findViewById<ImageView>(R.id.backBtn).setOnClickListener {
            findNavController().popBackStack()
        }

        fun changeBG() {
            val res = when(SharedPref.getLocation()){
                1->R.drawable.street
                2->R.drawable.street2
                3->R.drawable.forest
                4->R.drawable.forest2
                5->R.drawable.beach
                else -> R.drawable.street
            }
            requireActivity().findViewById<ImageView>(R.id.bgIV).setImageResource(res)
        }

        fun setOnClick(target: ImageView, cost: Int){
            target.setOnClickListener {
                val locations = SharedPref.getLocationS().toString()
                //покупка и применение
                if ((seeds-cost>=0)&&(!locations.contains(target.tag.toString()))){
                    val builder = AlertDialog.Builder(requireContext())
                    builder.setTitle("Go to this location?")
                    builder.setMessage("Seeds cost: $cost")
                    builder.setPositiveButton("yes") { dialog, which ->
                        seeds-=cost
                        seedsTV.text = seeds.toString()
                        SharedPref.setSeeds(seeds)

                        SharedPref.setLocation(target.tag as Int)
                        changeBG()

                        var locs = SharedPref.getLocationS()
                        Log.i("LOCATIONS OPEN:", locs.toString())
                        locs = (locs*10)+(target.tag as Int)
                        Log.i("LOCATIONS OPEN:", locs.toString())
                        SharedPref.setLocationS(locs)
                    }

                    builder.setNegativeButton("no") { dialog, which ->

                    }
                    builder.show()
                //просто применение
                } else if (locations.contains(target.tag.toString())){
                    SharedPref.setLocation(target.tag as Int)
                    changeBG()
                //не хватило деняк
                }else{
                    Toast.makeText(requireContext(), "Need more seeds! Cost: $cost", Toast.LENGTH_SHORT).show()
                }

            }
        }


        setOnClick(street1, 0)
        setOnClick(street2, 200)
        setOnClick(forest1, 500)
        setOnClick(forest2, 1000)
        setOnClick(beach, 5000)
    }

}