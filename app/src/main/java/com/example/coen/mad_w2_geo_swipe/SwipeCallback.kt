package com.example.coen.mad_w2_geo_swipe

import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper

class SwipeCallback (private val recyclerView: RecyclerView, private val imageAdapter: ImageAdapter) :
        ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val item = imageAdapter.getItem(viewHolder.adapterPosition)
        val answer = "Your answer is: " + when {
            direction == ItemTouchHelper.RIGHT && item.inEurope -> "Correct! ${item.city} is in Europe."
            direction == ItemTouchHelper.RIGHT && !item.inEurope -> "Wrong! ${item.city} is in Europe."
            direction == ItemTouchHelper.LEFT && !item.inEurope -> "Correct! ${item.city} is not in Europe."
            direction == ItemTouchHelper.LEFT && item.inEurope -> "Wrong! ${item.city} is not in Europe."
            else -> "Oops."
        }

        // Notify user with the answer
        Snackbar.make(recyclerView, answer, Snackbar.LENGTH_LONG).show()

        // Notify that recyclerview item is changed to rerender the image
        imageAdapter.notifyItemChanged(viewHolder.adapterPosition)
    }

    /**
     * Return false because this function isn't used.
     */
    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        return false
    }

}