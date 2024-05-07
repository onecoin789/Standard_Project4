package com.example.standard_mvvm.data.entity

import com.example.standard_mvvm.presentation.main.MultiViewEnum

data class ItemEntity(
    val name: String,
    val card: String,
    val date: String,
    val price: Double,
    val type: MultiViewEnum
)

