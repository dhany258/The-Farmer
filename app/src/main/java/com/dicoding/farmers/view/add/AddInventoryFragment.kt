package com.dicoding.farmers.view.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.dicoding.farmers.R
import com.dicoding.farmers.databinding.FragmentAddInventoryBinding
import com.dicoding.farmers.view.ViewModelFactory
import com.google.android.material.snackbar.Snackbar


class AddInventoryFragment : Fragment() {
    private var _binding: FragmentAddInventoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var addInventoryViewModel: AddInventoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentAddInventoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory.getInstance(requireContext())
        addInventoryViewModel = ViewModelProvider(this, factory)[AddInventoryViewModel::class.java]
        binding.submitBtn.setOnClickListener{
            addInventory()
        }
    }

    private fun addInventory(){
        val name = binding.addEdName.text.toString().trim()
        val quantity = binding.addEdQuantity.text.toString().trim()
        val quantityValue = quantity.toInt()


        addInventoryViewModel.insertInventory(
            name = name,
            quantity = quantityValue
        )
        Snackbar.make(binding.root,"Inventory added successfully", Snackbar.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_addInventoryFragment_to_homeFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}