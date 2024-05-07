package com.example.standard_mvvm.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standard_mvvm.presentation.model.ItemListModel
import com.example.standard_mvvm.util.decimal
import com.example.standard_project4.databinding.RvItem1Binding
import com.example.standard_project4.databinding.RvItem2Binding
import com.example.standard_project4.databinding.RvItem3Binding
import com.example.standard_project4.databinding.UnknownItemBinding

class MultiViewAdapter(private var onClick: (ItemListModel) -> Unit ) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var itemList = listOf<ItemListModel>()


    override fun getItemCount(): Int = itemList.size


    override fun getItemViewType(position: Int): Int {
        return itemList[position].type.viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val MultiViewType = MultiViewEnum.entries.find { it.viewType == viewType }
        return when (MultiViewType) {
            MultiViewEnum.MULTI_TYPE1 -> {
                val binding =
                    RvItem1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                MultiViewHolder1(binding)
            }

            MultiViewEnum.MULTI_TYPE2 -> {
                val binding =
                    RvItem2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                MultiViewHolder2(binding)
            }

            MultiViewEnum.MULTI_TYPE3 -> {
                val binding =
                    RvItem3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                MultiViewHolder3(binding)
            }

            else -> {
                val binding =
                    UnknownItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                UnknownViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = itemList[position]

        when (holder) {
            is MultiViewHolder1 -> {
                holder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }

            is MultiViewHolder2 -> {
                holder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }

            is MultiViewHolder3 -> {
                holder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }
        }
    }

    class MultiViewHolder1(private val binding: RvItem1Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemListModel) {
            binding.apply {
                textName.text = item.name
                textCard.text = item.card
                textDate.text = item.date
                textPrice.text = decimal(item.price)
            }
        }
    }

    class MultiViewHolder2(private val binding: RvItem2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemListModel) {
            binding.apply {
                textName.text = item.name
                textCard.text = item.card
                textDate.text = item.date
                textPrice.text = decimal(item.price)
            }
        }
    }

    class MultiViewHolder3(private val binding: RvItem3Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemListModel) {
            binding.apply {
                textName.text = item.name
                textCard.text = item.card
                textDate.text = item.date
                textPrice.text = decimal(item.price)
            }
        }
    }

    class UnknownViewHolder(
        binding: UnknownItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() = Unit
    }
}
