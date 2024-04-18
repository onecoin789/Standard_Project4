package com.example.standard_project4.data

import android.provider.ContactsContract.Data

class DataSource {
    companion object {
        private var INSTANCE: DataSource? = null
        fun getDataSource(): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
    }

    fun getItemList(): MutableList<MyItem> {
        return itemList()
    }
}