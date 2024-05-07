package com.example.standard_mvvm.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standard_mvvm.presentation.detail.DetailActivity
import com.example.standard_mvvm.presentation.model.ItemListModel
import com.example.standard_mvvm.util.decimal
import com.example.standard_project4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val itemViewModel by viewModels<MainViewModel> {
        MainViewModelFactory()
    }

    private lateinit var itemList: List<ItemListModel>

    private val multiViewAdapter: MultiViewAdapter by lazy {
        MultiViewAdapter { item ->
            adapterOnclick(item)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViewModel()
        initData()
    }
    private fun initData() {
        itemViewModel.getItemModel()

    }
    private fun initViewModel() {
        itemViewModel.getItemModel.observe(this@MainActivity) {
            itemList = it

            initAdapterView()
        }
    }
    private fun initAdapterView() {
        multiViewAdapter.itemList = itemList
        with(binding.recyclerView) {
            adapter = multiViewAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            binding.tvBalance.text = decimal(2856.20)
        }
    }

    private fun adapterOnclick(item: ItemListModel) {

        val intent = Intent(this, DetailActivity::class.java)
        val bundle = Bundle()
        bundle.putParcelable(DetailActivity.EXTRA_ITEM, item)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}

