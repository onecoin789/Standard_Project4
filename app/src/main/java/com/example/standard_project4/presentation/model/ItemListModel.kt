package com.example.standard_mvvm.presentation.model

import android.os.Parcelable
import com.example.standard_mvvm.presentation.main.MultiViewEnum
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemListModel (
    val name: String,
    val card: String,
    val date: String,
    val price: Double,
    val type: MultiViewEnum
) : Parcelable

