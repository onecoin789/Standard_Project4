package com.example.standard_mvvm.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.standard_mvvm.data.database.DataSource
import com.example.standard_mvvm.data.repository.SearchRepositoryImpl
import com.example.standard_mvvm.presentation.model.ItemListModel
import com.example.standard_mvvm.presentation.repository.SearchRepository

class MainViewModel (private val searchRepository : SearchRepository) : ViewModel() {
    private val _getItemModel : MutableLiveData<List<ItemListModel>> = MutableLiveData()

    val getItemModel : LiveData<List<ItemListModel>> get() = _getItemModel

    fun getItemModel() {
        _getItemModel.value = searchRepository.getItemList()
    }
}

class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return MainViewModel(SearchRepositoryImpl(DataSource)) as T
    }
}
