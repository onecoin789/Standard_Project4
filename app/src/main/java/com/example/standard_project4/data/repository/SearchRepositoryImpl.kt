package com.example.standard_mvvm.data.repository

import com.example.standard_mvvm.data.database.DataSource
import com.example.standard_mvvm.presentation.repository.SearchRepository
import com.example.standard_mvvm.presentation.mapper.asItemListModel
import com.example.standard_mvvm.presentation.model.ItemListModel

class SearchRepositoryImpl(private val dataSource: DataSource) : SearchRepository {
    override fun getItemList() = dataSource.getItemList().asItemListModel()
}
