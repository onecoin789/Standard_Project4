package com.example.standard_project4.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standard_project4.data.MyItem
import com.example.standard_project4.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val itemViewModel by viewModels<ItemViewModel> {
        ItemViewModelFactory()
    }

    private val multiViewAdapter : MultiViewAdapter by lazy {
        MultiViewAdapter { item ->
            adapterOnclick(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvBalance.text = DecimalFormat("#,##,###.00").format(285856.20)



        multiViewAdapter.itemList = itemViewModel.itemLiveData

        with(binding.recyclerView) {
            adapter = multiViewAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun adapterOnclick(item: MyItem) {

        val intent = Intent(this, DetailActivity::class.java)
        val bundle = Bundle()
        bundle.putParcelable(DetailActivity.EXTRA_ITEM, item)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}