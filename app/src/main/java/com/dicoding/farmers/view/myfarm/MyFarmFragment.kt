package com.dicoding.farmers.view.myfarm

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.farmers.R
import com.dicoding.farmers.data.Farm
import com.dicoding.farmers.databinding.FragmentMyFarmBinding
import com.dicoding.farmers.view.ViewModelFactory


class MyFarmFragment : Fragment() {
    private var _binding: FragmentMyFarmBinding? = null
    private val binding get() = _binding !!
    private lateinit var viewModel: MyFarmViewModel
    private lateinit var adapter: FarmAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMyFarmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory.getInstance(requireContext())
        viewModel = ViewModelProvider(this, factory)[MyFarmViewModel::class.java]

        binding.rvInventory.layoutManager = LinearLayoutManager(requireContext())
        adapter = FarmAdapter()

        binding.rvInventory.adapter = adapter
        viewModel.getAllFarm().observe(viewLifecycleOwner, Observer(this::updateData))
    }

    private fun updateData(farm: PagingData<Farm>){
        adapter.submitData(lifecycle,farm)
    }

}