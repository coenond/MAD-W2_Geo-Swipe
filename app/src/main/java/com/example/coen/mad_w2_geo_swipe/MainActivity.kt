package com.example.coen.mad_w2_geo_swipe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private var cityImages = ArrayList<CityImage>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}

class CityImage(isInEurope: Boolean, cityName: String, resourceId: Int) {
    val inEurope = isInEurope
    val city = cityName
    val resource = resourceId
}