package com.example.standard_project4.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.standard_project4.data.MyItem
import com.example.standard_project4.databinding.ActivityDetailBinding
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    companion object {
        const val EXTRA_ITEM: String = "extra_item"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val itemList = intent.getParcelableExtra<MyItem>(EXTRA_ITEM)

        binding.textName.text = itemList?.name
        binding.textCard.text = itemList?.card
        binding.textDate.text = itemList?.date
        binding.textPrice.text = DecimalFormat("\$ #,###.00").format(itemList?.price).toString()

        binding.btnBackDetail.setOnClickListener {
            finish()
        }


    }
}