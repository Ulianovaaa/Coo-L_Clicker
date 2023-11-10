package com.izzzya.coo_lclicker

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.telephony.TelephonyManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.beginBtn).setOnClickListener{
            //сюда впиндюрить проверку на инет и на сим-карту
            if (isSIMCardPresent()&&isOnline()){
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Coo there")
                builder.setMessage("You wanna Enter?")
                builder.setPositiveButton("yes") { dialog, which ->
                    findNavController().navigate(R.id.action_global_webFragment)
                }

                builder.setNegativeButton("no") { dialog, which ->
                    requireActivity().finish()
                }

                builder.setNeutralButton("LET ME PLAY THE GAME!!") { dialog, which ->
                    findNavController().navigate(R.id.action_global_gameFragment)
                }
                builder.show()
            }else
            findNavController().navigate(R.id.action_global_gameFragment)
        }
//        view.findViewById<Button>(R.id.beginBtn).setOnLongClickListener {
//            findNavController().navigate(R.id.action_global_webFragment)
//           true
//        }
    }

    private fun isOnline(): Boolean {
        val connectivityManager = requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return !(networkInfo == null || !networkInfo.isConnected)
    }


    private fun isSIMCardPresent(): Boolean {
        val telephonyManager = requireContext().getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        return telephonyManager.simState == TelephonyManager.SIM_STATE_READY
    }


}