package com.note.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.fragment.app.Fragment
import com.note.myapplication.R

class FragmentOne:  Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val myWebView = this.activity!!.findViewById<WebView>(R.id.webViewContainer)
        myWebView.settings.javaScriptEnabled = true
        myWebView.settings.setAppCacheEnabled(true)
        myWebView.settings.domStorageEnabled = true
        myWebView.settings.javaScriptCanOpenWindowsAutomatically= true
        myWebView.settings.setSupportZoom(false)
        myWebView.settings.displayZoomControls = false
        myWebView.settings.builtInZoomControls = false
        myWebView.settings.setGeolocationEnabled(true)
        myWebView.webChromeClient = WebChromeClientSystem()
        myWebView.webViewClient = WebViewClientSystem()
        myWebView.loadUrl("https://www.google.com/")

        val button = this.activity!!.findViewById<Button>(R.id.navigation)

        button.setOnClickListener {
            val transaction = this.activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, FragmentTwo())
            transaction?.commit()
        }
    }
}

class WebViewClientSystem : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        view.loadUrl(url)
        return true
    }
}

class WebChromeClientSystem : WebChromeClient() {

}