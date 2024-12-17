package com.dicoding.farmers.view.inventory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.farmers.R
import com.dicoding.farmers.databinding.FragmentInventoryBinding
import com.dicoding.farmers.view.ViewModelFactory


class InventoryFragment : Fragment() {
    private var _binding: FragmentInventoryBinding? = null
    private val binding get() = _binding !!
    private lateinit var inventoryViewModel: InventoryViewModel
    private lateinit var inventoryAdapter: InventoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentInventoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory.getInstance(requireContext())
        inventoryViewModel = ViewModelProvider(this, factory)[InventoryViewModel::class.java]

        inventoryAdapter = InventoryAdapter()
        binding.recyclerViewInventory.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = inventoryAdapter
        }

        inventoryViewModel.getInventory().observe(viewLifecycleOwner){inventoryList->
            inventoryAdapter.submitList(inventoryList)
        }

        binding.fabAddInventory.setOnClickListener {
            findNavController().navigate(R.id.action_inventoryFragment_to_addInventoryFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}