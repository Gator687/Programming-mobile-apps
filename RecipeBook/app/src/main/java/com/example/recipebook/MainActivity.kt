package com.example.recipebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val VIEW_TYPE_GROUP = 0
private const val VIEW_TYPE_FOOD = 1

class MainActivity : AppCompatActivity() {

    private val foodAdapter by lazy {
        FoodAdapter(
            layoutInflater,
            object : FoodAdapter.OnClickListener {
//                override fun onClick(foodData: FoodObject) = FoodViewHolder.OnClickListener.onItemClick(foodData)
                override fun onItemClick(foodData: FoodObject) {
                    showSelectionDialog(foodData)
                }
            }
        )
    }

    private val recyclerView: RecyclerView by lazy{
        findViewById(R.id.recycler_view) }


    /*
    override fun getItemViewType(position: Int) = when (FoodList[position]) {
        is FoodList.Group -> VIEW_TYPE_GROUP
        is FoodList.Food -> VIEW_TYPE_FOOD
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =   when (viewType) {
        VIEW_TYPE_GROUP -> {
            val view = layoutInflater.inflate(R.layout.item_food,
                parent, false)
            GroupViewHolder(view)
        }
        VIEW_TYPE_FOOD -> {
            val view = layoutInflater.inflate(R.layout.item_food, parent, false)
            FoodViewHolder(view, object :
                FoodViewHolder.OnClickListener {
                override fun onClick(foodData: FoodObject) = onClickListener.onItemClick(foodData)
            })
        }
        else -> throw IllegalArgumentException("Unknown view type requested:       $viewType")
    }
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = foodAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false)
        foodAdapter.setData(
            listOf(
                FoodObject(
                    "Apple pie",
                    "bake the recipe for 40 minutes!",
                    FlavorType.sweet
                ),
                FoodObject(
                    "Second Test Statement",
                    "This is another description!",
                    FlavorType.savory
                )
            )
        )
    }

    private fun showSelectionDialog(foodData: FoodObject) {
        AlertDialog.Builder(this)
            .setTitle("Recipe")
            .setMessage("${foodData.description}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}