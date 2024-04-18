package com.example.standard_project4.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standard_project4.data.MyItem
import com.example.standard_project4.databinding.RvItem1Binding
import com.example.standard_project4.databinding.RvItem2Binding
import com.example.standard_project4.databinding.RvItem3Binding
import java.text.DecimalFormat

class MultiViewAdapter(private var onClick: (MyItem) -> Unit ) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val multi_type1 = 0
        const val multi_type2 = 1
        const val multi_type3 = 2
    }

        var itemList = mutableListOf<MyItem>()

//    interface ItemClick {
//        fun onClick(view: View, position: Int)
//    }
//
//    var itemClick: ItemClick? = null


    override fun getItemCount(): Int = itemList.size


    override fun getItemViewType(position: Int): Int {
        return itemList[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            multi_type1 -> {
                val binding = RvItem1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                MultiViewHolder1(binding)
            }

            multi_type2 -> {
                val binding = RvItem2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                MultiViewHolder2(binding)
            }

            multi_type3 -> {
                val binding = RvItem3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                MultiViewHolder3(binding)
            }
            else -> throw IllegalArgumentException("onCreateViewHolder")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = itemList[position]

        when(itemList[position].type) {
            multi_type1 -> {
                (holder as MultiViewHolder1).bind(itemList[position])
                holder.setIsRecyclable(false)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }
            multi_type2 -> {
                (holder as MultiViewHolder2).bind(itemList[position])
                holder.setIsRecyclable(false)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }
            multi_type3 -> {
                (holder as MultiViewHolder3).bind(itemList[position])
                holder.setIsRecyclable(false)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }
        }
    }

    inner class MultiViewHolder1(private val binding: RvItem1Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyItem) {
            binding.apply {
                textName.text = item.name
                textCard.text = item.card
                textDate.text = item.date
                textPrice.text = DecimalFormat("\$ #,###.00").format(item.price).toString()
            }
        }
    }

    inner class MultiViewHolder2(private val binding: RvItem2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyItem) {
            binding.apply {
                textName.text = item.name
                textCard.text = item.card
                textDate.text = item.date
                textPrice.text = DecimalFormat("\$ #,###.00").format(item.price).toString()
            }
        }
    }

    inner class MultiViewHolder3(private val binding: RvItem3Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyItem) {
            binding.apply {
                textName.text = item.name
                textCard.text = item.card
                textDate.text = item.date
                textPrice.text = DecimalFormat("\$ #,###.00").format(item.price).toString()
            }
        }
    }

}
