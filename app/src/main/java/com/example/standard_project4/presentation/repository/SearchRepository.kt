package com.example.standard_mvvm.presentation.repository

import com.example.standard_mvvm.presentation.model.ItemListModel

interface SearchRepository {
    fun getItemList() : List<ItemListModel>
}