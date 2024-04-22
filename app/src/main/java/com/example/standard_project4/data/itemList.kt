package com.example.standard_project4.data

import com.example.standard_project4.presentation.MultiViewAdapter.Companion.multi_type1
import com.example.standard_project4.presentation.MultiViewAdapter.Companion.multi_type2
import com.example.standard_project4.presentation.MultiViewAdapter.Companion.multi_type3


fun itemList(): MutableList<MyItem> {
    return arrayListOf(
        MyItem("Lee", "1234  5678  1234  5678", "12/ 24",3100.10, multi_type1),
        MyItem("Kim", "5456  5678  4452  2132", "11/ 23", 2500.00, multi_type2),
        MyItem("Kang", "4151  2138  5415  4514", "08/ 23", 6200.00, multi_type3),
        MyItem("Lim", "4841  4156  1230  5678", "04/ 25", 3900.20, multi_type1),
        MyItem("Ryu", "4235  4856  0412  8741", "03/ 26", 1800.00, multi_type2),
        MyItem("Park", "7862  5463  5463  5412", "09/ 26", 1500.30, multi_type3)
    )
}