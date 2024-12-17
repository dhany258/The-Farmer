package com.dicoding.farmers.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.replace
import androidx.navigation.fragment.findNavController
import com.dicoding.farmers.R
import com.dicoding.farmers.databinding.FragmentHomeBinding
import com.dicoding.farmers.view.myfarm.MyFarmFragment


class HomeFragment : Fragment() {
    private  var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardInventory.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_inventoryFragment)
        }

        binding.cardMyFarm.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_myFarmFragment)
        }

        binding.cardAnimals.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_animalsFragment)
        }
    }


}