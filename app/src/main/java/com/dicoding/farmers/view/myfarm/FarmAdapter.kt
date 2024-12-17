package com.dicoding.farmers.view.myfarm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.farmers.R
import com.dicoding.farmers.data.Farm
import com.dicoding.farmers.databinding.ItemFamerBinding

class FarmAdapter: PagingDataAdapter<Farm, FarmAdapter.FarmViewHolder>(DIFF_CALLBACK) {
    class FarmViewHolder(private val binding: ItemFamerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(farm: Farm) {
            binding.tvName.text = farm.name
            binding.tvWeight.text = farm.weight.toString()
            binding.tvAge.text = farm.age.toString()
            binding.tvDescription.text = farm.description
        }
    }

    override fun onBindViewHolder(holder: FarmViewHolder, position: Int) {
        val farm = getItem(position)
        if (farm != null) {
            holder.bind(farm)
            if (position % 2 == 0){
                holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
            }
            else{
                holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.light_green))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmViewHolder {
        val binding = ItemFamerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FarmViewHolder(binding)
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Farm>() {
            override fun areItemsTheSame(oldItem: Farm, newItem: Farm): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Farm, newItem: Farm): Boolean {
                return oldItem == newItem
            }
        }

    }
}