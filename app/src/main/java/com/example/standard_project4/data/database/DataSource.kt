package com.example.standard_mvvm.data.database

import com.example.standard_mvvm.data.entity.ItemEntity
import com.example.standard_mvvm.presentation.model.ItemListModel

object DataSource {

    fun getItemList(): List<ItemEntity> {
        return itemList()
    }
}
