package com.example.standard_project4.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MyItem(
    val name: String,
    val card: String,
    val date: String,
    val price: Double,
    val type: Int
) : Parcelable
