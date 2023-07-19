package com.example.recipebook

import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.RecyclerView

class FoodViewHolder(private val containerView: View,
                     private val onClickListener: OnClickListener
    ) : RecyclerView.ViewHolder(containerView) {
    private val FoodNameView: TextView
            by lazy { containerView.findViewById(R.id.food_name) }
    private val FoodTypeView: TextView
            by lazy { containerView.findViewById(R.id.food_type) }

    fun bindData(foodData: FoodObject) {
        containerView.setOnClickListener { onClickListener.onClick(foodData) }
        FoodNameView.text = foodData.name;
        FoodTypeView.text = when (foodData.flavor) {
            FlavorType.savory -> "Savory"
            FlavorType.sweet -> "Sweet"
        }
    }

    interface OnClickListener {
        fun onClick(foodData: FoodObject)

        companion object
    }
}