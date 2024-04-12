package com.example.standard_project4

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standard_project4.Adapter.MultiViewAdapter
import com.example.standard_project4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val itemList = mutableListOf<MyItem>()
        itemList.apply {
            add(MyItem("Lee", "1234  5678  1234  5678", "12/ 24", "$3,100.10", multi_type1))
            add(MyItem("Kim", "5456  5678  4452  2132", "11/ 23", "$2,500.00", multi_type2))
            add(MyItem("Kang", "4151  2138  5415  4514", "08/ 23", "$6,200.00", multi_type3))
            add(MyItem("Lim", "4841  4156  1230  5678", "04/ 25", "$3,900.20", multi_type1))
            add(MyItem("Ryu", "4235  4856  0412  8741", "03/ 26", "$1,800.00", multi_type2))
            add(MyItem("Park", "7862  5463  5463  5412", "09/ 26", "$1,500.30", multi_type3))


            val adapter = MultiViewAdapter(itemList)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            adapter.notifyDataSetChanged()

            adapter.itemClick = object : MultiViewAdapter.ItemClick {
                override fun onClick(view: View, position: Int) {
                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    intent.putExtra("name", itemList[position].name)
                    intent.putExtra("card", itemList[position].card)
                    intent.putExtra("date", itemList[position].date)
                    intent.putExtra("price", itemList[position].price)
                    startActivity(intent)
                }
            }
        }
    }
}