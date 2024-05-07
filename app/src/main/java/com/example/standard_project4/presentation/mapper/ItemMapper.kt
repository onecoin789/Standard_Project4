package com.example.standard_mvvm.presentation.mapper

import com.example.standard_mvvm.data.entity.ItemEntity
import com.example.standard_mvvm.presentation.model.ItemListModel

fun List<ItemEntity>.asItemListModel() : List<ItemListModel> {
    return map {
        ItemListModel(
            it.name,
            it.card,
            it.date,
            it.price,
            it.type
        )
    }
}