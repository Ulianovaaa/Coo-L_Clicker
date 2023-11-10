package com.izzzya.coo_lclicker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class WebFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val wv = view.findViewById<WebView>(R.id.webView)
        wv.webViewClient = WebViewClient()
        wv.settings.javaScriptEnabled = true
        wv.settings.javaScriptCanOpenWindowsAutomatically = true
        wv.settings.pluginState = WebSettings.PluginState.ON
        wv.settings.mediaPlaybackRequiresUserGesture = false
        wv.webChromeClient = WebChromeClient()
        //rickroll
//        wv.loadUrl("https://youtu.be/dQw4w9WgXcQ")
        wv.loadUrl("https://youtu.be/iihBNVog3jI")
    }

}