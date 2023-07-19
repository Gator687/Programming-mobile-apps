package com.example.recipebook

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener

class FoodAdapter(
    private val layoutInflater: LayoutInflater,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<FoodViewHolder>() {
    private val FoodData = mutableListOf<FoodObject>()
    fun setData(employeesData: List<FoodObject>) {
        this.FoodData.clear()
        this.FoodData.addAll(employeesData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = layoutInflater.inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view, object :
            FoodViewHolder.OnClickListener {
            override fun onClick(foodData: FoodObject) {
                onClickListener.onItemClick(foodData)
            }
            })
    }
    override fun getItemCount() = FoodData.size

    override fun onBindViewHolder(holder: FoodViewHolder, position:Int) {
        holder.bindData(FoodData[position])
    }

    interface OnClickListener {
        fun onItemClick(foodData: FoodObject)
    }
}