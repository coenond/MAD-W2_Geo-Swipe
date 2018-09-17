package com.example.coen.mad_w2_geo_swipe

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.helper.ItemTouchHelper
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var cityImages = ArrayList<CityImage>()
    private val images = arrayOf(
            "img1_yes_denmark",
            "img2_no_canada",
            "img3_no_bangladesh",
            "img4_yes_kazachstan",
            "img5_no_colombia",
            "img6_yes_poland",
            "img7_yes_malta",
            "img8_no_thailand"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fillImageArray()
        rv_imagelist.adapter = ImageAdapter(cityImages, this)
        ItemTouchHelper(SwipeCallback(rv_imagelist, rv_imagelist.adapter as ImageAdapter)).attachToRecyclerView(rv_imagelist)
    }

    /**
     * Extract all the data from the filenames to create the list.
     */
    private fun fillImageArray() {
        for (image in images) {
            val parts = image.split("_")
            if (parts[0].startsWith("img")) {
                cityImages.add(CityImage(
                        parts[1] == "yes",
                        parts[2],
                        resources.getIdentifier(image, "drawable", this.packageName)
                ))
            }
        }
    }
}

/**
 * Class to hold all images.
 */
class CityImage(isInEurope: Boolean, cityName: String, resourceId: Int) {
    val inEurope = isInEurope
    val city = cityName
    val resource = resourceId
}