package com.example.chsamirkrishna.webviewtest

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var et1:EditText?=null
    var wview:WebView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wview=findViewById(R.id.wview)
        et1=findViewById(R.id.et1)
        wview?.webViewClient=WebViewClient()
        wview?.settings?.javaScriptEnabled=true
        wview?.settings?.builtInZoomControls=true
        wview?.webViewClient= object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                Toast.makeText(this@MainActivity,"Page is Loading",Toast.LENGTH_SHORT).show()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                Toast.makeText(this@MainActivity,"Page loading is Finished",Toast.LENGTH_LONG).show()
            }
        }
    }
    fun load(v:View)
    {
        when(v.id){
            R.id.search->wview?.loadUrl(et1?.getText().toString())
            R.id.google->wview?.loadUrl("http://www.google.com")
            R.id.facebook->wview?.loadUrl("http://www.facebook.com")
            R.id.youtube->wview?.loadUrl("http://www.youtube.com")
            R.id.html->wview?.loadUrl("http://www.google.com")

        }
    }
}
