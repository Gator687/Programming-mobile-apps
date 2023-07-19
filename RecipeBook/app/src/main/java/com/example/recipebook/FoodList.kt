package com.example.recipebook

import android.app.LauncherActivity

sealed class FoodList {
    data class Group(val name: String) : LauncherActivity.ListItem()
    data class Food(val data: FoodList) : LauncherActivity.ListItem()
}

