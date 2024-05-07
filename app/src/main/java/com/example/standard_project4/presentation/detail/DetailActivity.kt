package com.example.standard_mvvm.presentation.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.standard_mvvm.presentation.model.ItemListModel
import com.example.standard_mvvm.util.decimal
import com.example.standard_project4.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    companion object {
        const val EXTRA_ITEM: String = "extra_item"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()


    }
    private fun initView() {
        val itemList = intent.getParcelableExtra<ItemListModel>(EXTRA_ITEM)
        binding.apply {
            textName.text = itemList?.name
            textCard.text = itemList?.card
            textDate.text = itemList?.date
            textPrice.text = decimal(itemList!!.price)

            initClickListener()
        }

    }


    private fun initClickListener() {
        binding.apply {
            btnBackDetail.setOnClickListener {
                finish()
            }
        }
    }
}