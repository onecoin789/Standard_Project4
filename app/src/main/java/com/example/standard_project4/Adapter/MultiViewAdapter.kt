package com.example.standard_project4.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.standard_project4.MyItem
import com.example.standard_project4.R
import com.example.standard_project4.databinding.ActivityMainBinding
import com.example.standard_project4.multi_type1
import com.example.standard_project4.multi_type2
import com.example.standard_project4.multi_type3

class MultiViewAdapter(private var itemList : MutableList<MyItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null


    override fun getItemCount(): Int = itemList.size


    override fun getItemViewType(position: Int): Int {
        return itemList[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view: View?
        return when (viewType) {
            multi_type1 -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item1, parent, false)
                MultiViewHolder1(view)
            }

            multi_type2 -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item2, parent, false)
                MultiViewHolder2(view)
            }

            else -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item3, parent, false)
                MultiViewHolder3(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }

        when(itemList[position].type) {
            multi_type1 -> {
                (holder as MultiViewHolder1).bind(itemList[position])
                holder.setIsRecyclable(false)
            }
            multi_type2 -> {
                (holder as MultiViewHolder2).bind(itemList[position])
                holder.setIsRecyclable(false)
            }
            else -> {
                (holder as MultiViewHolder3).bind(itemList[position])
                holder.setIsRecyclable(false)
            }
        }
    }

    inner class MultiViewHolder1(view: View) : RecyclerView.ViewHolder(view) {

        private val textName: TextView = view.findViewById(R.id.text_Name)
        private val textCard: TextView = view.findViewById(R.id.text_Card)
        private val textDate: TextView = view.findViewById(R.id.text_Date)
        private val textPrice: TextView = view.findViewById(R.id.text_Price)

        fun bind(item: MyItem) {
            textName.text = item.name
            textCard.text = item.card
            textDate.text = item.date
            textPrice.text = item.price
        }
    }

    inner class MultiViewHolder2(view: View) : RecyclerView.ViewHolder(view) {

        private val textName: TextView = view.findViewById(R.id.text_Name)
        private val textCard: TextView = view.findViewById(R.id.text_Card)
        private val textDate: TextView = view.findViewById(R.id.text_Date)
        private val textPrice: TextView = view.findViewById(R.id.text_Price)

        fun bind(item: MyItem) {
            textName.text = item.name
            textCard.text = item.card
            textDate.text = item.date
            textPrice.text = item.price
        }
    }

    inner class MultiViewHolder3(view: View) : RecyclerView.ViewHolder(view) {

        private val textName: TextView = view.findViewById(R.id.text_Name)
        private val textCard: TextView = view.findViewById(R.id.text_Card)
        private val textDate: TextView = view.findViewById(R.id.text_Date)
        private val textPrice: TextView = view.findViewById(R.id.text_Price)

        fun bind(item: MyItem) {
            textName.text = item.name
            textCard.text = item.card
            textDate.text = item.date
            textPrice.text = item.price
        }
    }

}
