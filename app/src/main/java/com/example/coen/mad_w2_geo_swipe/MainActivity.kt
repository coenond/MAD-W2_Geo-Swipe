package com.example.coen.mad_w2_geo_swipe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private var cityImages = ArrayList<CityImage>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fillImageArray()
    }

    private fun fillImageArray() {
        val images = arrayOf("img1_yes_denmark", "img2_no_canada", "img3_no_bangladesh",
                "img4_yes_kazachstan", "img5_no_colombia", "img6_yes_poland",
                "img7_yes_malta", "img8_no_thailand")

        for (image in images) {
            var parts = image.split("_")
            if (parts[0].startsWith("img")) {
                cityImages.add(CityImage(
                        parts[1] == "yes",
                        parts[2],
                        resources.getIdentifier("img1_yes_denmark", "drawable", packageName)
                ))
            }
        }
    }
}

class CityImage(isInEurope: Boolean, cityName: String, resourceId: Int) {
    val inEurope = isInEurope
    val city = cityName
    val resource = resourceId
}