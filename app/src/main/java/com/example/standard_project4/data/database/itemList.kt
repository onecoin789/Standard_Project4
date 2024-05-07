package com.example.standard_mvvm.data.database

import com.example.standard_mvvm.data.entity.ItemEntity
import com.example.standard_mvvm.presentation.main.MultiViewEnum
import com.example.standard_mvvm.presentation.model.ItemListModel

fun itemList(): List<ItemEntity> {
    return listOf(
        ItemEntity("Lee", "1234  5678  1234  5678", "12/ 24",3100.10, MultiViewEnum.MULTI_TYPE1),
        ItemEntity("Kim", "5456  5678  4452  2132", "11/ 23", 2500.00, MultiViewEnum.MULTI_TYPE2),
        ItemEntity("Kang", "4151  2138  5415  4514", "08/ 23", 6200.00, MultiViewEnum.MULTI_TYPE3),
        ItemEntity("Lim", "4841  4156  1230  5678", "04/ 25", 3900.20, MultiViewEnum.MULTI_TYPE3),
        ItemEntity("Ryu", "4235  4856  0412  8741", "03/ 26", 1800.00, MultiViewEnum.MULTI_TYPE2),
        ItemEntity("Park", "7862  5463  5463  5412", "09/ 26", 1500.30, MultiViewEnum.MULTI_TYPE1)
    )
}