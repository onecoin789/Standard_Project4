package com.example.standard_project4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.standard_project4.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bundle : Bundle? = intent.extras
        val name = bundle?.getString("name")
        val card = bundle?.getString("card")
        val date = bundle?.getString("date")
        val price = bundle?.getString("price")


        binding.textName.text = name
        binding.textCard.text = card
        binding.textDate.text = date
        binding.textPrice.text = price

        binding.btnBackDetail.setOnClickListener {
            finish()
        }


    }
}