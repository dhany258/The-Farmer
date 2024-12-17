package com.dicoding.farmers.view.inventory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.farmers.data.Farm
import com.dicoding.farmers.data.Inventory
import com.dicoding.farmers.databinding.ItemInventoryBinding

class InventoryAdapter:
    ListAdapter<Inventory, InventoryAdapter.InventoryViewHolder>(DIFF_CALLBACK) {
    class InventoryViewHolder(private val binding: ItemInventoryBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(inventory: Inventory) {
            binding.textToolName.text = inventory.inventoryName
            binding.textToolQuantity.text = inventory.inventoryQuantity.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InventoryViewHolder {
        val binding = ItemInventoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InventoryViewHolder(binding)
    }


    override fun onBindViewHolder(holder: InventoryViewHolder, position: Int) {
        val inventory = getItem(position)
        holder.bind(inventory)
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Inventory>() {
            override fun areItemsTheSame(oldItem: Inventory, newItem: Inventory): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Inventory, newItem: Inventory): Boolean {
                return oldItem == newItem
            }
        }

    }

}